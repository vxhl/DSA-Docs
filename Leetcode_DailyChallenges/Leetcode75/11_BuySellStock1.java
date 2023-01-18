class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i=1; i<prices.length; i++){
            profit = Math.max(profit, prices[i]-buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}

/*
prices = [7,1,5,3,6,4]
         [0,0,0,0,0,0]
first we by then we sell. 
So first we need to buy for the smallest price and then sell on the following day 
for the highest price. 
how do we do that?
We can say we pick 1 and then we sell on 6 so we get a profit of 5. 
But how do we keep track of that? 


7 1 5 3 6 4
0 1 2 3 4 5

*/