class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-min);
            min = prices[i]<min?prices[i]:min;
        }
        return maxProfit;
    }
}