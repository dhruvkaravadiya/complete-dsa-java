package Two_Pointers;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int k = 13;
        int []answer = twoSum(arr, k);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] twoSum(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int ans[] = new int[2];

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            } else {
                // Found the pair
                ans[0] = start + 1;
                ans[1] = end + 1;
                break;
            }
        }

        return ans;
    }

}
