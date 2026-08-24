public class SparseMatrix {

    // Triplet representation
    static class Sparse {
        int row, col, value;

        Sparse() {}

        Sparse(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    // Print sparse matrix in normal form
    static void printSparse(Sparse[] a) {
        int k = 1;

        for (int i = 0; i < a[0].row; i++) {
            for (int j = 0; j < a[0].col; j++) {
                if (k <= a[0].value && a[k].row == i && a[k].col == j) {
                    System.out.printf("%4d", a[k++].value);
                } else {
                    System.out.printf("%4d", 0);
                }
            }
            System.out.println();
        }
    }

    // Fast Transpose
    static Sparse[] fastTranspose(Sparse[] a) {
        int n = a[0].col;
        int terms = a[0].value;

        Sparse[] b = new Sparse[terms + 1];
        for (int i = 0; i <= terms; i++) b[i] = new Sparse();

        b[0].row = n;
        b[0].col = a[0].row;
        b[0].value = terms;

        int[] s = new int[n];
        int[] t = new int[n];

        // Count elements in each column
        for (int i = 1; i <= terms; i++)
            s[a[i].col]++;

        // Starting positions
        t[0] = 1;
        for (int i = 1; i < n; i++)
            t[i] = t[i - 1] + s[i - 1];

        // Transpose
        for (int i = 1; i <= terms; i++) {
            int j = t[a[i].col];

            b[j].row = a[i].col;
            b[j].col = a[i].row;
            b[j].value = a[i].value;

            t[a[i].col]++;
        }

        return b;
    }

    // Sparse Matrix Multiplication
    static Sparse[] multiplySparse(Sparse[] A, Sparse[] B) {

        if (A[0].col != B[0].row) {
            System.out.println("Multiplication not possible!");
            return null;
        }

        Sparse[] C = new Sparse[100];
        for (int i = 0; i < 100; i++) C[i] = new Sparse();

        C[0].row = A[0].row;
        C[0].col = B[0].col;

        int count = 0;

        for (int i = 0; i < A[0].row; i++) {
            for (int j = 0; j < B[0].col; j++) {

                int sum = 0;

                for (int k = 1; k <= A[0].value; k++) {
                    if (A[k].row == i) {

                        for (int l = 1; l <= B[0].value; l++) {
                            if (B[l].row == A[k].col && B[l].col == j) {
                                sum += A[k].value * B[l].value;
                            }
                        }

                    }
                }

                if (sum != 0) {
                    count++;
                    C[count].row = i;
                    C[count].col = j;
                    C[count].value = sum;
                }
            }
        }

        C[0].value = count;
        return C;
    }

    public static void main(String[] args) {

        // -------- Matrix for Fast Transpose --------
        Sparse[] A = {
                new Sparse(5, 7, 10),
                new Sparse(0, 2, 12),
                new Sparse(0, 4, 16),
                new Sparse(1, 5, 21),
                new Sparse(2, 6, 11),
                new Sparse(3, 1, 22),
                new Sparse(3, 3, 19),
                new Sparse(3, 6, 25),
                new Sparse(4, 1, 44),
                new Sparse(4, 4, 18),
                new Sparse(4, 5, 43)
        };

        System.out.println("Matrix A:");
        printSparse(A);

        Sparse[] T = fastTranspose(A);

        System.out.println("\nFast Transpose of Matrix A:");
        printSparse(T);

        // -------- Matrices for Multiplication --------
        Sparse[] M1 = {
                new Sparse(3, 3, 5),
                new Sparse(0, 0, 1),
                new Sparse(0, 2, 2),
                new Sparse(1, 1, 3),
                new Sparse(2, 0, 4),
                new Sparse(2, 2, 5)
        };

        Sparse[] M2 = {
                new Sparse(3, 2, 5),
                new Sparse(0, 0, 1),
                new Sparse(0, 1, 2),
                new Sparse(1, 0, 3),
                new Sparse(2, 0, 4),
                new Sparse(2, 1, 5)
        };

        System.out.println("\nMatrix M1:");
        printSparse(M1);

        System.out.println("\nMatrix M2:");
        printSparse(M2);

        Sparse[] result = multiplySparse(M1, M2);

        System.out.println("\nM1 × M2:");
        printSparse(result);
    }
}