// https://excalidraw.com/#json=LnbE88_fScMfCwBQdkvQS,Wlw3fnrtTy_kb0OjJTY7lQ

// Bit Operators
// 1. left shift <<
// 2. right shift >>
// 3. Bitwise OR |
// 4. Bitwise And &
// 5. Bitwise Not !

import java.util.Scanner;

public class BinaryNumbers {

    public static void main(String[] args) {
//        int a = 6;
//        int b = a>>1;
//        System.out.println(b);
//
//
//        int c = a >> 2;
//        System.out.println(c); // 1
//
//        int d = c << 2;
//        System.out.println(d);

//        int a = 6; // 000000110
//        int b = 3; // 000000011
//
//        int e = a & b; // 00000010 ==> 2
//        int f = a | b; // 00000111 ==> 7
//        System.out.println("bitwise and : " + e + " bitwise or " + f);

//         Q: given an integer x, tell how many set bits are present in it?
//        int x;
//        Scanner sc = new Scanner(System.in);
//        x = sc.nextInt();
//        int counter = 0;
//        while(x != 0) {
////            if ((x & 1) == 1) {
////                // last bit is set
////                counter++;
////            }
//            counter += x & 1;
//            x = x >> 1;
//        }
//        System.out.println(counter);

        // Q: Given an integer x, print its binary form?

        int x = 10;
        int[] arr = new int[32]; // because java int has 4 bytes = 32 bits
        int k = 0;
        while(x != 0) {
            arr[k++] = x & 1;
            x >>= 1;
        }
        // reverse array now
        reverse(arr, k);
        for(int i = 0 ; i < k; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void reverse(int arr[], int k) {
        // using 2 pointers
        int i = 0;
        int j = k-1;

        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
