class Solution {
    public boolean isValidSudoku(char[][] board) {
        //each 3*3 cells 
        // record whether the rows has repetition
        // record whether column has repetition
        // record each 3*3  boxes contain the repetition
        // Map: num : freq . freq > 1 return false.
        int N = 9;

        boolean[][] rows = new boolean[N][N];
        boolean[][] columns = new boolean[N][N];
        boolean[][] boxes = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                // Covert each digit to 0-based index
                int digitIndex = board[i][j] - '1';
                // Covert the box index (0-8)
                int boxIndex = (i/3) * 3 + j/3;

                // Calculate the column || row
                if(columns[i][digitIndex] ||  rows[digitIndex][j] || boxes[boxIndex][digitIndex])  {
                    return false;
                }

                columns[i][digitIndex]  = true;
                rows[digitIndex][j] = true;
                boxes[boxIndex][digitIndex] = true;
            }
        }
        return true;
    }
}





