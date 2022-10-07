import java.util.Arrays;

public class SlidingCoin {

        public static int[][] steps;

        public static int minimum_ops(char[][]board, int time_K, int row, int column) {
                steps = new int[board.length][board[0].length];
                for (int i = 0; i < steps.length; i++) {
                        Arrays.fill(steps[i], Integer.MAX_VALUE);
                }

                int res = -1;
                findMin(board, time_K, 1, 1, 0, 0);
                for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                                if (board[i][j] == '*') {
                                        res = steps[i][j];
                                        if (res == Integer.MAX_VALUE) {
                                                return -1;
                                        } else {
                                                return res;
                                        }

                                }
                        }
                }
                return res;

        }

        public static void findMin(char[][]board, int time_K, int i, int j, int step, int time) {
                if (i >= board.length || j >= board[0].length) {
                        return;
                }
                if (i < 0 || j < 0) {
                        return;
                }
                if (step >= steps[i][j]) {
                        return;
                }

                steps[i][j] = step;
                if (time == time_K || board[i][j] == '*') {
                        return;
                }

                findMin(board, time_K, i - 1, j, board[i][j] == 'U' ? step : step + 1, time+1);
                findMin(board, time_K, i, j - 1, board[i][j] == 'L' ? step : step + 1, time+1);
                findMin(board, time_K, i + 1, j, board[i][j] == 'D' ? step : step + 1, time+1);
                findMin(board, time_K, i, j + 1, board[i][j] == 'R' ? step : step + 1, time+1);
        }

        public static void main(String[] args) {
                char[][] board = new char[][]{{'R', 'D'}, {'*', 'L'}};
//                for (int i = 0; i < board.length; i++) {
//                        for (int j = 0; j < board[0].length; j++) {
//                                System.out.println(board[i][j]);
//                        }
//                }
                int row = 2;
                int column = 2;
                int time_K = 3;


                int res = minimum_ops(board, time_K, row, column);

                System.out.println(res);


        }
}
