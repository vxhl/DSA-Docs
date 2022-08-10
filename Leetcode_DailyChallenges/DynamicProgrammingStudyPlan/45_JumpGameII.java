class Solution {
    // int minJumps=Integer.MAX_VALUE;

    // Tabulation
    public int jump_Tab(int[] nums){
        // Ok this is the minimum number of jumps we can do
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10001);
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            for(int jumpLen=1; jumpLen<=nums[i]; jumpLen++){
                // We check for every possible length for the current index in the range of nums[i]
                dp[i]=Math.min(dp[i], 1+dp[Math.min(n-1, jumpLen+i)]);
            }
        }
        return dp[0];
    }


    public int jump(int[] nums){
        // Ok this is the minimum number of jumps we can do
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0, nums,dp);
    }
    private int helper(int idx, int[]nums, int[]dp){
        // Ok we can assume that we always reach the last index
        // So let's say this time when we reach the last index the we return 0
        if(idx>=nums.length-1){
            // return 0 since no jumps needed to reach the end of the array
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int minJumps = 10001;
        int jumps = nums[idx];
        for(int i=1; i<=jumps; i++){
            minJumps = Math.min(minJumps, 1+helper(idx+i,nums,dp));
        }
        return dp[idx]=minJumps;
    }
}