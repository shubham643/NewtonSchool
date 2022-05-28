// https://onedrive.live.com/redir?resid=DBDC82D341694B93%212183&page=Edit&wd=target%28Quick%20Notes.one%7C84dd2ba1-eb01-41dc-bf16-9fba7091089a%2FUntitled%20Page%7Ca09352af-c4ff-4eca-b03e-e1f58ed73ed3%2F%29

// class name = <file name>.java
// syntax
// comments.
// parenthesis
// conditions in bracket.
// ; semi colon
// conditional statements - if else, switch, ternary operator
// 1. if else.

// operators - >, <, =, !=, <=, >=

// conditional operators - ==



import java.util.Scanner;

/*
 This is my first java program
 I am loving it.
 */
public class Looping {
    public static void main(String[] args) {
//        int ab; // declaration a variable "a" of type "int"
//        //ab = 10; // defining
//        // take ab as input from user via console.
//        Scanner sc = new Scanner(System.in);
//        ab = sc.nextInt(); // use scanner type variable "sc", take integer input from console and assign it to ab
//
//        // if ab < 5, then its my birthday else not.
//        // java is not space/line sensitive
//        if (ab < 5) { // parenthesis, true = 1, false = 0
//           // do something
//            // ab is lesser than 5, it is my birthday
//            // output in the console
//            System.out.println("Hey, it is "); // ln means, go to new line at end
//            System.out.println("my birthday");
//        } else {
//            // do something
//            System.out.print("Hey, there is");
//            System.out.println("not birthday");
//        } // end the else statement


        // Take an input from console, if it is even print even else print odd
//        int a;
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt(); // = means assign right value to left
//        // say a = 99. ==> 1 ==> (1 == 0)
//        if (a % 2 == 0) { // % is modular operation. == os conditional equals
//            // even
//            System.out.println("Even");
//        } else {
//            // odd
//            System.out.println("Odd");
//        }

        // Q: take 2 integers from console, a and b, print which is bigger than other
//        int a, b;
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt();
//        b = sc.nextInt();
//        System.out.println("a is " + a + " and b is " + b); // here + is append operator
//        if (a > b) {
//            System.out.println("a > b ");
//        } else {
//            System.out.println("a < b");
//        }

        // if, else-if, else
//        int a, b;
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt();
//        b = sc.nextInt();
//        int p;
//        p = sc.nextInt();
//        // lets say a = 5, b = 5
//        if (a > b) {
//            System.out.println("a > b ");
//        } else if (a == b) {
//            System.out.println("a = b ");
//        } else if(a > p) {
//            System.out.println("a > p ");
//        } else {
//            System.out.println("a < b ");
//        }

//        int a, b;
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt();
//        b = sc.nextInt();
//        // 1st way
//        if (a > b) {
//            System.out.println("a > b ");
//        } else if (a == b) {
//            System.out.println("a = b ");
//        } else {
//            System.out.println("a < b ");
//        }
//
//        // 2nd way nested if.
//        if (a > b) {
//            System.out.println("a > b ");
//        } else {
//            if ( a == b) {
//                System.out.println("a = b ");
//            } else {
//                System.out.println("a < b ");
//            }
//        }
//        if (a > b) {
//            // do something.
//        }

        // conditional - switch
//        int a;
//        a = 10;
//        switch (a) {
//            case 5:  System.out.println("a is 5");
//                break;
//            case 10: System.out.println("a is 10");
//                break;
//            case 15: System.out.println("a is 15");
//                break;
//            default: System.out.println("i don't know what is a");
//        } // output - a is 10

//        int a;
//        a = 10;
//        switch (a) {
//            case 5:  System.out.println("a is 5");
//                break;
//            case 10: System.out.println("a is 10");
//            case 15: System.out.println("a is 15");
//                break;
//            default: System.out.println("i don't know what is a");
//        } // output -
//        a is 10
//        // a is 15

//        int a;
//        a = 10;
//        switch (a) {
//            case 5:  System.out.println("a is 5");
//                break;
//            case 10: System.out.println("a is 10");
//            case 15: System.out.println("a is 15");
//            default: System.out.println("i don't know what is a");
//        } // output -
//        // a is 10
//        // a is 15
//        // i don't know what a is

        // ternary operator
        int a;
        a= 5;
        int b;
//        Q: if a is odd, assign b as 10, else assign b as 100;
//        if (a % 2 == 0) {
//            b = 100;
//        } else {
//            // print odd
//            b = 10;
//        }
        // with ternary operator
        b = (a % 2 == 0) ? 100 : 10;
        //                 true  false

    }
}
