// rotate array by k  using Block Swap Algorithm
public class rightRotateByK {
      public static void reverse(int nums[], int start, int end) {
            while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
            }
      }
      public static void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
      }
      public static void main(String[] args){
            int arr[] = {1,2,3,4,5,6,7,8};
            int k = 3;
            rotate(arr, k);
            for(int i = 0 ; i  < arr.length ; i++){
                  System.out.print(arr[i]+ " ");
            }
      }
}
