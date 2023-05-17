import java.util.Stack;
import java.util.Scanner;
public class InfixToPostFix {
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

    static String InfixToPostFixConvert(String infix) {
        String postfix = new String("");
        Stack<Character> stack = new Stack<Character>();
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
        System.out.println("Enter Infix string : ");
        Scanner sc = new Scanner(System.in);
        String infix_string = sc.nextLine();
        System.out.println("Postfix : " + InfixToPostFixConvert(infix_string));
        sc.close();
    }
}
