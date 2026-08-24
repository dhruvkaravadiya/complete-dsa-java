// what would work and what would not work ? ? 
// 1. HashMap<Integer, Integer> → existence
//    Works:        YES
//    Time:         O(n)
//    Space:        O(k)
//    Problem:      Must remove elements one-by-one.

// 2. HashSet<Integer>
//    Works:        YES
//    Time:         O(n)
//    Space:        O(k)
//    Better than:  HashMap for simple existence checking.
//    Problem:      Still needs the nested while loop.

// 3. int[] index array
//    Works:        SOMETIMES
//    Fast lookup:  YES
//    Problem:      Only practical when nums[i] has a small bounded range.
//    Example:      value = 1,000,000,000 → array becomes impractical.

// 4. HashMap → last index
//    Works:        YES
//    Time:         O(n)
//    Advantage:    left can jump directly.
//    Example:
//                  4 → 0
//                  duplicate 4 found
//                  left = 0 + 1
//    Problem:      We skipped multiple elements, so we need their sum.

// 5. Last-index HashMap + prefix sum
//    Works:        YES
//    Time:         O(n)
//    Space:        O(n)
//    Advantage:    Jump left + calculate skipped sum directly.

// When optimizing a sliding-window problem, ask: "Can I remember the last position and jump left instead of removing elements one-by-one?"

// appraoch : 1

// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         int left = 0;
//         int right  = 0;
//         int n = nums.length;
//         HashMap<Integer , Integer> map = new HashMap<>();
//         int maxSum = 0;
//         int currentSum = 0;
//         while(right < n){
//             if(!map.containsKey(nums[right])){
//                 map.put(nums[right] , 1);
//                 currentSum = currentSum + nums[right];
//             } 
//             else{
//                 while(map.containsKey(nums[right])){
//                     map.remove(nums[left]);
//                     currentSum = currentSum - nums[left];
//                     left++;
//                 }
//                 map.put(nums[right] , 1);
//                 currentSum = currentSum + nums[right];
//             }
//             maxSum = Math.max(currentSum , maxSum);
//             right++;
//         }
//         return maxSum;
//     }
// }


// optimized 

class Solution {

    public int maximumUniqueSubarray(int[] nums) {

        int left = 0;
        int right = 0;
        int n = nums.length;

        // number -> last index
        HashMap<Integer, Integer> map = new HashMap<>();

        // prefixSum[i] = sum of nums[0...i]
        long[] prefixSum = new long[n];

        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long currentSum = 0;
        long maxSum = 0;

        while (right < n) {

            int previousIndex = map.getOrDefault(nums[right], -1);

            // Previous occurrence is inside the current window
            if (previousIndex >= left) {

                long removeSum;

                if (left == 0) {
                    removeSum = prefixSum[previousIndex];
                } else {
                    removeSum = prefixSum[previousIndex]
                              - prefixSum[left - 1];
                }

                currentSum -= removeSum;

                // Jump directly instead of shrinking one-by-one
                left = previousIndex + 1;
            }

            currentSum += nums[right];

            // Store latest occurrence
            map.put(nums[right], right);

            maxSum = Math.max(maxSum, currentSum);

            right++;
        }

        return (int) maxSum;
    }
}

// final notes

// Question which will click once you have done a few questions of this pattern.

// Firstly, try the Map way. It will pass all test cases. Then try optimizing it.

// 1. HashMap → existence check
//    - Works, but we're only using the Map to check whether a number exists.

// 2. HashSet
//    - Cleaner than HashMap when we only need existence.
//    - Still requires the nested while loop to remove elements.

// 3. Index Array
//    - Faster lookup than HashMap.
//    - Only useful when the range of nums[i] is small/bounded.
//    - Not practical for arbitrary/huge integer values.

// Now the major optimization:

// 4. HashMap → last index
//    - Store number → last index.
//    - Instead of removing elements one-by-one, jump left directly to previousIndex + 1.
//    - This removes the nested while loop.
//    - Still O(n), because the original solution was already O(n) overall.

// 5. Last Index + Prefix Sum
//    - When left jumps, multiple elements are skipped.
//    - Prefix sum lets us calculate the sum of those skipped elements directly.
//    - Time: O(n)
//    - Space: O(n)

// Important lesson:

// O(n²) → O(n) = major algorithmic optimization.

// O(n) → O(n) = constant-factor optimization.
// The actual runtime may therefore be similar or even slightly worse.

// Specifically:

// Variable Length Sliding Window

// Sub-pattern:

// Last Index Tracking + Prefix Sum
