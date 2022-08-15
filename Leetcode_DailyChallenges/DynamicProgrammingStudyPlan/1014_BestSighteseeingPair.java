class Solution {

    // Recurssion with Caching (TLE)
    public int maxScoreSightseeingPair(int[] values) {
        // How to memoise
        int[][] dp = new int[values.length][values.length+1];
        for(int[]d: dp) Arrays.fill(d,-1);
        return helper(0, 1, values, values.length,dp);
    }
    
    private int helper(int i, int j, int[]values, int n,int[][]dp){
        if(i>n-2 || j>n-1){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int curr = values[i]+values[j]-j+i;
        int exclude = helper(i,j+1,values,n,dp);
        int include = helper(i+1,j+1,values,n,dp);
        return dp[i][j]=Math.max(Math.max(include, exclude), curr);
        
    }

    // DP with constant space, and keeping track of the max value so far instead of storing them in an array
    public int maxScoreSightseeingPair_DP(int[] values) {
        int max = values[0]; // Since values[0]+0
        int result = 0;
        for(int i=1; i<values.length; i++){
            result = Math.max(result, max+values[i]-i);
            max = Math.max(max, values[i]+i); 
        }
        
        return result;
    }
}