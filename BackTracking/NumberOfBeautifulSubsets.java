import java.util.ArrayList;
import java.util.List;

public class NumberOfBeautifulSubsets {
      public static int count = 0;
      public static int k = 2;

      public static void main(String[] args) {
            int arr[] = { 2, 4, 6 };
            checkBeautifulSubSets(arr, new ArrayList<>(), 0);
            System.out.println(count);
      }

      public static void checkBeautifulSubSets(int arr[], List<Integer> subset, int index) {
            for (int i = index; i < arr.length; i++) {
                  subset.add(arr[i]);
                  System.out.println(subset);
                  if (isBeautiful(subset)) {
                        count++;
                        System.out.println("Beautiful : " + subset);
                  }
                  checkBeautifulSubSets(arr, subset, i + 1);
                  subset.remove(subset.size() - 1);
            }
      }

      public static boolean isBeautiful(List<Integer> subset) {
            for (int i = 0; i < subset.size(); i++) {
                  for (int j = i + 1; j < subset.size(); j++) {
                        if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                              return false;
                        }
                  }
            }
            return true;
      }
}
