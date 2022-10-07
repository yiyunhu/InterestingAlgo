/**
 * Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent
 * cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * lC 79.
 *
 */
public class WordSearch {
        public static boolean exist(char[][] board, String word) {
                int row = board.length;
                int col = board[0].length;
                if (row == 0) {
                        return false;
                }
                if (row * col < word.length()) {
                        return false;
                }
                // search in the whole board
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                if (board[i][j] == word.charAt(0)) {
                                        boolean isFound = dfs(board, word, i, j, 0, new boolean[row][col]);
                                        if (isFound) {
                                                return true;
                                        }
                                }
                        }
                }
                return false;
        }

        private static boolean dfs(char[][] board, String word, int row, int col, int foundLength, boolean[][] visited) {
                // outside the board
                if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(foundLength)) {
                        return false;
                }
                // already visited
                if (visited[row][col]) {
                        return false;
                }
                if (foundLength == word.length()) {
                        return true;
                }

                visited[row][col] = true;
                if (dfs(board, word, row, col - 1, foundLength + 1, visited)) {
                        return true;
                }
                if (dfs(board, word, row, col + 1, foundLength + 1, visited)) {
                        return true;
                }
                if (dfs(board, word, row - 1, col, foundLength + 1, visited)) {
                        return true;
                }
                if (dfs(board, word, row + 1, col, foundLength + 1, visited)) {
                        return true;
                }
                visited[row][col] = false;
                return false;

        }

        public static void main(String[] args) {
                char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
                String word = "ABCB";
                boolean res = exist(board, word);
                System.out.println(res);

        }
}
