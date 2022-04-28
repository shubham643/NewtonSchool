// 1. control structure - if else, ternary operator, switch, nested if
// 2. loops

import java.util.*;

public class ControlStructures {
    public static void main(String[] args) {
//        int a = 10; // int is datatype, a is variable, 10 is value.
//        int b = 5;
//        if (a < b) { // if condition is false
//            System.out.println("a<b"); // not execute
//        } else {
//            System.out.println("a>b"); // execute
//        }
//        System.out.println("nested if"); // not executed
//        if (a < b) { // false
//            System.out.println("a<b"); // not executed
//        } else if (a > b) { // true
//            System.out.println("a>b"); // execute
//        } else if (a >=b) {
//            System.out.println("a>=b"); // not executed
//        }
//        else {
//            System.out.println("a=b"); // not executed
//        }

        // ternary operator
                      // true  false
//        int x = a < b ? 100 : 1000; // a = 10, b = 5. a < b ==> false
        // int x;
//        if (a < b) {
//            x = 100;
//        } else {
//            x = 1000;
//        }
//        System.out.println("value of x is " + x);
        // in else if we can provide condition
        // in else, we can't provide condition
        Scanner sc = new Scanner(System.in); // syntax to take input from user
//        System.out.println("provide input x");
//        int x = sc.nextInt(); // it takes an integer input from us and assign to x
//        System.out.println("provide input y");
//        int y = sc.nextInt(); // it takes an integer input from us and assign to y
//        if (x > y) { // x=100,y=50 // true
//            System.out.println("x > y");
//        } else if (x == y) {
//            System.out.println("x = y");
//        } else {
//            System.out.println("x < y");
//        }
//        System.out.println("provide floating input a");
//        float a = sc.nextFloat();
//        System.out.println("a floating value is " + a);
//        System.out.println("provide double input a");
//        double a = sc.nextDouble();
//        System.out.println("a double value is " + a);
//        System.out.println("provide string input a");
//        String a = sc.nextLine();
//        System.out.println("a string value is " + a);
//        System.out.println("provide int a");
//        int a = sc.nextInt();
//        System.out.println("provide int b");
//        int b = sc.nextInt();
//        int val = a > b ? a:b;
//        System.out.println("val is " + val);
//        int a;
//        System.out.println("provide int a");
//        a = sc.nextInt();
//        switch (a) { // condition on a.
//            case 10: System.out.print("a is 10"); // execute this if a = 10
//                break;
//            case 100: System.out.print("a is 100"); // execute this if a = 100
//                break;
//            case 1000: System.out.print("a is 1000"); // execute this if a = 1000
//                break;
//            default: System.out.print("some other value"); // execute this if a is not in {10,100,1000}
//        }
//        String a; // declare, declare variables only once
//        System.out.println("provide string a");
//        a = sc.nextLine(); // define
//        switch (a) { // condition on a.
//            case "shubham bansal": System.out.println("a is shubham bansal"); // execute this if a = 10
//                break;
//            case "sanchit": System.out.println("a is sanchit"); // execute this if a = 100
////                break;
//            case "meera": System.out.println("a is meera"); // execute this if a = 1000
////                break;
//            default: System.out.println("some other string"); // execute this if a is not in {10,100,1000}
//        }

        // nested if
//        System.out.println("provide int a");
//        int a = sc.nextInt();
//        System.out.println("provide int b");
//        int b = sc.nextInt();
//        if (a > b) {
//            System.out.println("a>b");
//        } else {
//            if (a == b) {
//                System.out.println("a=b");
//            } else {
//                System.out.println("a<b");
//            }
//        }

        // Loops
        // print all numbers from 1 to 10 using loop
//        for(int i = 1; i <= 4; i++) {
//            System.out.print(i + " ");
//        }
        // 1. int i = 1 ==> create variable i and assign value 1 to it. This is done only once
        // 2. i <= 4 ==> check if i <= 4, if yes then execute things under curly braces else come outside loop;
        // 3. System.out.print(i + " ");
        // 4. i++ => increment i by one.
        // 5. go back to statement 2.
        //output : 1 2 3 4
//        for(int i = 0; i < 5; i++) {
//            System.out.print(i + " "); // 0 1 2 3 4
//        }
//        for(int i = 0; i == 0;) {
//            System.out.print(i + " "); // 0 0 0 0 0 0 0 0 0 0....... infinitely
//        }
//        for(int i = 5; i > 0; i--) {
//            System.out.print(i + " "); // 5 4 3 2 1
//        }
//        for(int i = 5; i >= 0; i--) {
//            System.out.print(i + " "); // 5 4 3 2 1 0
//        }

//        for (int i = 0; i < 10; i++) {
//            if (i == 5) {
//                break; // go out of the loop
//            }
//            System.out.print(i + " "); // 0 1 2 3 4
//        }
//        for (int i = 0; i < 10; i++) {
//            if (i == 5) {
//                continue; // go to next iteration in loop
//            }
//            System.out.print(i + " "); // 0 1 2 3 4 6 7 8 9     5 is skipped
//        }

//        for (int i = 0; i < 6; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i + " even");
//            } else {
//                System.out.println(i + "odd");
//            }
//        }
//        for (int i = 0; i < 6; i++) {
//            if (i % 3 == 0) {
//                System.out.println(i + "remainder 0");
//            } else if(i%3 == 1) {
//                System.out.println(i + "remainder 1");
//            } else {
//                System.out.println(i + "remainder 2");
//            }
//        }
        // Q: take an integer n, print * n times on new line?
//        int n = sc.nextInt();
//        for(int i = 0; i < n; i++) {
//            System.out.println("*");
//        }
        // Q: take an integer n, print * and / alternatively n times
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            if (i%2 == 0) {
                System.out.print("*");
            } else {
                System.out.print("/");
            }
        }
    }
}
