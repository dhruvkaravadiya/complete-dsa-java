class ArrangingCoins {
      public static int arrangeCoins(int n) {
            int i = 1;
            int count = 0;
            while (i <= n) {
                  n -= i;
                  i++;
                  count++;
            }
            return count;
      }

      public static void main(String[] args) {
            System.out.println(arrangeCoins(8));
      }
}
