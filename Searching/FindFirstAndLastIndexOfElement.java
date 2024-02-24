package Searching;

public class FindFirstAndLastIndexOfElement {
      public static void main(String[] args) {
            int[] arr = { 5, 7, 7, 8, 8, 10 };
            int target = 8;
            int[] result = searchRange(arr, target);
            System.out.println("First and Last Index of Element: [" + result[0] + "," + result[1] + "]");
      }

      public static int[] searchRange(int[] nums, int target) {
            int l = findLeftIndex(nums, target);
            int r = findRightIndex(nums, target);
            return new int[] { l, r };
      }

      public static int findLeftIndex(int[] arr, int target) {
            int n = arr.length;
            int left = 0;
            int right = n - 1;
            int index = -1;
            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  if (arr[mid] == target) {
                        index = mid;
                        right = mid - 1;
                  } else if (arr[mid] < target) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }
            return index;
      }

      public static int findRightIndex(int[] arr, int target) {
            int n = arr.length;
            int left = 0;
            int right = n - 1;
            int index = -1;
            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  if (arr[mid] == target) {
                        index = mid;
                        left = mid + 1;
                  } else if (arr[mid] < target) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }
            return index;
      }
}
