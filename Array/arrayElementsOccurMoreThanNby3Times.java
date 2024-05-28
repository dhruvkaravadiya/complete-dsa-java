import java.util.HashMap;
import java.util.Map;

public class arrayElementsOccurMoreThanNby3Times {
      public static void main(String[] args) {
            int arr[] = { 1, 1, 1, 2, 4, 6, 7, 2, 4, 4, 2, 1, 3, 3, 3 };
            int N = 3;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            }
            System.out.println(map);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                  if (entry.getValue() > N) {
                        System.out.println(entry.getKey());
                  }
            }

      }
}
