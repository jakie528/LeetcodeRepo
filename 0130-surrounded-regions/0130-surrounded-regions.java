class Solution {
    void dfs(char[][] board, int r, int c) {
        int rl = board.length;
        int cl = board[0].length;

        // stpo at anything that isn't '0'
        if(r < 0 || c < 0 || r >= rl || c >= cl || board[r][c] != 'O'){
            return;
        }


        //mark all connected O as S
        board[r][c] = 'S';

        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if ((r == 0 || r == row - 1 || c == 0 || c == col - 1)
                         && board[r][c] == 'O'){
                    dfs(board, r, c);
                }
            }
        }

        // flip O to X, flip S to O, 

        for(int r = 0;  r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(board[r][c] == 'O') 
                    board[r][c] = 'X';
                    else if(board[r][c] == 'S') 
                    board[r][c] = 'O';
                }
            }
        }
    }
