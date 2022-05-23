package Leetcode_DailyChallenges.MayChallenge;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // First we fill our first row
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<amount+1; j++)
            {
                // If the number of coins we have at hand is 0 and the amount we
                // need to get >= 1 then it is not possible to get the value
                if(i==0)
                {
                    dp[i][j] = 10000;
                }
                // Otherwise if the number of coins we need to get is 0 and
                // we have >= 0 number of coins at hand then we can get the value
                // by taking 0 coins from our coins array
                if(j==0)
                {
                    dp[i][j] = 0;
                }
            }
        }
            for(int i=1; i<n+1; i++)
            {
                for(int j=1; j<amount+1; j++)
                {
                    if(coins[i-1]<=j)
                    {
                        // Now we have two conditions for include and exclude
                        // If we include, then we increment the number of element
                        // so we do 1+ and we also get the last element that we picked
                        
                        // For example, for an amount of 0 we picked 0 elements
                        // for an amount of 1, we pick the element that is at coins[i-1](0)
                        // We find the element that is at coins[i-1] to be 1 right
                        // and the amount that we are trying to make in the first iteration is 1
                        // and it meets the condition of being <= j
                        // because of that, we add it into our answer 
                        // But at the same time we also check the value that we got from
                        // our previous computation, and we put that instead if we find the current to                      be greater and that is the purpose for dp[i-1][j] -> We look upwards to see
                        // if we have a smaller value already and assign it, otherwise there is no
                        // point in searching for the minimum
                        
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                    }
                    else
                    {
                        // Otherwise if we find that the current element is greater
                        // then we simply do not pick that element 
                        // and we at the same time, also set the previous answer we got back here
                        dp[i][j] = dp[i-1][j]; 
                    }
                }
            }
            
        return dp[n][amount]==10000?-1 : dp[n][amount];
               
        }
}
