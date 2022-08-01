class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0){
            return 0;
        }
        int[][]dp = new int[m][n];

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                // If we are the first row or first column, there is always only one way to reach that
                // cell, but 
                if(row==0 || col==0){
                    dp[row][col]=1;
                }
                // Inorder to reach any other cell, we 
                else{
                    dp[row][col] = dp[row][col-1]+dp[row-1][col];
                }
            }
        }
        return dp[m-1][n-1];
    }
}