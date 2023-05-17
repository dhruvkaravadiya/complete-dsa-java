import java.util.Scanner;
import java.util.Stack;
public class PrefixToInfix {
    static    boolean isOperator(char x)
{
    switch(x)
    {
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
    static String PrefixToInfixConvert(String prefix){
        Stack<String> stack = new Stack<>();
        for(int i = prefix.length() - 1 ; i>=0 ; i--){
            char ch = prefix.charAt(i);
            if(isOperator(ch)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "("+op1+ch+op2+")";
                stack.push(temp);
            }
            else{
                stack.push(ch+"");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix String : ");
        String prefix_string = sc.nextLine();
        System.out.println("Infix : "+PrefixToInfixConvert(prefix_string));
        sc.close();
    }
}
