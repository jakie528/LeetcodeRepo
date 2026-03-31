class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        ArrayList<Integer> ls = new ArrayList<>();

        int up = 0;
        int left = 0;
        int right = c - 1;
        int down = r - 1; 

        while (ls.size() < r * c) {
            // Traverse from left to right
            for(int col = left;  col <= right; col++) {
                ls.add(matrix[up][col]);
            }

            // Traverse downwards
            for(int row = up + 1; row <= down; row++) {
                ls.add(matrix[row][right]);
            }

            // we are transit from col to a different row
            if(up != down) {
                for(int col = right - 1; col >= left; col--){
                    ls.add(matrix[down][col]);
                }
            }
            
            // we are transit from row to a different col
            if(left != right) {
                for(int row = down-1; row > up; row--) {
                    ls.add(matrix[row][left]);
                }
            }

            up++;
            right--;
            down--;
            left++;
        }

        return ls;
    }
}