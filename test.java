import java.util.Stack;
import java.util.Scanner;
import java.util.*;
public class test {
    static int Precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            }
            return -1;
    }

    static String InfixToPostFix(String infix) {
        String postfix = new String("");
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < infix.length(); ++i) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Precedence(ch) <= Precedence(stack.peek())) {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Infix Expression";
            }
            postfix += stack.peek();
            stack.pop();
        }
        return postfix;
    }

    public static void main(String[] args) {
        System.out.println("Postfix : " + InfixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
    }
    
}
