// https://excalidraw.com/#json=ilDgfbvHd2ctypu_NokLt,yTdZu2D-Ge3c0jzRHxzXuQ
//     1. Constructors and its types, memory allocation in java
//     2. Stack DS, complexity, theory, its implementation by ourselves, Java stack library and its usage

import java.util.Scanner;

public class StackDS {

    private int[] stk; // declaration, no memory allocation
    private int maxSize; // declaration
    private int top; // declaration

    // we don't need to implement this default constructor, java automatically creates it.
    // default constructor
    public StackDS() {
        maxSize = 100000; // definition -> allocates memory as well
        top = 0; // definition -> allocates memory as well. Another way to do is use top = -1.
        stk = new int[maxSize]; // definition -> allocates memory as well
    }

    // parametrized constructor
    public StackDS(int size) {
        maxSize = size;
        top = 0;
        stk = new int[maxSize];
    }

    // copy constructor
    public StackDS(StackDS anotherStack) {
        this.maxSize = anotherStack.maxSize;
        stk = new int[maxSize];
        top = 0;
    }

    public void push(int val) { // O(1)
        // check if stack is already full
        if (top == maxSize) {
            // stack is full
            System.out.println("stack already full");
            return;
        }
        // put an element val on top of stack
        stk[top] = val;
        top++;

        // if top initially is -1, stk[++top]=val;
    }

    public int top() { // or peek // O(1)
        // check if stack is empty
        if (isEmpty()) {
            // stack is empty
            System.out.println("stack is empty, can't see top element");
        }
        // return top element of stack
        return stk[top-1];

        // if top initially is -1, return stk[top]
    }

    public int pop() { // O(1)
        // check if stack is empty
        if (isEmpty()) {
            System.out.println("stack is empty, can't pop");
        }
        // extrack topmost elemnt from stack
//        top--;
//        return stk[top];
        return stk[--top];

        // if top initially is -1, return stk[top--]
    }

    public boolean isEmpty() { // O(1)
        // returns whether stack is empty or not
        if (top == 0) {
            return true;
        }
        return false;
    }

    // if top initially is -1, if top == -1 then stack is empty
}
