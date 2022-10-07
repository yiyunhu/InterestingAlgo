package FindLocks;

public class Path {
        // A utility class which tracks position, locks checked, and path length
        int x;		      // current position in the level
        int y;
        int checked;	  // mask of locks checked so far
        int length;	    // number of steps taken so far

        // initialize the path at the starting location
        Path(int start_x, int start_y) {
                x = start_x; y = start_y; checked = 0; length = 0;
        }
        // incremental update of position (internal use only)
        private Path(int new_x, int new_y, int pl, int ch) {
                x = new_x; y = new_y; checked = ch; length = pl;
        }

        // try to move in the indicated direction, and return a new
        //   instance at the new location if able to move
        Path move(int [][] level, int direction) {
                int new_x = x;
                int new_y = y;
                if (direction == 0) new_x--;
                else if (direction == 1) new_y--;
                else if (direction == 2) new_x++;
                else if (direction == 3) new_y++;
                else return null;
                if (new_x < 0 || new_y < 0 || new_x >= level.length
                        || new_y >= level[0].length || level[new_x][new_y] == 1)
                        return null;
                Path newpath = new Path(new_x,new_y,length+1,
                        addLock(checked,level,new_x,new_y));
                return newpath;
        }

        // is the position of the current instance the target position?
        boolean at(int target_x, int target_y) {
                return x == target_x && y == target_y;
        }
        // have we checked all locks on the path we've taken?
        boolean checkedAll(int num_locks) {
                return checked == allLocks(num_locks);
        }

// Low-level utility functions

        // Return a bit mask representing the lock (if any) at location
        //   (x,y) in the level
        public static int lockMask(int[][] level, int x, int y) {
                int lock = level[x][y];
                return (lock < 2) ? 0 : (1 << (lock-2));
        }
        // Add a bit flag for the lock (if any) at location (x,y) in the
        //   level to the previous set of locks
        public static int addLock(int oldmask, int[][] level, int x, int y) {
                return oldmask | lockMask(level,x,y);
        }
        // Return the bitmask representing all locks.
        public static int allLocks(int lock_count) {
                return (1 << lock_count) - 1;
        }
        // number of possible combinations of collected locks
        public static int combinations(int lock_count) {
                return (1 << lock_count);
        }
}
