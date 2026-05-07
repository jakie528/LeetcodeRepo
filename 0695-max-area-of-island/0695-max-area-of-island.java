class Solution {

    public int dfs(int[][] grid, int r, int c) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        if(r >= rowLength || c >= columnLength || r < 0 || c < 0 || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        

        return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);     
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < columnLength; j++) {
                if(grid[i][j] == 1){
                   maxArea= Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }
}