class Solution {

    private int rows;
    private int cols;
    private String targetWord;
    private char[][] grid;

    // Determines if the word exists in the board by searching all possible paths
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.targetWord = word;
        this.grid = board;

        // search from every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        // Word not found in any path
        return false;

    }

    /***
    
    @param
    index current
    character index
    in the
    current word*/

    private boolean dfs(int r, int c, int index) {
        // check if it out of bounds
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return false;

        // check if the current cell match the character
        if (grid[r][c] != targetWord.charAt(index))
            return false;

        // check whther the path length match the word length
        if (index == targetWord.length() - 1) {
            return true;
        }

        char saved = grid[r][c];
        grid[r][c] = '#'; // mark visited in place
        boolean found = dfs(r + 1, c, index + 1) || dfs(r - 1, c, index + 1) || dfs(r, c + 1, index + 1)
                || dfs(r, c - 1, index + 1);
        grid[r][c] = saved; //undo

        return found;

    }
}
