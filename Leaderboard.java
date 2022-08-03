// https://excalidraw.com/#json=9w7sH8yLERLkqRXWb62XE,5rJzGKmmeOxcWWYSk3gVQA

import java.util.Arrays;
import java.util.Scanner;

public class Leaderboard {

    private static void reverse(int[] arr, int n) {
        int i = 0;
        int j = n-1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] secondArray = new int[m];
        for(int i = 0; i < m; i++) {
            secondArray[i] = sc.nextInt();
        }

        // input reading done
        solve(n, arr, m, secondArray);
    }

    private static void solve(int n, int[] arr, int m, int[] secondArray) {
        // arr is already descending
        // remove duplicates in arr.
        n = removeDuplicates(arr, n);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        // linear search
        long startTime1 = System.currentTimeMillis();
        linearSearch(arr, n, secondArray, m);
        long endTime1 = System.currentTimeMillis();
        long linearTime = endTime1-startTime1;
        // binary search
        long startTime2 = System.currentTimeMillis();
        binarySearchApproach(arr, n, secondArray, m);
        long endTime2 = System.currentTimeMillis();
        long binaryTime = endTime2-startTime2;

        System.out.println("time taken linear: " + linearTime + " binary: " + binaryTime);
    }

    private static void binarySearchApproach(int[] arr, int n, int[] secondArray, int m) {
        for(int i = 0; i < m; i++) {
            int elementToCheck = secondArray[i];
            // check the position using binary search
            int index = binarySearch(arr, 0, n-1, elementToCheck);
//            System.out.print(index+1);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int val) {
        // base case
        if (start == end && val > arr[start]) {
            return start;
        } else if(start == end && val < arr[start]) {
            return start+1;
        } else if (start < end) {
            return start;
        }

        int mid = (start+end)/2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            // descending order, hence left side
            return binarySearch(arr, start, mid-1, val);
        } else {
            // in right side
            return binarySearch(arr, mid+1, end, val);
        }
    }


    private static void linearSearch(int[] arr, int n, int[] secondArray, int m) {
        for(int i = 0; i < m; i++) {
            int elementToCheck = secondArray[i];
            // for every element in secondArray, find index in arr
            int j;
            for(j = 0; j < n; j++) {
                if (arr[j] <= elementToCheck) {
                    break;
                }
            }
            System.out.println(j+1);
        }
    }


    private static int removeDuplicates(int[] arr, int n) {
        // 2 pointer approach to remove duplicates
        int i = 0;
        int j = 0;
        while(j != n) {
            // run j till j is last element or arr[j+1] != arr[j]
            while(j != n-1 && arr[j+1] == arr[j]) {
                j++;
            }
            // put j value at ith position
            arr[i] = arr[j];
            i++;
            j++;
        }
        return i; // i is the new size of array.
    }
}

// 100 100 50 50 40 20 -> 100 50 40 20
