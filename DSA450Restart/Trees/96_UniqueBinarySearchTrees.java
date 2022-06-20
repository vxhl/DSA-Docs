class Solution {

    // Naive Recursive Solution
    // Time Complexity: O(3^N)
    public int numTrees(int n) {
        // First let us just write down the recursive approaches
        
        if(n<1) return 1;
            
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            ans += numTrees(i)*numTrees(n-i-1);
        }
        
        return ans;
    }
    
    public int numTrees_dp(int n) {
        // First let us just write down the recursive approaches
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
        {
            for(int j=0; j<i; j++)
            {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}