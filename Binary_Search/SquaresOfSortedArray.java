package Binary_Search;

import java.lang.Math;

public class SquaresOfSortedArray {
      public static void main(String[] args) {
            int arr[] = { -4, -2, 0, 1, 3 };
            printArray(arr);
            int ans[] = sortedSquares(arr);
            printArray(ans);
      }

      public static void printArray(int[] arr) {
            for (int x : arr) {
                  System.out.print(x + " ");
            }
            System.out.println();
      }

      public static int[] sortedSquares(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int[] res = new int[nums.length];
            int index = nums.length - 1; // Start from the end of the array

            while (left <= right) {
                  int leftValue = (int) Math.pow(nums[left], 2);
                  int rightValue = (int) Math.pow(nums[right], 2);
                  if (leftValue > rightValue) {
                        res[index] = leftValue;
                        left++;
                  } else {
                        res[index] = rightValue;
                        right--;
                  }
                  index--;
            }

            return res;
      }
}