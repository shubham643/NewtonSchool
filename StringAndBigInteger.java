// https://excalidraw.com/#json=LnbE88_fScMfCwBQdkvQS,Wlw3fnrtTy_kb0OjJTY7lQ
// What is string, how we can use it like array, ascii, String as numbers, big integer

import java.math.BigInteger;
import java.util.Scanner;


public class StringAndBigInteger {
    public static void main(String[] args) {

//        String s = "i am shubham bansal, i like teaching";
//        s += ". But students don't like to be taught"; // appending
//
//        System.out.println(s);
//
//        System.out.println(s + " hahaha");
//
//        int a = 5;
//        s += a;
//        System.out.println(s);
//
//        Scanner sc = new Scanner(System.in);
//        String x = sc.nextLine(); // till we press enter (or return in mac) button
//        System.out.println(x);

        // String can also be accessed like an array
//        String y = "shubham bansal";
//        //          012456789.....
//        char first = y.charAt(0);
//        System.out.println(first);

//
        // say double has 8 bytes==> 8*8=64 bits ~2^64 ~10^18 is roughly the biggest number we can store in double
//        Q: How can you store a number of 100 digits
//        String u = "17465383920384746383920292387464493093747493403";
//        String v = "1746538392038474638378584034049585292387464493093747493403";
//        String sum = u+v; // append/concat --> 174653839203847463839202923874644930937474934031746538392038474638378584034049585292387464493093747493403
//
//        BigInteger num1 = new BigInteger("5");
//        BigInteger num2 = new BigInteger("6");
//        BigInteger summation = num1.add(num2);
//        String result = summation.toString();
//        System.out.println(result);

        char temp = '5'; // ascii of 0 is 48., ascii value of 5 is 53
        int a = temp;//        String s = "i am shubham bansal, i like teaching";
//        s += ". But students don't like to be taught"; // appending
//
//        System.out.println(s);
//
//        System.out.println(s + " hahaha");
//
//        int a = 5;
//        s += a;
//        System.out.println(s);
//
//        Scanner sc = new Scanner(System.in);
//        String x = sc.nextLine(); // till we press enter (or return in mac) button
//        System.out.println(x);

        // String can also be accessed like an array
//        String y = "shubham bansal";
//        //          012456789.....
//        char first = y.charAt(0);
//        System.out.println(first);

//
        // say double has 8 bytes==> 8*8=64 bits ~2^64 ~10^18 is roughly the biggest number we can store in double
//        Q: How can you store a number of 100 digits
//        String u = "17465383920384746383920292387464493093747493403";
//        String v = "1746538392038474638378584034049585292387464493093747493403";
//        String sum = u+v; // append/concat --> 174653839203847463839202923874644930937474934031746538392038474638378584034049585292387464493093747493403
//
//        BigInteger num1 = new BigInteger("5");
//        BigInteger num2 = new BigInteger("6");
//        BigInteger summation = num1.add(num2);
//        String result = summation.toString();
//        System.out.println(result);

        char tempff = '5'; // ascii of 0 is 48., ascii value of 5 is 53
        int pq = tempff;
        int rs = tempff - '0';
        System.out.println(pq);
        System.out.println(rs);

        // sum of 2 strings?
        // 0. String result = "";
        // 1. find length of both strings.
        // 2. int i = a.length()-1
        // 3. int j = b.length() - 1;
        // 4. int carry = 0;
        // 5. while(i>=0 && j >= 0)
        // 6.    int lastDigitA = a.charAt(i)-'0';
        // 7.    int lastDigitB = b.charAt(j)-'0';
        // 8.    finalSum = lastDigitA + lastDigitB + carry; // 15, carry 15/10 = 1
        // 9.    carry = finalSum/10;
        // 10.   finalSum = final%10;                        // 15%10 = 5;
        // 11.   result += '0' + finalSum
        // 12.   i--;j--;
        // 13. while(i>=0)
        // 14. while(j>=0)
        // 15. reverse the result
    }
}
