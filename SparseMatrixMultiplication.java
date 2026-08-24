import java.util.HashMap;
import java.util.Map;

class SparseMatrixMultiplication {

    static class Sparse {
        int row;
        int col;
        int value;

        Sparse(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    // Sparse Matrix Multiplication
    static Sparse[] multiply(Sparse[] a, Sparse[] b) {

        int rowsA = a[0].row;
        int colsA = a[0].col;

        int rowsB = b[0].row;
        int colsB = b[0].col;

        // Matrix multiplication condition
        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                    "Matrix multiplication not possible"
            );
        }

        /*
         * key   = row * colsB + col
         * value = actual matrix value
         */
        Map<Integer, Integer> result = new HashMap<>();

        // Skip index 0 because it contains matrix information
        for (int i = 1; i < a.length; i++) {

            for (int j = 1; j < b.length; j++) {

                // A[i].col must match B[j].row
                if (a[i].col == b[j].row) {

                    int row = a[i].row;
                    int col = b[j].col;

                    int product = a[i].value * b[j].value;

                    int key = row * colsB + col;

                    result.put(
                            key,
                            result.getOrDefault(key, 0) + product
                    );
                }
            }
        }

        // Number of non-zero elements
        int terms = 0;

        for (int value : result.values()) {
            if (value != 0) {
                terms++;
            }
        }

        Sparse[] c = new Sparse[terms + 1];

        // Header
        c[0] = new Sparse(rowsA, colsB, terms);

        int index = 1;

        // Convert HashMap back into triplet representation
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {

            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 0) {
                continue;
            }

            int row = key / colsB;
            int col = key % colsB;

            c[index++] = new Sparse(row, col, value);
        }

        return c;
    }

    static void printanswer(Sparse[] a) {

        int rows = a[0].row;
        int cols = a[0].col;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int value = 0;

                for (int k = 1; k < a.length; k++) {

                    if (a[k].row == i && a[k].col == j) {
                        value = a[k].value;
                        break;
                    }
                }

                System.out.printf("%5d", value);
            }

            System.out.println();
        }
    }

    // Print triplet representation
    static void printTriples(Sparse[] a) {

        System.out.println("Row Col Value");

        for (Sparse s : a) {
            System.out.println(
                    s.row + "   " +
                    s.col + "   " +
                    s.value
            );
        }
    }

    public static void main(String[] args) {
        Sparse[] a = {
                new Sparse(9, 11, 10),
                new Sparse(0, 2, 12),
                new Sparse(0, 4, 16),
                new Sparse(1, 5, 21),
                new Sparse(2, 5, 11),
                new Sparse(3, 1, 22),
                new Sparse(3, 3, 19),
                new Sparse(3, 6, 25),
                new Sparse(4, 1, 44),
                new Sparse(4, 4, 18),
                new Sparse(4, 5, 43)
        };


        /*
         * B = 7 x 5
         *
         * We can multiply A(5x7) × B(7x5)
         */
        Sparse[] b = {
                new Sparse(7, 5, 8),

                new Sparse(0, 0, 2),
                new Sparse(0, 3, 5),

                new Sparse(1, 1, 3),
                new Sparse(1, 4, 7),

                new Sparse(2, 0, 4),
                new Sparse(2, 2, 6),

                new Sparse(3, 1, 8),
                new Sparse(3, 3, 2),

                new Sparse(4, 2, 5),

                new Sparse(5, 0, 3),
                new Sparse(5, 4, 9),

                new Sparse(6, 1, 4)
        };


        System.out.println("Matrix A:");
        printanswer(a);

        System.out.println("\nMatrix B:");
        printanswer(b);


        Sparse[] c = multiply(a, b);

        System.out.println("\nA x B:");
        printanswer(c);

        System.out.println("\nResult in Triplet Form:");
        printTriples(c);
    }
}