import java.util.ArrayList;
import java.util.List;

public class NonRepeatingSubSets {
      public static void main(String[] args) {
            int[] arr = { 1, 2, 3 };
            int n = arr.length;
            List<List<Integer>> result = new ArrayList<>();
            generateSubsets(arr, result, new ArrayList<>(), 0);
            System.out.println(result);
      }

      public static void generateSubsets(int[] arr, List<List<Integer>> result, List<Integer> subset, int index) {
            // Add the current subset to the result
            result.add(new ArrayList<>(subset));

            for (int i = index; i < arr.length; i++) {
                  // Add the current element to the subset
                  subset.add(arr[i]);

                  // Recursively generate subsets for the remaining elements
                  generateSubsets(arr, result, subset, i + 1);

                  // backtracking step to remove the current element from the subset
                  // Remove the current element from the subset (backtrack)
                  subset.remove(subset.size() - 1);
            }
      }

}