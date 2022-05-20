package Leetcode_DailyChallenges.MayChallenge;

class Solution {
    public int uniquePaths(int m, int n) {
        // int[] xdir ={0,1};
        // int[] ydir = {1,0};
        // Memoise and Tabulate later
        if(m==0 && n==0)
        {
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int row=0; row<m; row++)
        {
            for(int col=0; col<n; col++)
            {
                if(row==0 || col==0)
                {
                    dp[row][col] = 1;
                }
                else
                {
                    dp[row][col]= dp[row-1][col] + dp[row][col-1];
                }
            }
            
        }
        
        return dp[m-1][n-1];
        
    }
    
    static int isPath(int i, int j, int m, int n,int[][]dp)
    {
        if(i>=m || j>=n)
        {
            return 0;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        
        return dp[i][j] = isPath(i+1,j,m,n,dp) + isPath(i, j+1,m,n,dp);
        
    }
}