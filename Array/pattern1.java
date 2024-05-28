// 1      1
// 12    21

// i = 2

// 1=>j=1
// 2=>j=2 
// *=>j=3
// *=>j=4
// *=>j=5
// *=>j=6
// 2=>j=7
// 1=>j=8

// 123  321
// 12344321

public class pattern1 {
      public static void main(String[] args) {
            int n = 4;
            int tot = n * 2;
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= tot; j++) {
                        if (j <= i) {
                              System.out.print(j);

                        } else if ((tot - j) < i) {
                              System.out.print(tot - j + 1);
                        } else {
                              System.out.print(" ");
                        }
                  }
                  System.out.println();
            }
      }
}
