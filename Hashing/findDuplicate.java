// find duplicates in the array using hashing
package Hashing;

import java.util.HashSet;

public class findDuplicate {
      public static void main(String[] args) {
            int arr[] = { 2, 4, 1, 2, 5, 3, 1 };
            HashSet<Integer> set = new HashSet<>();
            for (int num : arr) {
                  if (set.contains(num)) {
                        System.out.println("Duplicate found: " + num);
                  } else {
                        set.add(num);
                  }
            }
      }
}
