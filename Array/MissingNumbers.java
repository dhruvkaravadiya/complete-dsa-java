// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, 
//so all numbers are in the range [0,3]. 2 is 
//the missing number in the range since it does not appear in nums.
public class MissingNumbers {
      public static void main(String[] args) {
            int arr[] = { 0, 1, 2, 5, 4 };
            int n = arr.length;
            int sum = n * (n + 1) / 2;
            System.out.println(sum);
            int x = 0;
            for (int i = 0; i < n; i++) {
                  x += arr[i];
            }
            System.out.println(sum - x);

      }
}