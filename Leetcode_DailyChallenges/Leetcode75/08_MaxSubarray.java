class Solution {
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            max = Math.max(sum, max);
            if(sum<0){
                sum=0;
            }
        }
        return max;    
    }
    // DP approach while caching
    public int maxSubArray(int[] nums){
        int sum = 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}