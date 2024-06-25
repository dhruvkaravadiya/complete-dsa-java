// 21+3* => (2+1)*3 => 9

import java.util.Stack;

public class EvaluateReversePolishExpression {
      public static void main(String[] args) {
            String str = "21+3*";
            System.out.println(evaluate(str));
      }

      public static int evaluate(String str) {
            String operators = "+-/*";
            Stack<String> stk = new Stack<String>();
            for (int i = 0; i < str.length(); i++) {
                  String ch = str.charAt(i) + "";
                  if (!operators.contains(ch)) {
                        stk.push(ch);
                  } else {
                        int a = Integer.valueOf(stk.pop());
                        int b = Integer.valueOf(stk.pop());
                        if (ch.equals("+")) {
                              stk.push(String.valueOf(a + b));
                        } else if (ch.equals("-")) {
                              stk.push(String.valueOf(b - a));
                        } else if (ch.equals("*")) {
                              stk.push(String.valueOf(b * a));
                        } else if (ch.equals("/")) {
                              stk.push(String.valueOf(b / a));
                        }
                  }
            }
            return Integer.valueOf(stk.pop());
      }
}