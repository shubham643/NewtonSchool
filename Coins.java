////// Amount = 100
///// denominations = [1, 2, 5, 7]
//
//
//// 1. take maximum denomination, divide -> greedy.. Complexity O(n) where n is number of deno.
////100
////14 coins of 7
////1 coin of 2
////15 coins is the answer
//// 2. divide and conquer
//
//intemediate state ... 1, 2, 3, 4, 5, 6, 7, ???
//save    [0 -1   1  -1  2   1   3   2   4 ]
//        0  1   2   3   4   5   6   7   8
//
//
//recursion: intermediate state f(X) --> f(X-2) + 1
//                                    f(X-5) + 1
//
//        base case.. if x = 0, answer should be 0.
//        if (x < 0) return -1;
//        f(x) = min(f(x-2), f(x-5)) + 1
//        loop
//         f(x) = min(f(x-a[i])) + 1
//
//
//
//amount = 8
//denominations [2, 5] ==> 4
//==> greedy fails

public class CoinsChange {
    // use memoization to save old results
    private static int[] save;

    private static int compute(int x, int[] arr) { // complexity
        // base case
        if (save[x] != Integer.MIN_VALUE) {
            // we have already computed for this value, get from save array
            return save[x];
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if (x - arr[i] < 0) {
                continue;
            }
            int temp = compute(x-arr[i], arr);
            if (temp == -1) {
                continue;
            }
            temp = temp + 1;
            min = Math.min(min, temp);
        }
        if (min != Integer.MAX_VALUE) {
            save[x] = min;
            return min;
        }
        save[x] = -1;
        return -1;
    }
     public static void main(String[] args) { //O(value*n)
         int[] arr = {1, 3, 5};
         int value = 1000;
         save = new int[value+1];
         save[0] = 0;
         for(int i = 1; i <= value; i++) {
             save[i] = Integer.MIN_VALUE;
         }
//         System.out.println(compute(value, arr));

         System.out.println(computeIt(value, arr));
     }

     private static int computeIt(int value, int[] arr) {
        int[] save = new int[value+1];
        save[0] = 0;
        for(int i = 1; i <= value; i++) {
            save[i] = -1;
        }
        for(int x = 1; x <= value; x++) {
            // x is intermediate state
            // check x with all denominations
            int minm = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length; j++) {
                int tempValue = x - arr[j];   //// 3-5
                if (tempValue >= 0 && save[tempValue] != -1) {
                    minm = Math.min(minm, 1+save[tempValue]);
                }
            }
            if (minm == Integer.MAX_VALUE) {
                save[x] = -1;
            } else {
                save[x] = minm;
            }
        }
        return save[value];
     }
}
