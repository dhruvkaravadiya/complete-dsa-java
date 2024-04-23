package Hashing;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kMostFrequentElements {
      public static int[] getMostFrequentElements(int[] arr, int k) {
            int[] result = new int[k];
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < arr.length; i++) {
                  map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (int i = 0; i < k && i < list.size(); i++) {
                  result[i] = list.get(i).getKey();
            }
            return result;
      }

      public static void main(String[] args) {

            int result[] = getMostFrequentElements(new int[] { 1, 1, 1, 2, 2, 3, 3 }, 2);
            for (int i = 0; i < result.length; i++) {
                  System.out.print(result[i] + " ");
            }
      }
}
