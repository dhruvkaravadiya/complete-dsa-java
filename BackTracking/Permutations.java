import java.util.ArrayList;
import java.util.List;

public class Permutations {
      static List<List<Integer>> permutations = new ArrayList<>();

      public static List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            generatePermutations(nums, list);
            return permutations;
      }

      public static void generatePermutations(int[] arr, List<Integer> list) {
            // base case
            if (list.size() > arr.length) {
                  return;
            }
            if (arr.length == list.size()) {
                  permutations.add(new ArrayList<>(list));
                  return;
            }
            for (int i = 0; i < arr.length; i++) {
                  if (!list.contains(arr[i])) {
                        list.add(arr[i]);
                        generatePermutations(arr, list);
                        // backtracking step
                        list.remove(list.size() - 1);
                  }
            }
      }

      public static void main(String[] args) {
            int[] nums = { 1, 2, 3 };
            List<List<Integer>> result = Permutations.permute(nums);
            for (List<Integer> l : result) {
                  System.out.println(l);
            }
      }
}
