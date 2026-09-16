class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        int[][] directions = { { 2, 1 }, { -2, 1 }, { -2, -1 }, { 2, -1 },
                { 1, 2 }, { 1, -2 }, { -1, -2 }, { -1, 2 } };
        // initilize the queue
        Queue<int[]> queue = new LinkedList<>();
        // (current x, current y, move count)
        queue.offer(new int[] { 0, 0, 0 });
        // allow the search to explore down to -2
        boolean[][] visited = new boolean[305][305];
        //Java Arrays Don't Allow Negative Indexes:
        visited[2][2] = true;

        // Step2: perform BFS traversal
        while (!queue.isEmpty()) {
            // [cx, cy] is the current position
            int[] current = queue.poll();
            int cx = current[0], cy = current[1], moves = current[2];
            // check if it's the target cell
            if (cx == x && cy == y) {
                return moves;
            }
            // check all posiible moves from the current position
            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                // String key = nx + "," + ny;
                // add new position and moves
                if (nx >= -2 && ny >= -2 && nx + 2 < 305 && ny + 2 < 305 && !visited[nx+2][ny+2]) {
                    visited[nx+2][ny+2] = true;
                    queue.add(new int[] { nx, ny, moves + 1 });
                }
            }
        }
        return -1;
    }
}