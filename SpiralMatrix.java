import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * LC 54.
 *
 * Time Complexity: O(row * col).
 * Space Complexity: O(1).
 */
public class SpiralMatrix {
        public static List<Integer> spiralOrder(int[][] matrix) {
                int operater = 1;
                List<Integer> res = new ArrayList<>();
                int row = matrix.length;
                int col = matrix[0].length;
                int startX = 0;
                int startY = 0;
                int leftBorder = -1;
                int topBorder = -1;
                int rightBorder = col;
                int downBorder = row;
                while (true) {
                        // return condition
                        if (res.size() == row * col) {
                                return res;
                        }
                        res.add(matrix[startX][startY]);
                        switch (operater) {
                                case 1:
                                        // right till the end, modify operator, reset startX and startY, and new border
                                        if (startY + 1 == rightBorder) {
                                                startX += 1;
                                                topBorder += 1;
                                                operater = 2;
                                        } else {
                                                startY += 1;
                                        }

                                        break;
                                case 2:
                                        // down till the end
                                        if (startX + 1 == downBorder) {
                                                startY -= 1;
                                                rightBorder -= 1;
                                                operater = 3;
                                        } else {
                                                startX += 1;
                                        }

                                        break;
                                case 3:
                                        // left till the end
                                        if (startY - 1 == leftBorder) {
                                                startX -= 1;
                                                downBorder -= 1;
                                                operater = 4;
                                        } else {
                                                startY -= 1;
                                        }

                                        break;
                                case 4:
                                        // up till the end
                                        if (startX - 1 == topBorder) {
                                                startY += 1;
                                                leftBorder += 1;
                                                operater = 1;
                                        } else {
                                                startX -= 1;
                                        }
                                        break;
                        }
                }
        }

        public static void main(String[] args) {
                int[][] matrix = new int[][] {{1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}};
                List<Integer> res = new ArrayList<>();
                res = spiralOrder(matrix);
                System.out.println(res);
        }
}
