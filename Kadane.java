// [0, -1, 2, 5, 0, -6, 7] ==> 8, print the window [2, 6]
//

// time till 7:24
//[-2,-2, -1]
//window size > 0

// -1. recursive solution possible, but doesn't make sense here
// 0. prefix sum array: [0, -1, 8, -5, 6, 0, 7] n^2
// 1. print all subarrays, print with max sum --> n^2
// 2. current sum, overall sum. --> Kadane algorithm O(n)



public class KadaneAlgo {
    // i = 0->n-1
    // j = 0 -> i-1
    private static int compute(int[] val, int n) {
        int cur_sum = 0;
        int res = Integer.MIN_VALUE;
        int final_start_index = 0;
        int start_index = 0;
        int end_index = -1;
        for(int i = 0; i < n; i++) {
            cur_sum += val[i];
            if (res < cur_sum) {
                // we got a new completed window
                end_index = i;
                final_start_index = start_index;
                res = cur_sum;
            }
            if (cur_sum < 0) {
                start_index = i+1;
                // start new window from next element
                cur_sum = 0;
            }
        }
        System.out.println(final_start_index + ": " + end_index);
        return res;
    }
    public static void main(String[] args) {
        int[] val = {-1, -2, -3};
        int n = val.length;
        System.out.println(compute(val, n));
    }
}

// time complexity: O(n)
// memory:
