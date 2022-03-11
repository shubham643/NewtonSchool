// stock_prices: [5, 6, 1, 0, 2, 9] max_profit?
//          day     0  1  2  3  4  5
//                    +1    +7    +7 = 15
//                  5 4 3 2 1 - 0
//                  1 2 3 4 5 - 5
//                  [5, 1, 8, 2, 3, 5]
//                      b  s  b     s = 7 + 3 = 10
//1. max profit
//2. days when bought and sell

// 0. recursion
// 1. 2 pointers - find max and min -> O(n)
// 2. using stack, same as 2 pointer

import java.util.ArrayList;

class interval {
    public int buy;
    public int sell;
}

public class Stocks {
    private static int computeRec(int[] price, int start, int end) {
        // base condition
        if (start >= end) {
            return 0;
        }
        // lets say we buy at start
        // find next maximum value when we will sell
        int i;
        for(i = start + 1; i < end; i++) {
            if (price[i+1] - price[i] >= 0) {
                continue;
            }
            break;
            // now value has decreased, sell at i.
        }
        return price[i] - price[start] + computeRec(price, i+1, end);
        // progress recursion
    }

    public static void main(String[] args) {
        int[] price = {5, 6, 1, 0, 2, 9};
        int n = price.length;
//        System.out.println(computeRec(price, 0, n-1));
        System.out.println(compute(price, n));
    }

    private static int compute(int[] price, int n) {
        int i = 0;
        ArrayList<interval> res = new ArrayList<>();
        int count = 0;
        while(i < n) {
            // find minima to buy
            while(i < n-1 && price[i+1] < price[i]) {
                // value is declining
                i++;
            }
            interval in = new interval();
            if (i != n-1) {
                // we found local minima at i, hence buy at i
                in.buy = i;
            } else {
                break;
            }
            i++;
            // we have bought, now we want to sell
            while(i != n && price[i] >= price[i-1]) {
                i++;
            }
            // sell at i-1;
            in.sell = i-1;
            res.add(in);
            count++;
            i++;
        }
        int sum = 0;
        for(int j = 0; j < count; j++) {
            sum += price[res.get(j).sell] - price[res.get(j).buy];
        }
        return sum;
    }
}
// O(n)
