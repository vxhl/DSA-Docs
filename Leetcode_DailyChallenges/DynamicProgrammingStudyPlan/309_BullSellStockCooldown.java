class Solution {
    // Tabulation


    // Ok so from the memoisation we know that index and the buy varibales are the ones whose states keep changing
    // So we need a dp array of lenght [n+2][2] inorder to keep track of this

    public int maxProfit_Tabulation(int[] prices) {
        // Time for tabulation
        // So this already handles our base case for false lengths
        
        int n = prices.length;
        // Since we are having cooldown, if we are on index n-2, we cannt move to n-2+2 since that would be out of bounds so we set
        // the base condition here
        int[][] dp = new int[n+2][2];


        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                // If we can buy then we simply buy the price since there is no restriction in that case
                if(buy==1){
                    // Then we set the condition for buying or selling for that day and get the max of the two
                    dp[i][buy]=Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }
                // When we are selling, we have the restriction that we cannt pick the next index of prices since there is a cooldown so we i+2
                else{
                    dp[i][buy]=Math.max(prices[i]+dp[i+2][1], dp[i+1][0]);
                }   
            }
        }
        
        return dp[0][1];
        
        
    }


    // Memoisation
    public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for(int[]d: dp) Arrays.fill(d,-1);
            return helper(0, prices, 1,dp);
    }
     private int helper(int i,int[] prices, int buy,int[][]dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        // If we are allowed to buy
        if(buy==1){
            // Then we set the condition for buying or selling for that day and get the max of the two
            return dp[i][buy]=Math.max(-prices[i]+helper(i+1,prices, 0,dp), helper(i+1,prices, 1,dp));
        }
         // When are we not supposed to buy? When we just sell so
        else{
            return dp[i][buy]=Math.max(prices[i]+helper(i+2,prices, 1,dp), helper(i+1, prices,0,dp));
        }
    }
}