public class Kadane {
    private static int compute(int[] arr, int n) {
        int max_ = Integer.MIN_VALUE;
        int i = 0;
        int start = 0;
        int end = -1;
        int sum_till_now = 0;
        for (i = 0; i < n; i++) {
            sum_till_now += arr[i];
            if (sum_till_now > max_) {
                max_ = sum_till_now;
                end = i;
            }
            if (sum_till_now < 0) {
                sum_till_now = 0;
                start = i+1;
            }
        }
        if (end < start) {
            end = n-1;
        }
        System.out.println(start + " " + end);
        return max_;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        System.out.println(compute(arr, n));
    }
}
