class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // create a 2D array initialized to Integer.MAX_VALUE
        int[][] minEffort = new int[m][n];
        for(int[] row : minEffort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;

        // Min-heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{0,0,0});

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == m-1 && col == n-1) {
                return effort;
            }
            // skip, we already found a better path to this cell
            if(effort > minEffort[row][col]) {
                continue;
            }

            // explore neighbors
            for(int[] dir : dirs) {
                // look at 4 valid neighbor
                int neighborRow = row + dir[0];
                int neighborCol = col + dir[1];

                // check in-bounds
                if(neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n) {
                    int diff = Math.abs(heights[neighborRow][neighborCol] - heights[row][col]);
                    int newEffort = Math.max(diff, effort);  // calculate the min effort to the neighbor cell.

                    if(newEffort < minEffort[neighborRow][neighborCol]) {
                        minEffort[neighborRow][neighborCol] = newEffort;
                        queue.offer(new int[]{newEffort, neighborRow, neighborCol});
                    }
                }
            }
        }
        return minEffort[m-1][n-1];
    }
}