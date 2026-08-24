import java.util.HashMap;
import java.util.Arrays;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {

        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 before the array starts
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int rem = prefixSum % k;

            if (map.containsKey(rem)) {

                if (i - map.get(rem) >= 2) {
                    return true;
                }

            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
}


public class ContinuousSubarraySum {

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(
            Arrays.toString(new int[]{23, 2, 4, 6, 7})
            + " | k = 6 | "
            + sol.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)
        );

        System.out.println(
            Arrays.toString(new int[]{23, 2, 6, 4, 7})
            + " | k = 6 | "
            + sol.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)
        );

        System.out.println(
            Arrays.toString(new int[]{23, 2, 6, 4, 7})
            + " | k = 13 | "
            + sol.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)
        );


        // Length exactly 2
        System.out.println(sol.checkSubarraySum(new int[]{2, 4}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{5, 5}, 5));
        System.out.println(sol.checkSubarraySum(new int[]{1, 6}, 7));
        System.out.println(sol.checkSubarraySum(new int[]{3, 4}, 7));


        // Length 3+
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 3}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 4}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 3, 4}, 10));


        // Entire array
        System.out.println(sol.checkSubarraySum(new int[]{5, 1}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 4, 6}, 35));
        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));


        // Repeated remainder
        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 4}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 3, 4, 5}, 9));


        // No valid subarray
        System.out.println(sol.checkSubarraySum(new int[]{1}, 1));
        System.out.println(sol.checkSubarraySum(new int[]{1}, 2));
        System.out.println(sol.checkSubarraySum(new int[]{1, 2}, 4));
        System.out.println(sol.checkSubarraySum(new int[]{1, 1}, 3));
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 4}, 6));


        // Zero cases
        System.out.println(sol.checkSubarraySum(new int[]{0, 0}, 1));
        System.out.println(sol.checkSubarraySum(new int[]{0, 0}, 5));
        System.out.println(sol.checkSubarraySum(new int[]{0, 1}, 2));
        System.out.println(sol.checkSubarraySum(new int[]{0, 1, 1}, 2));
        System.out.println(sol.checkSubarraySum(new int[]{0, 0, 0}, 7));


        // k = 1
        System.out.println(sol.checkSubarraySum(new int[]{1, 2}, 1));
        System.out.println(sol.checkSubarraySum(new int[]{5, 8, 2}, 1));
        System.out.println(sol.checkSubarraySum(new int[]{0, 0}, 1));


        // Single element
        System.out.println(sol.checkSubarraySum(new int[]{0}, 1));
        System.out.println(sol.checkSubarraySum(new int[]{5}, 5));
        System.out.println(sol.checkSubarraySum(new int[]{10}, 2));


        // Large values
        System.out.println(
            sol.checkSubarraySum(
                new int[]{1000000000, 1000000000},
                1000000000
            )
        );

        System.out.println(
            sol.checkSubarraySum(
                new int[]{1000000000, 1},
                1000000001
            )
        );


        // Tricky cases
        System.out.println(sol.checkSubarraySum(new int[]{1, 2, 3, 4, 5}, 7));
        System.out.println(sol.checkSubarraySum(new int[]{5, 0, 0, 0}, 5));
        System.out.println(sol.checkSubarraySum(new int[]{1, 1, 1, 1}, 3));
        System.out.println(sol.checkSubarraySum(new int[]{1, 1, 1, 1}, 5));
    }
}