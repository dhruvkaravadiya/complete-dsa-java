import java.lang.Math;

public class MinimumInARotatedSortedArray {
      public static void main(String[] args) {
            int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
            int low = 0;
            int high = arr.length - 1;
            int answer = Integer.MAX_VALUE;
            while (low <= high) {
                  int mid = low + (high - low) / 2;
                  if (arr[low] <= arr[high]) {
                        System.out.println(Math.min(arr[low], answer));
                        return;
                  }
                  if (arr[low] <= arr[mid]) {
                        answer = Math.min(arr[low], answer);
                        low = mid + 1;
                  } else {
                        high = mid - 1;
                        answer = Math.min(arr[mid], answer);
                  }
            }
            System.out.println(answer);
      }
}
