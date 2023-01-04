import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {

    public static int F(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 3;
        else if (ch == '^')
            return 6;
        else if (ch >= 'a' && ch <= 'z')
            return 7;
        else if (ch == '(')
            return 9;
        else if (ch == ')')
            return 0;
        return -1;
    }

    public static int G(char ch) {
        if (ch == '+' || ch == '-')
            return 2;
        else if (ch == '*' || ch == '/')
            return 4;
        else if (ch == '^')
            return 5;
        else if (ch >= 'a' && ch <= 'z')
            return 7;
        else if (ch == '(')
            return 0;
        return -1;
    }

    public static int R(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return 1;
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str2 = sc.next();
        str2 = str2.toLowerCase();
        String str = "";
        for (int i = str2.length() - 1; i >= 0; i--) {
            str += str2.charAt(i);
        }
        str = str.replace("(", ".");
        str = str.replace(")", "(");
        str = str.replace(".", ")");

        str = str.toLowerCase();
        str += ")";
        Stack<Character> stack = new Stack<Character>();
        stack.push('(');

        String polish2 = "";
        int rank = 0;

        for (int i = 0; i < str.length(); i++) {
            char next = str.charAt(i);
            while (G(stack.peek()) > F(next)) {
                char temp = stack.pop();
                polish2 += temp;
                rank += R(temp);
                if (rank < 0) {
                    System.out.println("Invalid");
                    break;
                }
            }

            if (G(stack.peek()) != F(next))
                stack.push(next);
            else
                stack.pop();

        }
        if (rank != 1 || !stack.empty())
            System.out.println("Invalid");
        else {
            String polish = "";
            System.out.println("valid");
            for (int i = polish2.length() - 1; i >= 0; i--) {
                polish += polish2.charAt(i);
            }
            System.out.println("Prefix " + polish);
        }
        sc.close();
    }
}