// optimized approach using the frequency array of each of the sums
import java.util.HashMap;

public class BinarySubarraysWithSum {

    public static int solve(int[] nums, int goal) {
// this problem we will put the initial element in the array as 1
// its not prefix sum , though it still uses its logic internally
// as all the number of this array are either 1 or 0 , the max sum <= length of array
// so array of same length+1 is enough to store the frequencies of the prefix sum
// so we store the frequencies of the prefix sum in the array.
        int[] freqOfPrefixSums = new int[nums.length + 1];
        freqOfPrefixSums[0]++;
        int result = 0;
        int sum = 0;
        // Your logic here
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(sum - goal >= 0){
                result = result + freqOfPrefixSums[sum - goal];               
            }
            // just increase the count of the current sum whether its out needed sum or not
            freqOfPrefixSums[sum]++;
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;

        int[] nums2 = {1, 0, 0, 1, 0, 1};
        int goal2 = 2;

        int[] nums3 = {0, 0, 0, 0, 0};
        int goal3 = 0;

        int[] nums4 = {1, 1, 1, 1};
        int goal4 = 2;

        int[] nums5 = {0, 1, 0, 1, 0};
        int goal5 = 1;


        System.out.println("Test 1: " + solve(nums1, goal1));
        System.out.println("Test 2: " + solve(nums2, goal2));
        System.out.println("Test 3: " + solve(nums3, goal3));
        System.out.println("Test 4: " + solve(nums4, goal4));
        System.out.println("Test 5: " + solve(nums5, goal5));
    }
}


// brute force approach using 2 loops 1330 ms
// import java.util.HashMap;

// public class BinarySubarraysWithSum {

//     public static int solve(int[] nums, int goal) {

//         int[] prefixSum = new int[nums.length + 1];

//         // Build prefix sum
//         prefixSum[0] = 0;

//         for (int i = 1; i <= nums.length; i++) {
//             prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
//         }

//         int count = 0;

//         HashMap<Integer, Integer> map = new HashMap<>();

//         // sum 0, count 1
//         map.put(0, 1);

//         // Your logic here
//         for (int i = 0; i < prefixSum.length; i++) {

//             for (int j = i+1; j < prefixSum.length; j++) {

//                 int currentSum = prefixSum[j] - prefixSum[i];
//                 if(currentSum == goal){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }


//     public static void main(String[] args) {

//         int[] nums1 = {1, 0, 1, 0, 1};
//         int goal1 = 2;

//         int[] nums2 = {1, 0, 0, 1, 0, 1};
//         int goal2 = 2;

//         int[] nums3 = {0, 0, 0, 0, 0};
//         int goal3 = 0;

//         int[] nums4 = {1, 1, 1, 1};
//         int goal4 = 2;

//         int[] nums5 = {0, 1, 0, 1, 0};
//         int goal5 = 1;


//         System.out.println("Test 1: " + solve(nums1, goal1));
//         System.out.println("Test 2: " + solve(nums2, goal2));
//         System.out.println("Test 3: " + solve(nums3, goal3));
//         System.out.println("Test 4: " + solve(nums4, goal4));
//         System.out.println("Test 5: " + solve(nums5, goal5));
//     }
// }