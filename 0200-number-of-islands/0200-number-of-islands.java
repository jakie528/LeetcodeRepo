class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int res = 0;




        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
            if(grid[i][j] == '1') {
                dfs(grid, i, j);
                res += 1;
            }
         }
        }

        return res;
        
    }

    private void dfs(char[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;

        // make sure the bound checks valid then operate array access 
        if( r >= n || c >= m || r < 0 || c < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        }
}