public class missingNumber {
    public static int missingNumberM(int[] nums) {
        int n = nums.length;
        int sumOfN = (n * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
            sumOfN -= nums[i];
        }
        return sumOfN;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 3, 4, 5, 6, 7 };
        System.out.println(missingNumberM(arr));
    }

}
