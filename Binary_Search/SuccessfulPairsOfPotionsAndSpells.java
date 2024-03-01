package Binary_Search;

public class SuccessfulPairsOfPotionsAndSpells {
      public static void main(String[] args) {
            int[] spells = { 5, 1, 3 };
            int[] potions = { 1, 2, 3, 4, 5 };
            int[] answer = successfulPairs(spells, potions, 7);
            for (int x : answer) {
                  System.out.print(x + " ");
            }
      }

      public static int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length;
            int res[] = new int[n];
            for (int i = 0; i < n; i++) {
                  res[i] = calculateSuccessfullPairs(spells[i], potions, success);
            }
            return res;
      }

      public static int calculateSuccessfullPairs(int multiplier, int[] arr, long success) {
            int count = 0;
            for (int e : arr) {
                  if ((e * multiplier) >= success) {
                        count++;
                  }
            }
            return count;
      }

}
