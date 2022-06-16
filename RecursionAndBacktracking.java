// Recursion
// Things to note in recursion:
// 1. base condition --> if (i==n), print arr
// 2. Function Parameters  --> (arr, i, n)
// 3. How to proceed the recursion, put every element at i, and recursively call for i+1
// 4. return type of function ---> void

// https://onedrive.live.com/redir?resid=DBDC82D341694B93%212191&page=Edit&wd=target%28Quick%20Notes.one%7Cfabb2bfe-a7d8-4ef9-86be-b2046563966a%2FRecursion%7C9c5a4865-80e9-4e0d-858d-d6239f5d0a4e%2F%29&wdorigin=NavigationUrl
// 1. FActorial
// 2. fibonacci and any other functions
// 3. time complexity
// 4. permutations in array

import java.util.Scanner;

public class Recursion {

    private static int factorial(int n) { // O(n)
        // 1. base condition
        // 2. How should recursion proceed

        // base condition
        if (n == 1) {
            return 1;
        }

        // else proceed the recursion
        return n * factorial(n - 1); // return 2 * 1
    }

    private static int fibonacci(int n) { // O() // f(5)
        // 1. base case
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        // 2. proceed the recursion
        return fibonacci(n - 1) + fibonacci(n - 2); // call recursively // f(4) + f(3) ==> 3 + f(3) ==> 1+1
    }

    // T(n) = T(n-1) + T(n-2)
//            = T(n-2) + T(n-3) + T(n-2) = 2*T(n-2) + T(n-3)   --> iteration 1
//              = 2*[T(n-3) + T(n-4)] + T(n-3) = 3*T(n-3) + 2*T(n-4) --> iteration 2
//                = 3*[T(n-4) + T(n-5)] + 2*T(n-4) = 5*T(n-4) + 3*T(n-5) = iteration 3
//                8T(n-5) + 5T(n-6)  --> iteration 4
//                  2^(n-1)*T(n-2) + ..... = 2^(n)  generalization

    //    f(n) = 4f(n-3) + 5f(n-1) + 2f(n-2), f(1)=1,f(2)=5, f(3)=2, f(n)?
    private static int solve(int n) {
        // base conditions
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 5;
        } else if (n == 3) {
            return 2;
        }
        return 4 * solve(n - 3) + 5 * solve(n - 1) + 2 * solve(n - 2);
    }

    public static void main(String[] args) {
        // F(n) = n * F(n-1)
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        // Factorial by iteration
//        int result = 1;
//        for(int i = 1; i <= n; i++) { // O(n)
//            result *= i;
//        }
//        System.out.println(result);
//
        // Factorial by recursion
//        System.out.println(factorial(n));

        // Print nth fibonacci number
//        int n = sc.nextInt();
//        // 1. save all elements in an array
//        int[] arr = new int[n];
//        arr[0] = 1;
//        arr[1] = 1;
//        for(int i = 2; i < n; i++) { // time: O(n)    space: O(n)
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        System.out.println(arr[n-1]);
//
//        // 2. taking 2 variables
//        int prevPrev = 1;
//        int prev = 1;
//        for(int i = 3; i <= n; i++) { // time O(n) space O(2) = O(1) or constant space
//            int val = prevPrev + prev;
//            prevPrev = prev;
//            prev = val;
//        }
//        System.out.println(prev);
//
//        // 3. using recursion
//        System.out.println(fibonacci(n));
//    }

//    Q: given an array of n elements having unique elements. print all its permutations
//    Example: [1,2,3] = 123,132,321,312,213,231 == 3! = n*(n-1)*(n-2).... = O(n!)

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printPermutations(arr, 0, n);
        // Things to note in recursion:
        // 1. base condition --> if (i==n), print arr
        // 2. Function Parameters  --> (arr, i, n)
        // 3. How to proceed the recursion, put every element at i, and recursively call for i+1
        // 4. return type of function ---> void

    }

    private static void printPermutations(int[] arr, int i, int n) { // O(n*n!)
        // base condition
        if (i == n) {
            // print arr
            for(int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            // print new line
            System.out.println();
            return;
        }

        // put every element at ith position
        for(int j = i; j < n; j++) {
            // swap i and j element
            swap(arr, i, j);
            // recursively call for i+1
            printPermutations(arr, i+1, n);
            // backtrack, value become same as earlier
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
// 2^10 = 1000
//2^50 = (1000)^5 = 10^15
//2^51 = 2 * (10^15)
//
//1 second ~ 10^7
