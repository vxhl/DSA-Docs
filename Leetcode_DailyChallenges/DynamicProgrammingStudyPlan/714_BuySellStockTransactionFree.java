class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        int n = prices.length;
        
        for(int i=n-1; i>=0; i--){
            dp[i][1]=Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
            dp[i][0]=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
        }
        return dp[0][1];
    }
    private int helper(int ind, int[]prices, int fee, int buy,int[][]dp){
        if(ind==prices.length){
            return 0;
        }
        
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        
        if(buy==1){
            return dp[ind][buy]=Math.max(helper(ind+1,prices, fee, 0,dp)-prices[ind], helper(ind+1, prices, fee,1,dp));
        }
        else{
            return dp[ind][buy]=Math.max(prices[ind]-fee+helper(ind+1,prices, fee, 1,dp), helper(ind+1, prices, fee, 0,dp));
        }
    }
}