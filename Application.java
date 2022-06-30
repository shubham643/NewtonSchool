// https://excalidraw.com/#json=ilDgfbvHd2ctypu_NokLt,yTdZu2D-Ge3c0jzRHxzXuQ
//     1. Constructors and its types, memory allocation in java
//     2. Stack DS, complexity, theory, its implementation by ourselves, Java stack library and its usage

import java.util.Scanner;
import java.util.Stack;

public class Application {

    static class Student {
        String name;
        int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        // Our own stack implementation

//        StackDS stk1 = new StackDS();
//        StackDS stk2 = new StackDS(100);
//        StackDS stk3 = new StackDS(stk2); // stk3 is a different object altogether, but uses same configurations as stk2
//
//        stk1.push(5);
//        stk2.push(5);
//        stk3.push(5);
//
//        int topMost1 = stk1.top();
//        int topMost2 = stk2.top();
//        int topMost3 = stk3.top();
//        System.out.println("top of stack 1 is " + topMost1);
//        System.out.println("top of stack 2 is " + topMost2);
//        System.out.println("top of stack 3 is " + topMost3);
//
//        boolean isEmpty = stk1.isEmpty();
//        int val = stk1.pop();
//        stk1.push(10);
//        stk1.push(15);
//
//        // Use java stack implementation
//
//        Stack<Integer> stk = new Stack<>();
//        stk.push(5);
//        int topmost = stk.peek(); // to see top element
//        int popValue = stk.pop();
//        boolean isStkEmpty = stk.isEmpty();
//
//        Stack<Student> stkStudent = new Stack<>();
//        Student student1 = new Student("shubham", 27);
//        Student student2 = new Student("yash", 34);
//        Student student3 = new Student("ram", 4);
//        stkStudent.push(student2);
//        stkStudent.push(student1);
//        stkStudent.push(student3);
//
//        // do some stack questions
        stackQuestions();
    }

    private static void stackQuestions(){
        // reverseArray
//        reverseArray();

//        boolean result = validParenthesis();
//        System.out.println("parenthesis is " + result);

        nextGreater();
    }

    private static void reverseArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // reverse now
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            stk.push(arr[i]);
        }

        // fill the array again
        for(int i = 0; i < n; i++) {
            arr[i] = stk.pop();
        }
        // print
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static boolean validParenthesis() { // {[()]} valid, {[(])} invalid
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 6 case : () [] {}
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stk.push(c);
                    break;
                case ')':
                    if (stk.isEmpty() || stk.peek() != '(') {
                        return false;
                    }
                    stk.pop();
                    break;
                case '}':
                    if (stk.isEmpty() || stk.peek() != '{') {
                        return false;
                    }
                    stk.pop();
                    break;
                case ']':
                    if (stk.isEmpty() || stk.peek() != '[') {
                        return false;
                    }
                    stk.pop();
                    break;
                default: return false;
            }
        }
        if (stk.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void nextGreater() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bruteforceNextGreater(arr, n);
        System.out.println();
        stackNextGreater(arr, n);
    }

    private static void bruteforceNextGreater(int[] arr, int n) { // O(n^2)
        for(int i = 0; i < n-1; i++) {
            int j;
            for(j = i+1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    // found next greater element
                    arr[i] = j;
                    break;
                }
            }
            if (j == n) {
                // could not find greater element
                arr[i] = -1;
            }
        }
        arr[n-1] = -1;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void stackNextGreater(int[] arr, int n) { // O(2*n)
        // 1. if stack top index's value is > current index then
        //    1.1 answer for current index is stack top
        //    1.2 push current index in stack
        // 2. else
        //    2.1 keep popping from the stack till either stack is empty or step 1 is true

        Stack<Integer> stk = new Stack<>(); // stack will only contain indexes
        int[] res = new int[n];
        res[n-1] = -1;
        stk.push(n-1); // push last element in the stack

        for(int i = n-2; i >= 0; i--) {
            // keep on popping frm stack till current item is greater than value of stack top
            while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stk.peek();
            }
            // push the current index
            stk.push(i);
        }
        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
