public class MaximumPointsYouCanObtainFromCards{

    public static int maxScore(int[] cardPoints, int k) {
        int[] prefixSum = new int[cardPoints.length + 1];
        prefixSum[0] = 0;
        int totalSum = 0;
        int n = cardPoints.length;
        for(int i = 0 ; i < n ; i++){
            totalSum += cardPoints[i];
        }
        for(int i = 1 ; i <= n ; i++){
            prefixSum[i] = cardPoints[i-1] + prefixSum[i-1];
        }
        
        int windowSize = n - k;
        int left = 0;
        int right = windowSize;
        // System.out.println("k = " + k);
        // System.out.println("rest ones : " + windowSize);
        // System.out.println("left = " + left);
        // System.out.println("right = " + right);
        // System.out.println("left - 1 = " + (left - 1));
        int min = prefixSum[right] - prefixSum[left];
        while(left<=k){
            int currentSum = prefixSum[right] - prefixSum[left];
            if(currentSum < min){
                min = currentSum;
            }
            left++;
            right++;
        }
        System.out.println(totalSum - min);
        return totalSum - min;
    }

    public static void main(String[] args) {

        int[][] testCases = {
            {8, 2, 9, 3, 1, 7, 4, 6},
            {1, 2, 3, 4, 5, 6, 1},
            {20, 1, 1, 1, 1, 20},
            {5, 5, 5, 5, 5, 5},
            {7, 2, 15, 4, 9},
            {100, 1, 1, 1, 100, 1},
            {1, 100, 1, 1, 1, 100, 1},
            {10, 20, 30, 40, 50},
            {3, 8, 2, 10, 4},
            {50, 1, 1, 1, 1, 1, 50, 1, 1}
        };

        int[] kValues = {
            3,
            3,
            2,
            4,
            1,
            2,
            2,
            2,
            4,
            3
        };

        int[] expected = {
            19,
            12,
            40,
            20,
            15,
            101,
            101,
            90,
            25,
            52
        };

        for (int i = 0; i < testCases.length; i++) {

        int result = maxScore(testCases[i], kValues[i]);

        System.out.println(
            "Test " + (i + 1) +
            " | Expected: " + expected[i] +
            " | Got: " + result +
            " | " + (result == expected[i] ? "PASS" : "FAIL")
        );
        }
    }

}