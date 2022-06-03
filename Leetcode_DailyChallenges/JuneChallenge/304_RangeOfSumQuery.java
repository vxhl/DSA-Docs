class NumMatrix {
    int[][] matrix;
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        dp = new int[matrix.length+1][matrix[0].length+1];
        
        for(int i=1; i<matrix.length+1; i++)
        {
            for(int j=1; j<matrix[0].length+1; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Now for deriving the answer from the dp matrix
        // We first add whatever the current value is at row2+1 and col2+1
        // After that we subtract the remaining parts that we do not need
        // and we add the common part that we do need and got subtracted twice.
        int sum = dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */