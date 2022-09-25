
//Write program to convert Infix Expression to Post-Fix Expression / Reverse Polish Expression
import java.util.Stack;

class InfixToPostFixImplement {
    public boolean checkIfAlphabet(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        else
            return false;
    }

    public int precedance(char ch) {
        if (ch == '+' || ch == '-') 
            return 1;
        else if (ch == '*' || ch == '/') 
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    public void convertInfixToPostFix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder revPolishExp = new StringBuilder(new String(""));

        for (int i = 0; i < infix.length(); i++) {
            char temp = infix.charAt(i);
            if (checkIfAlphabet(temp)) {
                revPolishExp.append(temp);
            } 
            else if (temp == '(') {
                stack.push(temp);
            } 
            else if (temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '^') {
                while (!stack.empty() && precedance(temp) <= precedance((char) stack.peek())) {
                    revPolishExp.append(stack.peek());
                    stack.pop();
                }
                stack.push(temp);
            }
            else if(temp == ')'){
                while( !stack.empty() && stack.peek()!= '('){
                    revPolishExp.append(stack.peek());
                    stack.pop();
                }
                if(!stack.empty() && stack.peek()!= '('){
                    return;
                }
                else{
                    stack.pop();
                }
            } 
        }
        while (!stack.empty()){
            revPolishExp.append(stack.peek());
            stack.pop();
        }
        System.out.println(revPolishExp);
    }
}


public class InfixToPostFix{
    public static void main(String[] args) {
        String Infix = "(a+b-c)*(d/e+f*g)";
        InfixToPostFixImplement obj = new InfixToPostFixImplement();
        obj.convertInfixToPostFix(Infix);
    }
}