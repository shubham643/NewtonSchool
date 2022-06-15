import java.util.Scanner;

import static java.util.Arrays.sort;

// Summary:
// White board link: https://onedrive.live.com/redir?resid=DBDC82D341694B93%212187&page=Edit&wd=target%28Quick%20Notes.one%7C9a05fb1b-1372-48b0-b4f2-b6bceab48e52%2FUntitled%20Page%7C44e7776e-8087-4eeb-a3ca-d4a0cc335e72%2F%29&wdorigin=NavigationUrl
// 2 pointers - normal and sliding window (questions)
// Time complexity

public class TwoPointers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        // normal looping
//        for(int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            System.out.println(arr[i] + " ");
//        }

//        int i = 0; // only one pointer, which i
//        while(i < n) {
//            System.out.println(arr[i] + " ");
//            i++;
//        }

        // 2 pointer - there will be 2 pointers
//        int i;
//        int j;
        // Q: Given array and a number X. Tell any pair exists in array whose sum = X?
//        int x = sc.nextInt();
//        // 1. Run 2 loops and check it. O(n^2)
//        for(int i = 0; i < n; i++) {
//            for(int j = i+1; j < n; j++) {
//                if (arr[i] + arr[j] == x) {
//                    System.out.println("We got number " + arr[i] + " " + arr[j]);
//                }
//            }
//        }

        // 2. sort the array, then do binary search
        //  1. sort array, 2. run loop for each element and do binary search
        //     for X - arr[i]. O(nlogn + n*logn) = O(2*nlogn) = O(nlogn)

//        sort(arr, n); // O(nlogn)
//        for(int i = 0; i < n; i++) { // O(n*logn)
//            int value = arr[i];
//            int requiredValue = x - value;
//            // search requiredValue in arr using binary search
//            boolean isRequiredValuePresent = binarySearch(arr, n, requiredValue);
//            if (isRequiredValuePresent == true) {
//                System.out.println("Yes we got the pair");
//            }
//        }

        // 3. using 2 pointers P(nlogn + n)
        // time complexity - number of computations
        // sort the array
//        sort(arr);
//        System.out.println("sorted array is: ");
//        for(int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        int i = 0;
//        int j = n-1;
//        while(i < j) { // run a loop
//            int sum = arr[i] + arr[j];
//            if (sum == x) {
//                // we got the answer
//                System.out.println("yay we got the sum " + arr[i] + " " + arr[j]);
//                break;
//            } else if (sum < x) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        if (i >= j) {
//            // it means we haven't find the pair
//            System.out.println("We couldn't find the pair");
//        }


        // Q: given array of 0s and 1s, print max length of sequential 1s
        // approach 2 pointes (or sliding window) O()
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // only 0 and 1 allowed
        }
        // take 2 pointers
        int i = -1; // i -1 means currently we are not in any window
        int j = 0;
        int max = 0;
        int finalStart = -1;
        int finalEnd = -1;
        while(j < n) {
            while(j < n && arr[j] == 0) { // skip all 0s
                j++;
            }
            if (j == n) {
                break;
            }
            // we have received a 1. start a new window
            i = j;
            // move j till the window ends
            while(j < n && arr[j] == 1) {
                j++;
            }
            // after the window has ended, update the max if required
            if (j - i > max) {
                // update the result
                max = j-i;
                finalStart = i;
                finalEnd = j-1;
            }
            i = -1;
        }
        System.out.println("Max length is " + max + ". window is " + finalStart + " " + finalEnd);

//
        // tell the complexit of these 2 code
        // 1.
//        int n = 5;
//        int count = 1;
//        for(int i = 0; i < n; i++) { // O(n*n*n) = O(n^3)
//            for(int j = 0; j < n; j++) {
//                for(int k = 0; k < n; k++) {
//                    System.out.println("haha " + count++);
//                }
//            }
//        }
//        System.out.println("YAAYyy first one is done");
//        // 2.
//        count = 1;
//        for(int i = 0; i < n; i++) { // O(n * (n+n)) = O(n^2 + n^2) = O(2 * n^2) = O(n^2)
//            for(int j = 0; j < n; j++) {
//                System.out.println("haha " + count++);
//            }
//            for(int k = 0; k < n; k++) {
//                System.out.println("haha " + count++);
//            }
//        }


    }
//    private static void sort(int[] arr, int n) { // merge sort O(nlogn)
//        // assume this method sorts the array using merge sort
//    }

    private static boolean binarySearch(int arr[], int n, int requiredValue) { // O(logn)
        return false;
    }
}
