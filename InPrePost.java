// https://excalidraw.com/#json=ZKtDqwDkNZuqo_oDVPLxm,jtrjRTb8cLDBg9jJrlwngg

// Rules
// 1. infix -> post, pre --> operator and brackets in stack
// 2. evaluation -> operand in stack
// 3. stack precedence should always be non decreasing from bottom to top.


// evaluation - stack contains operand, after receiving operator remove top 2 from stack and perform action
// infix -> postfix -> always remember this as this will be re-used. Put operator in stack.
// infix -> prefix -> reverse with brackes + convert to postfix + reverse
// prefix -> infix -->
// prefix -> infix --> do in evaluation manner and start from right (we always want to handle operator later)
// postfix -> infix --> do in evaluation manner and start from left (we always want to handle operator later)

import java.util.Scanner;
import java.util.Stack;

public class PreInPostNotations {

    public static void main(String[] args) {
        infixToPostfix();
        evaluatePostfix();
        infixToPrefix();
    }

    private static void infixToPrefix() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        String s = sc.nextLine();

//        1. s = reverse(s); // keep note that opening bracket becomes closing and closing becomes opening.
//        2. infixToPostfix(s)
//        3. reverse(s)
    }

    private static void evaluatePostfix() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        String s = sc.nextLine();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if operand then put in stack
            if (!isOperator(c)) {
                stk.push(c - '0'); // i am assuming that input string has only 1 digit numbers
            } else {
                // it is operator. pop 2 elemets, evaluate and push back to stack
                int second = stk.pop();
                int first = stk.pop();
                // perform the operation
                int val = perform(first, second, c);
                stk.push(val);
            }
        }
        System.out.print(stk.peek());// topmost element is answer
    }

    private static int perform(int first, int second, char c){
        switch (c) {
            case '+': return first+second;
            case '-': return first - second;
            // and like that
        }
    }

    private static void infixToPostfix() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stk = new Stack<>();
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // operand
            // operator
            // '('
            // ')'
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                // extract all from stack till (
                while(stk.peek() != '(') {
                    res = res + stk.pop();
                }
                // remove the opening bracket from stack
                stk.pop();
            } else if (isOperator(c)) {
                // if operator
                while(!stk.isEmpty() && precedence(stk.peek()) > precedence(c)) { // as stack precedence should be non decreasing
                    res += stk.pop();
                }
                stk.push(c);
            } else {
                // operand hence put in result directly
                res += c;
            }
        }
        // empty the stack
        while(!stk.isEmpty()) {
            res += stk.pop();
        }
        System.out.print(res);
    }

    private static int precedence(char i) {
        switch (i) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return 0; // this case should never come.
        }
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '*':
            case '/':
            case '^':
            case '+':
            case '-':
                return true;
            default: return false;
        }
    }

    // 1. (a+b) prefix
    // 2. infix +ab
    // 3. postfix ab+

    // a+b*c infix
    // +a*bc prefix

// DMAS - divide, multiplication, addition, subtraction
 // precedence -
    // 3. highest ^ power symbol
    // 2. multiple and divide * /
    // 1. addition and subtractoin + -

    // a+b*c --> +*abc, *+abc...+a*bc
    // a+b+c -> ++abc
    // a+b-c --> -+abc

//    postfix
//    infix -> postfix
    // 1. start iterating from right side.   a+b*c, abc are operand, +* operator
    // 2. if s.charAt(i) is operand: print it
    // 3. if '(': push to stack
    // 4. if ')' remove all elements from stack and print them
    // 5. else : pop and print from stack till precendence(stack.top()) > precendence(s.charAt(i)) and then put s.charAt(i) in stack.
}
