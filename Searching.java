// https://onedrive.live.com/redir?resid=DBDC82D341694B93%212195&page=Edit&wd=target%28Quick%20Notes.one%7C519065e1-3e5a-4677-9ea7-199d66c3c500%2FUntitled%20Page%7C664a8d1f-9819-471b-8566-654ea53cd2df%2F%29&wdorigin=NavigationUrl

// Searching
// 1. linear search
// 2. binary search

import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        // find an element x in array.
//
//
//        // 1. linear search
//        for(int i = 0; i < n; i++) { // O(n)
//            if (arr[i] == x) {
//                System.out.println("yaayy " + arr[i]);
//                break;
//            }
//        }

        // 2. binary search
        // for binary search array should be sorted.
        Arrays.sort(arr); // will implement in today's class,
        System.out.println("sorted array is ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // now starts the binary search
        // 1. base condition --> x == arr[mid], start should always be <= end
        // 2. return type --> int
        // 3. state parameters --> arr, n, start, end
        // 4. how to proceed the recursion --> move i or j

        System.out.print(binary_search(arr, n, 0, n-1, x));
    }

    private static int binary_search(int arr[], int n, int start, int end, int x) { // O(logn)
        // base condition
        int mid = (start + end)/2;
        if (arr[mid] == x) {
            return mid;
        }
        if (start > end) {
            return -1; // could not find
        }

        // proceed the recursion
        if (arr[mid] > x) {
            // search in left part
            return binary_search(arr, n, start, mid-1, x);
        } else {
            // search in right part
            return binary_search(arr, n, mid+1, end, x);
        }
    }

    // F(n) = F(n/2) + 1
//            = F(n/4) + 1 + 1
//              = F(n/n) + 1*logn = F(1) + logn = O(logn) // generalized it
}
