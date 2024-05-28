// Here we are given a array  and  K
// K is simply the limit of the window, basically , 
// the two extremes of the window, r-l should always be <= to k
// Now we 

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
      public static void main(String[] args) {
            int arr[] = { 1, 2, 3, 4, 1, 2, 1, 1 };
            int k = 1;
            System.out.println(containsDuplicates(arr, k));
      }

      public static boolean containsDuplicates(int[] nums, int k) {
            if (k == 0) {
                  return false;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                  if (set.contains(nums[i])) {
                        return true;
                  }
                  set.add(nums[i]);
                  if (set.size() > k) {
                        set.remove(nums[i - k]);
                  }
            }

            return false;
      }
}
