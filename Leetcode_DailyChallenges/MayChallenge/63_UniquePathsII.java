package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Solution {
    
    // Memoisation
    public int uniquePathsWithObstacles2(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] dp1: dp)
        {
            Arrays.fill(dp1,-1);
        }
        
        if(grid[0][0] == 1)
        {
            return 0;
        }
        return isPathUnique(0,0,grid.length, grid[0].length, grid,dp);   
    }
    public int isPathUnique(int i, int j, int m, int n, int[][] grid,int[][] dp)
    {   
        int[] xdir = {0,1};
        int[] ydir = {1,0};
        
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int ans = 0;
        for(int k=0; k<2; k++)
        {
            int newx = i + xdir[k];
            int newy = j+ ydir[k];
            
            if(newx>=0 && newy>=0 && newx<m && newy<n && grid[newx][newy] != 1)
            {
                ans += isPathUnique(newx, newy, m, n, grid, dp);
            }
        }
        
        return dp[i][j] = ans;  
    }
    
    
    
    
    
    // Tabulation Method
    public int uniquePathsWithObstacles(int[][] grid) {
        
        if(grid[0][0] == 1)
        {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        // The initialisation is the most important part with this problem
        boolean flag = false;
        
        // Fill first row
        for(int i=0; i<n; i++)
        {
            // If our flag is true or we have obstacle in the way
            if(flag || grid[0][i] == 1)
            {
                // If it was initially false we set as true
                flag = true;
                dp[0][i] = 0; // There is no way to reach this cell
            }
            else
            {
                dp[0][i] = 1;
            }
        }
        
        // We reset our flag
        flag = false;
        // We fill the first column now
        for(int i=0; i<m; i++)
        {
            if(flag || grid[i][0]==1)
            {
                flag = true;
                dp[i][0] = 0;
            }
            else
            {
                dp[i][0] = 1;
            }
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
//     public boolean isValid(int[][] grid, int newx, int newy)
//     {
//         int m = grid.length;
//         int n = grid[0].length;
//         if(newx>=0 && newy>=0 && newx<m && newy<n && grid[newx][newy] != 1)
//         {
//             return true;
//         }
//         return false;
//     }
    
    
    
}
