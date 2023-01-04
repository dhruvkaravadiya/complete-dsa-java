import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }

    static String PostfixToInFix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (isOperand(ch)) {
                stack.push(ch + "");
            }
            else{
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push("("+op2+ch+op1+")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix : ");
        String postfix_string = sc.nextLine();
        System.out.println("Infix : " + PostfixToInFix(postfix_string));
        sc.close();
    }
}