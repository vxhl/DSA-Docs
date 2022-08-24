import java.util.*;
public class Solution {

    public static int minCostToBuyOranges(int cost[], int w) {
        //Your code goes here
        // Minimum cost to buy oranges
        int[][]dp = new int[1001][1001];
        for(int[]d: dp) Arrays.fill(d,Integer.MAX_VALUE);
        return helper(0, cost, w,dp)==Integer.MAX_VALUE?-1:helper(0,cost,w,dp);
    }
    private static int helper(int ind, int[] cost, int w,int[][]dp){
        if(w==0){
            return 0;
        }
        if(dp[ind][w]!=Integer.MAX_VALUE){
            return dp[ind][w];
        }
        
        if(ind==cost.length){
            return Integer.MAX_VALUE;
        }
        // If we are at an index that is greater than the weight, we cannot ever pick that index
        // so return the MAX value for that
        if(ind+1>w){
            return Integer.MAX_VALUE;
        }
        // Now when do we include? 
        // We also handle the cases for unavailable
        int include=Integer.MAX_VALUE;
        int exclude=Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        if(cost[ind]==-1){
            // If we are always unable to pick the index we return the following
            ans = helper(ind+1, cost, w,dp); 
        }else{
            // If the current index is smaller than the required weight only then can we pick that index
            if(ind+1<=w){
                // Since we are allowed to pick multiple iterations of the same packet, we do not increment the ind when we pick
                include = helper(ind, cost, w-ind-1,dp);
                // If we are not able to get an answer using include, we return a Integer.MAX_VALUE from it, so if we don't
                if(include!=Integer.MAX_VALUE){
                // We add the current cost of the packet
                    include += cost[ind];
                }  
            }    
            // If we never want to pick this packet
            exclude = helper(ind+1, cost, w,dp);
            ans = Math.min(include,exclude);
        }
        return dp[ind][w]=ans;
    }
    
}