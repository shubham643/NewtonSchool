import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quicksort(arr, 0, n-1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quicksort(int[] arr, int start, int end) {
        // base condition
        if (start >= end) {
            return;
        }
        int pos = partition(arr, start, end);
        quicksort(arr, start, pos-1);
        quicksort(arr, pos+1, end);
    }

    private static int partition(int[] arr, int start, int end) { // O(n)
        int i = start;
        int j = start;
        while(j < end) {
            if (arr[j] <= arr[end]) {
                // swap
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        // put last element at ith position
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 1. parameter for a state = arr, start, end
    // 2. base condition = start >= end if only 1 element, no need to do anything
    // 3. how recursion proceeds = 1. pos = partition(arr, start, end) 2. quicksort(arr, left, pos-1) 3. quicksort(arr, pos+1, end)
    // 4. return type = void
}
