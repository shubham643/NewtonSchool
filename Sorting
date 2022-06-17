// 1. selection sort
// 2. merge sort
// https://onedrive.live.com/redir?resid=DBDC82D341694B93%212195&page=Edit&wd=target%28Quick%20Notes.one%7C519065e1-3e5a-4677-9ea7-199d66c3c500%2FUntitled%20Page%7C664a8d1f-9819-471b-8566-654ea53cd2df%2F%29&wdorigin=NavigationUrl
// https://excalidraw.com/#json=h8OZ_jx6nRY_-NIryu95H,sSHiPFTS_qndmEzGhq8hsQ

import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. selection sort
//        selection_sort(arr, n);
//        for(int i = 0; i < n; i++) { // O(n^2) --> n * n
//            for(int j = 0; j < n; j++) {
//                // something
//            }
//        }
        // 2. merge sort
        merge_sort(arr, 0, n-1);
        print(arr, n);
    }

    public static void selection_sort(int[] arr, int n) {
        for(int i = 0; i < n; i++) { // O(n^2)
            // we want to finalize position i
            int minm = i; // index of minimum
            for(int j = i; j < n; j++) {
                if (arr[j] < arr[minm]) {
                    minm = j;
                }
            }
            // we now know that minm is smallest index.
            // swap arr[i] with arr[minm]
            swap(arr, i, minm);
        }
        print(arr, n);
        // n + (n-1) + (n-2) + .... (0) n times
        //  = n*n + (-1 -2 -3 -4 -5 -6 ... n times)
        //  = n*n - n*(n+1)/2 = n*n/2 - n/2 = O(n*n/2) = O(n*n) = O(n^2).
    }
    public static void print(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void merge_sort(int[] arr, int start, int end) { // time O(nlogn), space complexity O(n)
        // find mid
        // sort left part
        // sort right part
        // merge both sorted left and right O(n)
        if (start >= end) {
            return;
        }
        int mid = (start + end)/2;
        // left sort
        merge_sort(arr, start, mid);
        // right sort
        merge_sort(arr, mid+1, end);
        // inside arr, start->mid is sorted.... mid+1->end is sorted.
        merge(arr, start, mid, end);

        // T(n) = T(n/2) + T(n/2) + n
        //      = 2T(n/2) + n
//                = 2[2T(n/4) + n/2] + n = 4T(n/4) + n + n .. ith iteration
//                  lets say n = i^i... means i = logn.
//                  = 2^iT(n/2^i) + i*n = n + nlogn = O(nlogn)
    }

    public static void merge(int[] arr, int start, int mid, int end) { // O(end-start+1) = O(n)
        // 1. distribute array into 2 parts for left and right
        // 2. merge both the arrays into actual array arr.

        // distribute into 2 parts
        int sizeFirst = mid-start+1; // first array from start->mid      1 2 3 4 5
        int sizeSecond = end-mid;           // mid+1->end
        int[] first = new int[sizeFirst];
        int[] second = new int[sizeSecond];

        // put elements in first and second
        // for first array
        int k = 0;
        for(int i = start; i <= mid; i++) {
            first[k++] = arr[i];
        }
        // for second array
        k = 0;
        for(int i = mid+1; i <= end; i++) {
            second[k++] = arr[i];
        }
        // now do the merging
        k = start; // k starts from start index
        int i = 0; // first array
        int j = 0; // second array
        while(i < sizeFirst && j < sizeSecond) {
            if (first[i] < second[j]) {
                arr[k++] = first[i++];
            } else {
                arr[k++] = second[j++];
            }
        }
        // finish i
        while(i < sizeFirst) {
            arr[k++] = first[i++];
        }
        // finish j
        while(j < sizeSecond) {
            arr[k++] = second[j++];
        }
        // now merging is done and stored in our actual array arr.
    }

    // both arr1 and arr2 are sorted
    public static void merge_arrays(int[] arr1, int[] arr2, int n, int m) {
        int i = 0; // on arr1
        int j = 0; // on arr2
        int[] res = new int[n+m];
        int k = 0; // to store minimum value in result
        while(i < n && j < m) {
            if (arr1[i] < arr1[j]) {
                res[k++] = arr1[i++]; // ++ should be post, not pre
            } else {
                res[k++] = arr2[j++];
            }
        }
        // it may happen that i is finished or j is finished
        // if i is not finished
        while(i < n) {
            res[k++] = arr1[i++];
        }
        // if j is not finished
        while(j < m) {
            res[k++] = arr2[j++];
        }
        for(int x = 0; x < n+m; x++) {
            System.out.print(res[x] + " ");
        }
    }
}
