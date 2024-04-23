package Two_Pointers;

import java.util.*;

public class ThreeSum {
      public static void main(String[] args) {
            int[] arr = { -1, 0, 1, 2, -1, -4 };
            System.out.println(threeSum(arr));
      }

      public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                  if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                  }
                  int left = i + 1;
                  int right = n - 1;
                  while (left < right) {
                        int sum = nums[left] + nums[right] + nums[i];
                        if (sum < 0) {
                              left++;
                        } else if (sum > 0) {
                              right--;
                        } else if (sum == 0) {
                              List<Integer> templist = new ArrayList<>();
                              templist.add(nums[i]);
                              templist.add(nums[left]);
                              templist.add(nums[right]);
                              list.add(templist);
                              left++;
                              right--;
                              // while (left < right && nums[left] == nums[left - 1]) {
                              // left++;
                              // }

                              // // Skip duplicate values for right
                              // while (left < right && nums[right] == nums[right + 1]) {
                              // right--;
                              // }
                        }

                  }
            }
            return list;
      }
}