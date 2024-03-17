import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
      public static void main(String[] args) {
            int[] arr = { 2, 3, 6, 7 };
            int target = 7;
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            combinationSum(arr, target, 0, current, result);
            System.out.println(result);
      }

      public static void combinationSum(int[] arr, int target, int index, List<Integer> current,
                  List<List<Integer>> result) {
            if (target == 0) {
                  result.add(new ArrayList<>(current));
                  return;
            }
            if (target < 0) {
                  return;
            }
            for (int i = index; i < arr.length; i++) {
                  current.add(arr[i]);
                  combinationSum(arr, target - arr[i], i, current, result);
                  current.remove(current.size() - 1);
            }
      }
}
