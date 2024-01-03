import java.util.ArrayList;
import java.util.Stack;

public class GenerateParenthesis {
      public static void makeAndCheckParenthesis(ArrayList<String> list, String sol, int n) {
            if (sol.length() == 2 * n) {
                  Stack<Character> stack = new Stack<Character>();
                  boolean current = true;
                  for (int i = 0; i < 2 * n; i++) {
                        char ch = sol.charAt(i);
                        if (ch == '(') {
                              stack.push(ch);
                        } else {
                              if (stack.size() == 0) {
                                    current = false;
                                    break;
                              } else {
                                    stack.pop();
                              }
                        }
                  }
                  if (stack.size() == 0 && current == true) {
                        list.add(sol);
                  }
                  return;
            }
            makeAndCheckParenthesis(list, sol + "(", n);
            makeAndCheckParenthesis(list, sol + ")", n);
      }

      public static void main(String[] args) {
            String solution = "(";

            ArrayList<String> list = new ArrayList<String>();
            // for n == 1
            makeAndCheckParenthesis(list, solution, 1);
            System.out.println(list);
            System.out.println();

            ArrayList<String> list2 = new ArrayList<String>();
            // for n == 2
            makeAndCheckParenthesis(list2, solution, 2);
            System.out.println(list2);
            System.out.println();

            ArrayList<String> list3 = new ArrayList<String>();
            // for n == 3
            makeAndCheckParenthesis(list3, solution, 3);
            System.out.println(list3);
            System.out.println();

            ArrayList<String> list4 = new ArrayList<String>();
            // for n == 4
            makeAndCheckParenthesis(list4, solution, 4);
            System.out.println(list4);
            System.out.println();

            ArrayList<String> list5 = new ArrayList<String>();
            // for n == 5
            makeAndCheckParenthesis(list5, solution, 5);
            System.out.println(list5);
            System.out.println();

            ArrayList<String> list6 = new ArrayList<String>();
            // for n == 6
            makeAndCheckParenthesis(list6, solution, 6);
            System.out.println(list5);

      }
}
