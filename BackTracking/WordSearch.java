public class WordSearch {
      public static void main(String[] args) {
            char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
            String word = "ABCCED";
            int row = board.length;
            int col = board[0].length;
            boolean visited[][] = new boolean[row][col];
            System.out.println(exist(board, visited, word, 0, 0, 0));
      }

      public static boolean exist(char[][] board, boolean[][] visited, String word, int i, int j,
                  int currentStringIndex) {
            if (currentStringIndex == (word.length())) {
                  return true;
            }
            // out of boound or already visited or not matching then false
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                        || word.charAt(currentStringIndex) != board[i][j]) {
                  return false;
            }

            // now mark the current cell as visited
            visited[i][j] = true;
            System.out.println("i: " + i + " j: " + j + " currentStringIndex: " + word.charAt(currentStringIndex));

            boolean exist = exist(board, visited, word, i + 1, j, currentStringIndex + 1)
                        || exist(board, visited, word, i - 1, j, currentStringIndex + 1)
                        || exist(board, visited, word, i, j - 1, currentStringIndex + 1)
                        || exist(board, visited, word, i, j + 1, currentStringIndex + 1);
            if (!exist) {
                  visited[i][j] = false;
            }
            return exist;
      }
}
