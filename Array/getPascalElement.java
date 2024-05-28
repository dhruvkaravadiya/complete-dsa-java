// given row r and column c, 
// return element r,c in pascal triangle

// hint  , element x, y  =  Xc(Y-1) , in combinations

// x,y = 6 , 3 
// then 6c2 => 6 * 5 / 2 * 1

public class getPascalElement {
      public static void main(String[] args) {
            double r = 6;
            double c = 3;
            System.out.println(
                        "Element at (r,c) in pascal triangle" + factorial(r, c - 1) / factorial(r - c - 1, r - c - 1));
      }

      public static double factorial(double num, double limit) {
            double fact = 1;
            double temp = num;

            for (int i = 0; i < limit; i++) {
                  fact *= temp;
                  temp--;
            }

            return fact;
      }
}
