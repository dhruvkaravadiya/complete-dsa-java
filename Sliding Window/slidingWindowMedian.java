import java.util.ArrayList;
import java.util.Collections;
/* 
Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation: 
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
1  [3  -1  -3] 5  3  6  7       -1
1  3  [-1  -3  5] 3  6  7       -1
1  3  -1  [-3  5  3] 6  7        3
1  3  -1  -3  [5  3  6] 7        5
1  3  -1  -3  5  [3  6  7]       6

Example 2:

Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
*/
public class slidingWindowMedian {
      public static double calculateMedian(int[] arr, int start, int end) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = start ; i < end ; i++){
                  list.add(arr[i]);
            }
            Collections.sort(list);
            int n = list.size();
            if (n % 2 != 0) {
                  return (list.get(n / 2));
            } else {
                  return ((list.get(n / 2) + list.get(n / 2 - 1)) / 2.0);
            }
      }

      public static void main(String[] args) {
            int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
            int k = 3;
            ArrayList<Double> list = new ArrayList<Double>();

            for (int i = 0; i <= nums.length - k; i++) {
                  list.add(calculateMedian(nums, i, i + k));
            }

            for (int i = 0; i < list.size(); i++) {
                  System.out.println(list.get(i));
            }
      }
}
