package Two_Pointers;

public class ContainerWithMostWater {
      public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max_area = 0;

            while (left < right) {
                  int length = Math.min(height[left], height[right]);
                  int breadth = right - left;
                  max_area = Math.max(max_area, length * breadth);

                  if (height[left] < height[right]) {
                        left++;
                  } else {
                        right--;
                  }
            }

            return max_area;
      }

      public static void main(String[] args) {
            int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
            int answer = maxArea(arr);
            System.out.println(answer);
      }
}
