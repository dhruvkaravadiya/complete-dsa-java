package Array;

public class missingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfN = (n * (n + 1)) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        System.out.println(arrSum);
        System.out.println(sumOfN);
        int diffSum = sumOfN - arrSum;
        return diffSum;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 3, 4, 5, 6, 7 };
        System.out.println(missingNumber(arr));
    }

}
