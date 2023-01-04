import java.util.Scanner;

public class MatrixMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows of 1st matrix : ");
        int r1 = sc.nextInt();
        System.out.print("Enter number of columns of 1st matrix : ");
        int c1 = sc.nextInt();
        int r2 = c1;
        System.out.print("Enter number of columns of 2nd matrix : ");
        int c2 = sc.nextInt();
        int array1[][] = new int[r1][c1];
        int array2[][] = new int[r2][c2];
        int multiplicationArray[][] = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print("Enter element of " + i + " row and " + j + " column of 1st array : ");
                array1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print("Enter element of " + i + " row and " + j + " column of 2nd array : ");
                array2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                multiplicationArray[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    multiplicationArray[i][j] += array1[i][k] * array2[k][j];
                }
                System.out.print("\t" + multiplicationArray[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
