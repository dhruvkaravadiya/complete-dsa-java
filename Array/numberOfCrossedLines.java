public class numberOfCrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        return lcs(nums1, nums2);
    }

    public static int lcs(int[] s1, int[] s2) {
        int m = s1.length;
        int n = s2.length;
        int[][] arr = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {

                    arr[i][j] = arr[i - 1][j - 1] + 1;

                    if (arr[i][j] > maxLen) {
                        maxLen = arr[i][j];
                        // ans = s1.subint(i-maxLen, i);
                    }
                } else {
                    arr[i][j] = ((arr[i - 1][j] > arr[i][j - 1]) ? arr[i - 1][j] : arr[i][j - 1]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int a1[] = { 1, 3, 7, 1, 7, 5 };
        int a2[] = { 1, 9, 2, 5, 1 };
        System.out.println(maxUncrossedLines(a1, a2));
    }
}