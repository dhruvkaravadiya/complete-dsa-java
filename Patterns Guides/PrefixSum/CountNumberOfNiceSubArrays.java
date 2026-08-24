import java.util.HashMap;
public class CountNumberOfNiceSubArrays{
    
    public static int solve(int[] nums, int k) {

        // make each of the even number 0 so that we can make sum easier
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i]+" ");  
        // }
        System.out.println(); 
        int oddCount = 0; 
        int count = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(oddCount, 1);
        for(int i = 0 ; i < nums.length ; i++){
            oddCount += nums[i];

        count += map.getOrDefault(oddCount - k, 0);

        map.put(oddCount,map.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
         int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;

        int[] nums2 = {2, 4, 6};
        int k2 = 1;

        int[] nums3 = {2, 2, 2, 1, 2};
        int k3 = 1;

        int[] nums4 = {1, 1, 1, 1};
        int k4 = 2;

        int[] nums5 = {1, 2, 1, 2, 1};
        int k5 = 2;


        System.out.println("Test 1: " + solve(nums1, k1));
        System.out.println("Test 2: " + solve(nums2, k2));
        System.out.println("Test 3: " + solve(nums3, k3));
        System.out.println("Test 4: " + solve(nums4, k4));
        System.out.println("Test 5: " + solve(nums5, k5));
    }
}
