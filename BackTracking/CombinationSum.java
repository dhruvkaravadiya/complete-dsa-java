import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
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

      public static void main(String[] args) {
            int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
            int target = 8;

            quickSort(arr, 0, arr.length - 1);
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
            if (target < 0 || index == arr.length) {
                  return;
            }
            for (int i = index; i < arr.length; i++) {
                  if (i > index && arr[i] == arr[i - 1]) {
                        continue;
                  }
                  current.add(arr[i]);
                  combinationSum(arr, target - arr[i], i + 1, current, result);
                  current.remove(current.size() - 1);
            }
      }
}
