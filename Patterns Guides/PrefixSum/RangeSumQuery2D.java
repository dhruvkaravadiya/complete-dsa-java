// row wise prefix sum (internally still used 1 d prefix matrix)
public class RangeSumQuery2D {

    public static class NumMatrix {

        int[][] matrix;
        int m;
        int n; 
        // constructor to initialize the prefix matrix
        NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            this.matrix = new int[m + 1][n + 1];

            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                   System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            // in the 1 d prefix sum array implementation we left 1st element , 
            // here will do that for first row and first column both
            for(int i = 1 ; i <= m ; i++){
                for(int j = 1 ; j <= n ; j++){
                    this.matrix[i][j] = matrix[i - 1][j - 1]+ this.matrix[i - 1][j]+ this.matrix[i][j - 1]- this.matrix[i - 1][j - 1];
                }
            }
            for(int i = 1 ; i < m+1 ; i++){
                for(int j = 1 ; j < n+1 ; j++){
                   System.out.print(this.matrix[i][j]+" ");
                }
                System.out.println();
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;
            col1++;
            row2++;
            col2++;

            return matrix[row2][col2]
                    - matrix[row1 - 1][col2]
                    - matrix[row2][col1 - 1]
                    + matrix[row1 - 1][col1 - 1];
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix obj = new NumMatrix(matrix);

        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}

// now this is the optimized solution we need O(m*n) time complexity



public class RangeSumQuery2D {

    public static class NumMatrix {

        int[][] matrix;
        int m;
        int n; 
        // constructor to initialize the prefix matrix
        NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            m = matrix.length;
            n = matrix[0].length;
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                   System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            for(int i = 0 ; i < m ; i++){
                for(int j = 1 ; j < n ; j++){
                    matrix[i][j] = matrix[i][j] + matrix[i][j-1];
                }
            }
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                   System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int prefixSum = 0;

            for(int i = row1 ; i <= row2 ; i++){
                if (col1 == 0) {
                    prefixSum += matrix[i][col2];
                }
                else{
                    prefixSum += (matrix[i][col2] - matrix[i][col1-1]);
                }
            }
            

            return prefixSum;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix obj = new NumMatrix(matrix);

        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}