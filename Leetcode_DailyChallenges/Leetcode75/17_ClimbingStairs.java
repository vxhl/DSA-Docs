class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i]=dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    }
}

/*
takes n steps to reach the top
each time can climb 1 or 2 steps.
How many distinct ways can we climb to the top

*/