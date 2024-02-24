package Searching;

// first solution using search in each row
// O(n) + O(log(m)) time complexity
// O(1) space complexity
// public class BinarySearchIn2dArray {
// public static boolean binarySearch(int[] arr, int target) {
// int n = arr.length;
// int left = 0;
// int right = n - 1;
// while (left <= right) {
// int mid = left + (right - left) / 2;
// if (arr[mid] == target) {
// return true;
// } else if (arr[mid] < target) {
// left = mid + 1;
// } else {
// right = mid - 1;
// }
// }
// return false;
// }

// public static boolean searchMatrix(int[][] matrix, int target) {
// int cols = matrix[0].length;
// if (cols == 1 && matrix[0][0] == target) {
// return true;
// }
// int rows = matrix.length;
// for (int i = 0; i < rows; i++) {
// if (matrix[i][0] <= target && target <= matrix[i][cols - 1]) {
// return binarySearch(matrix[i], target);
// }
// }
// return false;
// }

// public static void main(String[] args) {
// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
// int target = 3;
// System.out.println(searchMatrix(matrix, target));
// }
// }

public class BinarySearchIn2dArray {
      public static void main(String[] args) {
            int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
            int target = 3;
            int rows = matrix.length;
            int cols = matrix[0].length;
            int low = 0;
            int high = (rows * cols) - 1;
            while (low <= high) {
                  int mid = low + (high - low) / 2;
                  int row = mid / cols;
                  int col = mid % cols;
                  if (matrix[row][col] == target) {
                        System.out.println(true);
                        return;
                  } else if (matrix[row][col] < target) {
                        low = mid + 1;
                  } else {
                        high = mid - 1;
                  }
            }
      }
}
