class LongestIncreasingPathInMatrix {
    
    int row = 0;
    int col = 0;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        row = matrix.length;
        col = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans = Math.max(ans, bfs(matrix, i, j, memo));
            }
        }
        return ans;
    }
    
    private int bfs(int[][] matrix, int i, int j, int[][] memo){
        
        if(memo[i][j] != 0) return memo[i][j];
        int[] row_arr = {-1, 1, 0,0};
        int[] col_arr = {0, 0, -1, 1};
        int ans = 0;
        
        for(int k=0; k<row_arr.length; k++){
            int c_row = i + row_arr[k];
            int c_col = j + col_arr[k];
            
            if(c_row >= 0 && c_col >= 0 && c_row < row && c_col < col && matrix[c_row][c_col] > matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j], bfs(matrix, c_row, c_col, memo));
            }
            
        }
        return memo[i][j] += 1;
    }
}
