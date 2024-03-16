import java.util.ArrayList;
import java.util.List;

public class NQueens {
      public static void main(String[] args) {
            int n = 4;
            List<List<String>> result = new ArrayList<>();
            result = solveNQueens(n);
            for (List<String> list : result) {
                  System.out.println(list);
            }
      }

      public static List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                        board[i][j] = '.';
                  }
            }
            List<List<String>> result = new ArrayList<List<String>>();
            int leftRowHash[] = new int[n];
            int upperDiagonalHash[] = new int[2 * n - 1];
            int lowerDiagonalHash[] = new int[2 * n - 1];
            solve(0, board, result, leftRowHash, upperDiagonalHash, lowerDiagonalHash);
            return result;
      }

      public static void addResult(List<List<String>> result, char[][] board) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                  String s = new String(board[i]);
                  list.add(s);
            }
            result.add(list);
      }

      public static void solve(int col, char[][] board, List<List<String>> result, int[] leftRowHash,
                  int[] upperDiagonalHash, int[] lowerDiagonalHash) {

            // if the column becomes equal to the board length,
            // eg : 4, then just add the board to the result
            if (col == board.length) {
                  addResult(result, board);
                  return;
            }

            // Loop through the rows of the board
            // and check if the current position
            // is safe to place the queen or not
            for (int row = 0; row < board.length; row++) {
                  // check three conditions ,
                  // if the left row has no queens, i.e. leftRowHash[row] == 0
                  // if the upper diagonal has no queens, i.e. upperDiagonalHash[row + col] == 0
                  // if the lower diagonal has no queens,
                  // i.e. lowerDiagonalHash[board.length - 1 + col - row] == 0
                  if (leftRowHash[row] == 0 && upperDiagonalHash[row + col] == 0
                              && lowerDiagonalHash[board.length - 1 + col - row] == 0) {
                        // mark the current position as safe
                        leftRowHash[row] = 1;
                        // mark the upper diagonal as safe
                        upperDiagonalHash[row + col] = 1;
                        // mark the lower diagonal as safe
                        lowerDiagonalHash[board.length - 1 + col - row] = 1;
                        // place the queen at the current position
                        board[row][col] = 'Q';
                        // call the solve function for the next column
                        solve(col + 1, board, result, leftRowHash, upperDiagonalHash, lowerDiagonalHash);
                        // backtracking step
                        board[row][col] = '.';
                        // mark the current position as unsafe
                        leftRowHash[row] = 0;
                        // mark the upper diagonal as unsafe
                        upperDiagonalHash[row + col] = 0;
                        // mark the lower diagonal as unsafe
                        lowerDiagonalHash[board.length - 1 + col - row] = 0;
                  }
            }
      }
}