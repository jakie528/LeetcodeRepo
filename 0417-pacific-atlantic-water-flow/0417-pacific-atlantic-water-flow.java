class Solution {
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // two boolean sets.
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificVisited = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];

        List<List<Integer>> res = new ArrayList<List<Integer>>();

 
        // Start from ocean borders
        // from top row + left column
        for(int i = 0; i < n; i++) {
            dfs(heights, pacificVisited, i, 0);
        }

        for(int j = 0; j < m; j++) {
            dfs(heights, pacificVisited, 0, j);
        }

        // from down row + right column
        for(int i = 0; i < n; i++) {
            dfs(heights, atlanticVisited, i, m-1);
        }
        
        for(int j = 0; j < m; j++) {
        dfs(heights, atlanticVisited, n-1, j);
        }


        // Find intersections

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // both are true
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;

    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {

        if (i >= 0 && j < heights[0].length && j >= 0 && i < heights.length) {
            visited[i][j] = true;
        } else
            return;

        // check if neighbor height >= current height
        for (int[] direction : directions) {
            //one comparison: for example down for the first directions

            int ni = i + direction[0];
            int nj = j + direction[1];

            if (ni >= 0 && nj < heights[0].length && nj >= 0 && ni < heights.length) {

                if (heights[ni][nj] >= heights[i][j] && !visited[ni][nj]) {
                    dfs(heights, visited, ni, nj);
                }
            }
        }

    }
}