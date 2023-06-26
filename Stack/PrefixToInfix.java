//+23 -> 2+3
import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {
    //function to check if the character read is operator or not
    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    //Algorithms - Prefix To Infix
    //read a a character
    //if character is opertor (+,-,/,*) then pop two operands and 
    //do operand + operator + operand and push the answer
    //else push the chracter to the stack 
    //at last only one element will be left and retur that element after popping 
    static String PrefixToInfixConvert(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + ch + op2 + ")";
                stack.push(temp);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix String : ");
        String prefix_string = sc.nextLine();
        System.out.println("Infix : " + PrefixToInfixConvert(prefix_string));
        sc.close();
    }
}
