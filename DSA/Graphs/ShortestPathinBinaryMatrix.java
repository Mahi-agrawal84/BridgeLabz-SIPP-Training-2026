import java.util.*;

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or end blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1}); // row, col, distance
        grid[0][0] = 1; // mark visited

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            // Reached destination
            if (row == n - 1 && col == n - 1)
                return dist;

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < n && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1; // visited
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
