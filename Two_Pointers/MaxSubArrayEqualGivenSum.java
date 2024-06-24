package Two_Pointers;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayEqualGivenSum {
      public static void main(String[] args) {
            int sum = 6;
            int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

            int[] nums = { 1, -1, 5, -2, 3 };
            int k = 3;
            maxSubArrayLen(arr, sum);
            maxSubArrayLen(nums, k);
      }

      public static void maxSubArrayLen(int[] nums, int k) {
            int maxLength = 0;
            int currentSum = 0;
            Map<Integer, Integer> sumIndexMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                  currentSum += nums[i];

                  // Check if currentSum is equal to k
                  if (currentSum == k) {
                        maxLength = i + 1;
                  }

                  // Check if (currentSum - k) exists in the map
                  if (sumIndexMap.containsKey(currentSum - k)) {
                        maxLength = Math.max(maxLength, i - sumIndexMap.get(currentSum - k));
                  }

                  // Add currentSum to the map if it does not exist
                  if (!sumIndexMap.containsKey(currentSum)) {
                        sumIndexMap.put(currentSum, i);
                  }
                  System.out.println("Current Sum : " + currentSum);
                  System.out.println(currentSum - k);
                  System.out.println("map: " + sumIndexMap);
                  System.out.println("length : " + maxLength);
                  System.out.println("-----------------------");
            }
      }
}
