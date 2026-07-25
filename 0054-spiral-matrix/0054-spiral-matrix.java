class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101; 
                // Change in row index for each direction
        int[] dr = { 0, 1, 0, -1 };

        // Change in column index for each direction
        int[] dc = { 1, 0, -1, 0 };

        int r = 0, c = 0;
        int idx = 0; // initial direction index (0 correspond to right) 1 down, 2 left, 3 up 
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < m*n; i++) {
            res.add(matrix[r][c]);
            // mark current cell as visited
            matrix[r][c] = VISITED;

            // calculate next cell coordinates based on current direction
            int newR = r + dr[idx];
            int newC = c + dc[idx];

            // check if next cell is within boounds and not visited
            if(0 <= newR && newR < m && 0 <= newC && newC < n && matrix[newR][newC]!= 101) {
                // move to the new row
                r = newR;
                // move to the next column
                c = newC;

            } else {
                // change directions
                idx = (idx + 1) % 4;

                // move to the next row
                r += dr[idx];
                c += dc[idx];
            }
        }
        return res;
    }
}