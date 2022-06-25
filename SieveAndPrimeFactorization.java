// https://excalidraw.com/#json=ZbJcki-ZO77QZ4eyqjLAP,RpjECAgK1TSFBwgcnN6Zww
// 1. simple solution = (n*(n+1)/2)
// 2. simple solution first opt = (n*(n+1)/2/2)
// 3. simple solution third opt = n*sqrt(n)
// 4. sieve = nloglogn
// 5. prime factorization using modified sieve

import java.util.Scanner;

public class Sieve {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        simpleSolution(n);
//        System.out.println();
//        simpleSolutionFirstOptimization(n);
//        System.out.println();
//        simpleSolutionSecondOptimization(n);
//        System.out.println();
//        sieve(n);
//        System.out.println();
        prime_divisors(n);
        System.out.println();
        prime_divisors_sieve_modification(n);
    }
    private static void simpleSolution(int n) { // (n*(n+1)/2)
        for(int i = 2; i <= n; i++) {
            int j;
            for(j = 2; j < i; j++) {
                if (i%j == 0) {
                    // i is divisible by j
                    break;
                }
            }
            if (j == i) {
                // it means loop didn't break hence i is prime number
                System.out.print(i + " ");
            }
        }
    }

    private static void simpleSolutionFirstOptimization(int n) { // (n*(n+1)/2/2)
        for(int i = 2; i <= n; i++) {
            int j;
            for(j = 2; j <= i/2; j++) {
                if (i%j == 0) {
                    // i is divisible by j
                    break;
                }
            }
            if (j > i/2) {
                // it means loop didn't break hence i is prime number
                System.out.print(i + " ");
            }
        }
    }

    private static void simpleSolutionSecondOptimization(int n) { // n*sqrt(n)
        for(int i = 2; i <= n; i++) {
            int j;
            for(j = 2; j*j <= i; j++) { // j*j = i is same as j = sqrt(i)
                if (i%j == 0) {
                    // i is divisible by j
                    break;
                }
            }
            if (j*j > i) {
                // it means loop didn't break hence i is prime number
                System.out.print(i + " ");
            }
        }
    }

    private static int[] sieve(int n) { // O(nloglogn)
        boolean[] arr = new boolean[n+1]; // tells whether index is prime or not
        // initially mark everything as prime number
        for(int i = 2; i <= n; i++) {
            arr[i] = true;
        }
        for(int i = 2; i*i <= n; i++) {
            if (arr[i] == true) {
                // it is a prime number
                // remove all its multiples
                for(int j = i*2; j <= n; j=j+i) {
                    arr[j] = false;
                }
            }
        }
        int[] result = new int[100];
        int k = 0;
        for(int i = 2; i <= n; i++) {
            if (arr[i] == true) {
//                System.out.print(i + " ");
                result[k++] = i;
            }
        }
        return result;
    }

    private static void prime_divisors(int n) { // O(nloglogn + something)
        // n = 180
        // while n > 1
        // 180/2 => n = 90
        // 90/2 => 45, 45/3 = 15, 15/3 = 5, 5/5 = 1
        int[] primeNumbers = sieve(n); // 2, 3, 5, 7, 11, 13...
        int i = 0;
        while(n > 1) {
            if (n%primeNumbers[i] == 0) {
                System.out.print(primeNumbers[i] + " "); // as i divides n and i is prime number, hence i is prime divisor
                n = n/primeNumbers[i];
            } else {
                i++;
            }
        }
    }

    private static void prime_divisors_sieve_modification(int n) {
        int[] arr = new int[n+1]; // arr[i] means smallest possible prime divisor of i
        // initially mark everything as prime number
        for(int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        for(int i = 2; i*i <= n; i++) {
            if (arr[i] == i) {
                // it is a prime number
                // set the value of all of its multiple as i.
                for(int j = i*2; j <= n; j=j+i) {
                    arr[j] = i;
                }
            }
        }

        // print all prime divisors of n
        while(n > 1) {
            System.out.print(arr[n] + " ");
            n = n/arr[n];
        }
    }
}
