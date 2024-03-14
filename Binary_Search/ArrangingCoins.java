class Solution {
      public int arrangeCoins(int n) {
            int i = 1;
            int count = 0;
            while (i <= n) {
                  n -= i;
                  i++;
                  count++;
            }
            return count;
      }

}
