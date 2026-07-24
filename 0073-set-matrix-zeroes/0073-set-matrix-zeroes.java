class Solution {
    public void setZeroes(int[][] matrix) {
        // just mark the first row/column cell incase of a cell with zero values
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstColZero = false;

        // mark the row and col need to update to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    // we already set the ith row = 0
                    // if this zero comes from the first column
                    if(j == 0) {
                        isFirstColZero = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // we cannot zero out all 1st colum and 1st row because it might come from other column/row
        if(matrix[0][0] == 0) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(isFirstColZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}