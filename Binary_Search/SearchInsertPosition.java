public class SearchInsertPosition {
      public static void main(String[] args) {
            int arr[] = { 1, 3, 5, 6 };
            int k = 7;
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  if (arr[mid] < k) {
                        left = mid + 1;
                  } else if (arr[mid] > k) {
                        right = mid - 1;
                  } else {
                        right = mid - 1;
                  }
            }
            System.out.println(left);
      }
}
