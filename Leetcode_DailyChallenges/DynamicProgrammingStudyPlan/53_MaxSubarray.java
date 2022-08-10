class Solution {
    // DP
    public int maxSubArrayDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }



    // Greedy
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            curr += nums[i];
            if(curr>max){
                max = curr;
            }
            
            if(curr<0){
                curr=0;
            }
        }
        
        return max;
    }
}