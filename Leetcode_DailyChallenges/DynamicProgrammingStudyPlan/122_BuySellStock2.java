class Solution {

        // Recursion with memoisation 
        public int maxProfitDP(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for(int[]d: dp) Arrays.fill(d,-1);
            return helper(0, prices, 1,dp);
        }
        
        private int helper(int i,int[] prices, int buy,int[][]dp){
            if(i==prices.length){
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
            // If we are not allowed to buy then we sell ofc
            else{
                return dp[i][buy]=Math.max(prices[i]+helper(i+1,prices, 1,dp), 0+helper(i+1, prices,0,dp));
            }
    }

    // Constant space linear time solution
    public int maxProfit(int[] prices) {
        // Ok got a very awesome solution, this is gonna stay hopefully
        int buy = 0;
        int sell = 0;
        int days = prices.length;
        int accumulatedProfit = 0;
        
        
        while(buy<days && sell<days){
            // while our next price is smaller than our current pirce it means we have not
            // found a valley yet, so keep going
            while(buy<days-1 && prices[buy+1]<prices[buy]){
                buy++;
            }
            // Now we have found the index for the current buy interval and 
            // now we are to find the latest peak
            sell=buy;
            
            // As long as our next element is greater we keep moving forward, inorder to find a peak we need 
            // our next element to be smaller so
            while(sell<days-1 && prices[sell+1]>prices[sell]){
                sell++;
            }
            
            // Now we append to our profit
            
            accumulatedProfit+= prices[sell]-prices[buy];
            
            // after finding it, we then start finding the next valley and peak so we set our next buy as the element
            // next to our most recent sell
            buy=sell+1;
        }
        
        return accumulatedProfit;
        
    }
}