import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
      public static List<List<Integer>> subsetsWithDup(int[] nums) {
            int n = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            generateSubsets(nums, result, new ArrayList<>(), 0);
            return result;
      }

      public static void generateSubsets(int[] arr, List<List<Integer>> result, List<Integer> subset, int index) {
            if (!result.contains(new ArrayList<>(subset))) {
                  result.add(new ArrayList<>(subset));
            }

            for (int i = index; i < arr.length; i++) {
                  subset.add(arr[i]);
                  generateSubsets(arr, result, subset, i + 1);
                  subset.remove(subset.size() - 1);
            }
      }

      public static void main(String[] args) {
            int[] arr = { 4, 4, 4, 1, 4 };
            quickSort(arr, 0, arr.length - 1);
            List<List<Integer>> result = subsetsWithDup(arr);
            System.out.println(result);
      }

      public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                  int pi = partition(arr, low, high);

                  quickSort(arr, low, pi - 1);
                  quickSort(arr, pi + 1, high);
            }
      }

      private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                  if (arr[j] <= pivot) {
                        i++;

                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                  }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
      }
}
