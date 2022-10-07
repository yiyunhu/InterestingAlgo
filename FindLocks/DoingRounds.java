package FindLocks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a given (m * n) ground where:
 * gb_x, gb_y is the entrance
 * exit_x, exit_y is the exit
 * '1' indicates a wall, cannot pass
 * '2' indicates a lock
 *
 * You start at the starting point and one move consists of walking one space
 * in one of the four cardinal directions. You cannot walk outside the ground,
 * or walk into a wall. You should find the minimum moves to check all locks
 * then get to the exit. If it is impossible, return -1.
 */
public class DoingRounds {
        private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
                int res = -1;
                int row = grounds.length;
                int col = grounds[0].length;
                Path path = new Path(gb_x, gb_y);
                Queue<Path> q = new LinkedList<>();
                q.offer(path);

                boolean[][][] visited = new boolean[row][col][1 << lock_count];

                visited[gb_x][gb_y][path.checked] = true;
                while (!q.isEmpty()) {
                        Path cur = q.poll();
                        if (cur.checkedAll(lock_count) && cur.at(exit_x, exit_y)) {
                                res = cur.length;
                                return res;
                        }
                        // four ways to move
                        for (int i = 0; i < 4; i++) {
                                Path next = cur.move(grounds, i);
                                if (next != null) {
                                        if (visited[next.x][next.y][next.checked] == false) {
                                                visited[next.x][next.y][next.checked] = true;
                                                q.offer(next);
                                        }
                                }
                        }

                }
                return res;
        }


        public static void main(String[] args) {
                int[][] ground = new int[][] {{0, 2, 0}, {1, 1, 3}, {1, 0, 0}};
                int gb_x = 0;
                int gb_y = 1;
                int exit_x = 0;
                int exit_y = 0;
                int num_locks = 2;
                int res = minSteps(ground, gb_x, gb_y, exit_x, exit_y, num_locks);
                System.out.println(res);

        }
}
