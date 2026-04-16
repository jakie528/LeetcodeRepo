class Solution {
    private int size;
    public int totalNQueens(int n) {
        size = n;
        // from the fist row,first column
        // placeQueen
        // isNotUnderAttackRegion
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols){
        // Base Case - N queens have been placed
        if(row == size) {
            return 1;
        }

        int solutions = 0;

        // calculate the diagonals and anti-diagonals
        for(int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            // conflict detected, col++
            if(cols.contains(col) || (diagonals.contains(currDiagonal)) ||
            antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }
            // if not conflict detected, we place the queen
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            // go to next row
            solutions += backtrack(row+1, diagonals, antiDiagonals, cols);

            // the removes happen one at a time, in reverse order 
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }



        return solutions;

    }
}