class Solution {
    
    private boolean helper(int i, int[]nums, int[]dp){
        //Write your own
        if(i>=nums.length){
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==1?true:false;
        }
        boolean res = false;
        // For condition 1 with 2 duplicate elements
        if(i+1<nums.length && nums[i]==nums[i+1]){
            // Valid partition so call recursively for the next
            res = res || helper(i+2, nums,dp);
        }
        if(i+2<nums.length && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            res = res || helper(i+3, nums,dp);
        }
        if(i+2<nums.length && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1){
            res = res || helper(i+3, nums,dp);
        }
        
        dp[i]=res?1:0;
        return res;
        
    }
    public boolean validPartition(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0, nums,dp);
    }
}