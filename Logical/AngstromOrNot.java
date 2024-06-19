package Logical;

public class AngstromOrNot {
      public static void main(String[] args) {
            int n1 = 153;
            int n2 = 9474;
            int n3 = 54748;
            System.out.println(isAngstrom(n1));
            System.out.println(isAngstrom(n2));
            System.out.println(isAngstrom(n3));
      }

      public static boolean isAngstrom(int n) {
            String str = String.valueOf(n);
            int power = str.length();
            int sum = 0;
            for (int i = 0; i < power; i++) {
                  sum += Math.pow(Integer.parseInt(str.charAt(i) + ""), power);
            }
            return sum == n;
      }
}
