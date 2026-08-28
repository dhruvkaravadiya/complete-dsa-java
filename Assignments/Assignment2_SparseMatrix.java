package Assignments;

import java.util.*;

/**
 * ASSIGNMENT 2:
 * Implement Sparse Matrix Addition, Transpose, and Multiplication.
 * Fully interactive with user input (no hardcoded values).
 */
public class Assignment2_SparseMatrix {

    // Class to represent a non-zero element in Triplet format
    public static class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int value;

        public Triplet(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Triplet other) {
            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            return Integer.compare(this.col, other.col);
        }

        @Override
        public String toString() {
            return String.format("%4d %4d %6d", row, col, value);
        }
    }

    public static class SparseMatrix {
        int rows;
        int cols;
        int numTerms;
        List<Triplet> terms;

        public SparseMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.numTerms = 0;
            this.terms = new ArrayList<>();
        }

        public void addElement(int r, int c, int val) {
            if (val != 0) {
                terms.add(new Triplet(r, c, val));
                numTerms++;
            }
        }

        // Sort triplets in row-major order
        public void sortTerms() {
            Collections.sort(terms);
        }

        // 1. Sparse Matrix Transpose (Fast Transpose: O(cols + terms))
        public SparseMatrix transpose() {
            SparseMatrix result = new SparseMatrix(this.cols, this.rows);
            if (this.numTerms == 0) {
                return result;
            }

            int[] colCount = new int[this.cols];
            for (Triplet t : this.terms) {
                colCount[t.col]++;
            }

            int[] startPos = new int[this.cols];
            startPos[0] = 0;
            for (int i = 1; i < this.cols; i++) {
                startPos[i] = startPos[i - 1] + colCount[i - 1];
            }

            Triplet[] transposedTerms = new Triplet[this.numTerms];
            for (Triplet t : this.terms) {
                int pos = startPos[t.col]++;
                transposedTerms[pos] = new Triplet(t.col, t.row, t.value);
            }

            result.terms = new ArrayList<>(Arrays.asList(transposedTerms));
            result.numTerms = this.numTerms;
            return result;
        }

        // 2. Sparse Matrix Addition: A + B
        public static SparseMatrix add(SparseMatrix a, SparseMatrix b) {
            if (a.rows != b.rows || a.cols != b.cols) {
                System.out.println("Error: Matrix addition not possible! Dimensions must match.");
                System.out.printf("Matrix A: %dx%d, Matrix B: %dx%d\n", a.rows, a.cols, b.rows, b.cols);
                return null;
            }

            a.sortTerms();
            b.sortTerms();

            SparseMatrix result = new SparseMatrix(a.rows, a.cols);
            int i = 0, j = 0;

            while (i < a.numTerms && j < b.numTerms) {
                Triplet t1 = a.terms.get(i);
                Triplet t2 = b.terms.get(j);

                if (t1.row < t2.row || (t1.row == t2.row && t1.col < t2.col)) {
                    result.addElement(t1.row, t1.col, t1.value);
                    i++;
                } else if (t2.row < t1.row || (t2.row == t1.row && t2.col < t1.col)) {
                    result.addElement(t2.row, t2.col, t2.value);
                    j++;
                } else {
                    int sum = t1.value + t2.value;
                    if (sum != 0) {
                        result.addElement(t1.row, t1.col, sum);
                    }
                    i++;
                    j++;
                }
            }

            while (i < a.numTerms) {
                Triplet t1 = a.terms.get(i);
                result.addElement(t1.row, t1.col, t1.value);
                i++;
            }

            while (j < b.numTerms) {
                Triplet t2 = b.terms.get(j);
                result.addElement(t2.row, t2.col, t2.value);
                j++;
            }

            return result;
        }

        // 3. Sparse Matrix Multiplication: A * B
        public static SparseMatrix multiply(SparseMatrix a, SparseMatrix b) {
            if (a.cols != b.rows) {
                System.out.println("Error: Matrix multiplication not possible!");
                System.out.printf("Matrix A cols (%d) != Matrix B rows (%d)\n", a.cols, b.rows);
                return null;
            }

            // Transpose B so columns of B become rows of B_T
            SparseMatrix bTranspose = b.transpose();
            SparseMatrix result = new SparseMatrix(a.rows, b.cols);

            Map<Integer, Integer> rowColSum = new HashMap<>();

            for (Triplet tA : a.terms) {
                for (Triplet tB : bTranspose.terms) {
                    if (tA.col == tB.col) { // Since B is transposed, tB.col is original B's row
                        int r = tA.row;
                        int c = tB.row; // original B's col
                        int key = r * b.cols + c;
                        rowColSum.put(key, rowColSum.getOrDefault(key, 0) + (tA.value * tB.value));
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : rowColSum.entrySet()) {
                if (entry.getValue() != 0) {
                    int r = entry.getKey() / b.cols;
                    int c = entry.getKey() % b.cols;
                    result.addElement(r, c, entry.getValue());
                }
            }

            result.sortTerms();
            return result;
        }

        public void printTripletRepresentation(String name) {
            System.out.println("-------------------------------------------------");
            System.out.println(" Triplet Representation of " + name + " (" + rows + "x" + cols + ", Non-Zero: " + numTerms + ")");
            System.out.println("-------------------------------------------------");
            System.out.println(" Row  Col  Value");
            System.out.println("---- ---- ------");
            for (Triplet t : terms) {
                System.out.println(t);
            }
            if (numTerms == 0) {
                System.out.println(" [All elements are zero]");
            }
            System.out.println();
        }

        public void printFullMatrix(String name) {
            System.out.println("-------------------------------------------------");
            System.out.println(" Full 2D Grid Form: " + name);
            System.out.println("-------------------------------------------------");

            Map<String, Integer> map = new HashMap<>();
            for (Triplet t : terms) {
                map.put(t.row + "," + t.col, t.value);
            }

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int val = map.getOrDefault(r + "," + c, 0);
                    System.out.printf("%6d", val);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static SparseMatrix inputSparseMatrix(Scanner scanner, String name) {
        System.out.println("\n=================================================");
        System.out.println(" Enter Details for " + name);
        System.out.println("=================================================");
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        SparseMatrix sm = new SparseMatrix(rows, cols);

        System.out.print("Enter number of non-zero elements: ");
        int k = scanner.nextInt();

        System.out.println("Enter each non-zero element as: <row> <col> <value> (0-indexed)");
        System.out.printf("Valid row range: [0..%d], col range: [0..%d]\n", rows - 1, cols - 1);

        for (int i = 1; i <= k; i++) {
            while (true) {
                System.out.printf("Element #%d [row col value]: ", i);
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                int val = scanner.nextInt();

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (val != 0) {
                        sm.addElement(r, c, val);
                    }
                    break;
                } else {
                    System.out.printf("Invalid coordinates (%d, %d)! Please re-enter.\n", r, c);
                }
            }
        }

        sm.sortTerms();
        return sm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println(" ASSIGNMENT 2: SPARSE MATRIX OPERATIONS          ");
        System.out.println(" (Addition, Transpose, and Multiplication)       ");
        System.out.println("=================================================");

        // Input Matrix A
        SparseMatrix matA = inputSparseMatrix(scanner, "Matrix A");
        matA.printTripletRepresentation("Matrix A");
        matA.printFullMatrix("Matrix A");

        // Input Matrix B
        SparseMatrix matB = inputSparseMatrix(scanner, "Matrix B");
        matB.printTripletRepresentation("Matrix B");
        matB.printFullMatrix("Matrix B");

        // 1. Transpose Operations
        System.out.println("\n=================================================");
        System.out.println(" 1. TRANSPOSE OPERATIONS                         ");
        System.out.println("=================================================");
        SparseMatrix transA = matA.transpose();
        transA.printTripletRepresentation("Transpose of A (A^T)");
        transA.printFullMatrix("Transpose of A (A^T)");

        SparseMatrix transB = matB.transpose();
        transB.printTripletRepresentation("Transpose of B (B^T)");
        transB.printFullMatrix("Transpose of B (B^T)");

        // 2. Addition Operation
        System.out.println("\n=================================================");
        System.out.println(" 2. MATRIX ADDITION (A + B)                      ");
        System.out.println("=================================================");
        SparseMatrix sum = SparseMatrix.add(matA, matB);
        if (sum != null) {
            sum.printTripletRepresentation("Result of (A + B)");
            sum.printFullMatrix("Result of (A + B)");
        }

        // 3. Multiplication Operation
        System.out.println("\n=================================================");
        System.out.println(" 3. MATRIX MULTIPLICATION (A * B)                ");
        System.out.println("=================================================");
        SparseMatrix prod = SparseMatrix.multiply(matA, matB);
        if (prod != null) {
            prod.printTripletRepresentation("Result of (A * B)");
            prod.printFullMatrix("Result of (A * B)");
        }

        scanner.close();
    }
}
