import java.util.Arrays;

class Solution {
      public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = Arrays.stream(piles).max().getAsInt();

            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  if (canEatBananas(mid, piles, h)) {
                        right = mid;
                  } else {
                        left = mid + 1;
                  }
            }
            return left;
      }

      public boolean canEatBananas(int mid, int[] piles, int h) {
            int hours = 0;
            for (int pile : piles) {
                  hours += (pile + mid - 1) / mid;
            }
            return hours <= h;
      }
}