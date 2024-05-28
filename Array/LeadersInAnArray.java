public class LeadersInAnArray {
    public static void main(String[] args) {
        int nums[] = { 17, 18, 5, 2, 6, 1 };
        int n = nums.length;
        if (nums.length == 1) {
            System.out.println(nums[0]);
        } else {
            int max = nums[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                if (max <= nums[i]) {
                    max = nums[i];
                    System.out.print(max + " ");
                }
            }
        }
    }
}
