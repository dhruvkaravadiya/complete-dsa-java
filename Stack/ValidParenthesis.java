import java.util.Stack;

public class ValidParenthesis {
      public static boolean isValid(String s) {
            if (s.length() == 1) {
                  return false;
            }
            Stack<Character> stk = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  if (ch == '(' || ch == '[' || ch == '{') {
                        stk.push(ch);
                  } else if (ch == ']') {
                        if (!stk.isEmpty() && stk.peek() == '[') {
                              stk.pop();

                        } else {
                              flag = false;
                              break;
                        }
                  } else if (ch == '}') {
                        if (!stk.isEmpty() && stk.peek() == '{') {
                              stk.pop();
                        } else {
                              flag = false;
                              break;
                        }
                  } else if (ch == ')') {
                        if (!stk.isEmpty() && stk.peek() == '(') {
                              stk.pop();
                        } else {
                              flag = false;
                              break;
                        }
                  }
            }
            return flag && stk.isEmpty();
      }

      public static void main(String[] args) {
            System.out.println("1. (()) - " + isValid("(())")); // true
            System.out.println("2. ({[()]}) - " + isValid("({[()]})")); // true
            System.out.println("3. {[()]}) - " + isValid("{[()]})")); // false
            System.out.println("4. ((){}) - " + isValid("((){})")); // false
            System.out.println("5. [(]) - " + isValid("[(])")); // false
            System.out.println("6. (){}[] - " + isValid("(){}[]")); // true
            System.out.println("7. ({[)]}) - " + isValid("({[)]})")); // false
            System.out.println("8. (()[{}]) - " + isValid("(()[{}])")); // true
            System.out.println("9. {[()]}( - " + isValid("{[()]}(")); // false
            System.out.println("10. (()[{}])() - " + isValid("(()[{}])()")); // true
      }
}
