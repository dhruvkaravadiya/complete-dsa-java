public class CapacityToShipPackagesWithinDDays {
      public static void main(String[] args) {
            int[] weights1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            System.out.println(shipWithinDays(weights1, 5));

            int[] weights2 = { 3, 2, 2, 4, 1, 4 };
            System.out.println(shipWithinDays(weights2, 3));

            int[] weights3 = { 1, 2, 3, 1, 1 };
            System.out.println(shipWithinDays(weights3, 4));
      }

      public static int shipWithinDays(int[] weights, int days) {
            int left = 1;
            int right = 0;
            for (int weight : weights) {
                  right += weight;
            }
            while (left < right) {
                  int mid = left + (right - left) / 2;

                  if (canShipWithinDays(weights, days, mid)) {
                        right = mid;
                  } else {
                        left = mid + 1;
                  }

            }
            return left;
      }

      public static boolean canShipWithinDays(int[] weights, int days, int capacity) {
            int count = 1;
            int currentWeight = 0;
            for (int weight : weights) {
                  if (weight > capacity) {
                        return false;
                  }
                  currentWeight += weight;
                  if (currentWeight > capacity) {
                        if (++count > days) {
                              return false;
                        }
                        currentWeight = weight;
                  }
            }
            return true;
      }
}
