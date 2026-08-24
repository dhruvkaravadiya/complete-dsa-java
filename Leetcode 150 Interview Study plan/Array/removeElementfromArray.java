/*
      Problem number 27: Remove Element     
*/

public static void main(String[] args) {
      int[] nums = {3, 2, 2, 3};
      int val = 3;
      int left = 0;
      int size = nums.length;
      int right = size - 1;
      int count = 0;
      int i = 0;
      
      while (i <= right) {
            if (nums[i] == val) {
                  int temp = nums[right];
                  nums[right] = nums[i];
                  nums[i] = temp;
                  right--;
            } else {
                  i++;
            }
      }
      
      System.out.println(right + 1);
      for (int j = 0; j < right + 1; j++) {
            System.out.print(nums[j] + " ");
      }
}