// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]

// Constraints:

//     1 <= temperatures.length <= 105
//     30 <= temperatures[i] <= 100

// Explanation
// we have to find the differance between 
// the index of the minimum previous temperature 
// and the current index, and then replace it in 
// the array if result array , 
import java.util.Stack;

public class DailyTemperatures {
      public static int[] getDailyTemperatures(int[] temperatures) {
            int result[] = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < temperatures.length; i++) {
                  while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        int previousIndex = stack.pop();
                        result[previousIndex] = i - previousIndex;
                  }
                  stack.push(i);
            }

            // For any remaining indexes in the stack, set their result value to 0
            while (!stack.isEmpty()) {
                  result[stack.pop()] = 0;
            }

            return result;
      }

      public static void main(String[] args) {
            int temps1[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
            int temps2[] = { 30, 60, 90 };
            int res1[] = getDailyTemperatures(temps1);
            int res2[] = getDailyTemperatures(temps2);
            // Print the result arrays
            System.out.print("Result 1: ");
            for (int r : res1) {
                  System.out.print(r + " ");
            }
            System.out.println();

            System.out.print("Result 2: ");
            for (int r : res2) {
                  System.out.print(r + " ");
            }
            System.out.println();
      }
}
