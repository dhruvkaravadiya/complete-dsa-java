//    1 2 3    7 4 1   
//    4 5 6 => 8 5 2
//    7 8 9    9 6 3
//
// First Transpose each row with column
// second reverse each row
package Logical;

public class RotateMatrixBy90Degree {
      public static void main(String[] args) {
            int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            for (int i = 0; i < matrix.length; i++) {
                  for (int j = i; j < matrix[0].length; j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                  }
            }
            for (int i = 0; i < matrix.length; i++) {
                  for (int j = 0; j < matrix.length / 2; j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i][matrix.length - j - 1];
                        matrix[i][matrix.length - j - 1] = temp;
                  }
            }

            for (int[] row : matrix) {
                  for (int elem : row) {
                        System.out.print(elem + " ");
                  }
                  System.out.println();
            }
      }
}
