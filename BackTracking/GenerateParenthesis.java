import java.util.ArrayList;
import java.util.List;

class Solution {
      public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateParenthesisHelper(result, "", 0, 0, n);
            return result;
      }

      private void generateParenthesisHelper(List<String> result, String current, int open, int close, int n) {
            // if (current.length() == 2 * n) {
            // result.add(current);
            // return;
            // }

            // or we can remove this backtracking logic above by simply doing
            // basically add the current string only if its open and closing brackets
            // matches,
            // as valid parenthesis will always have equal length parenthesis

            // backtracking step to add the current string to the result list
            if (open == n && close == n) {
                  result.add(current);
                  return;
            }

            // left state space tree expansion exploring possibilities
            if (open < n) {
                  generateParenthesisHelper(result, current + "(", open + 1, close, n);
            }
            // right state space tree expansion exploring possibilities
            if (close < open) {
                  generateParenthesisHelper(result, current + ")", open, close + 1, n);
            }
      }
}

public class GenerateParenthesis {
      public static void main(String[] args) {
            Solution solution = new Solution();

            for (int n = 1; n <= 6; n++) {
                  List<String> result = solution.generateParenthesis(n);
                  System.out.println("Parentheses combinations for n = " + n + ":");
                  for (String combination : result) {
                        System.out.println(combination);
                  }
                  System.out.println();
            }
      }
}