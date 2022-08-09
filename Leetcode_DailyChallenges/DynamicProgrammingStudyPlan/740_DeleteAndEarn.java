class Solution{
    public int deleteAndEarn_memo1(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[]d: dp){
            Arrays.fill(d,-1);
        }
        return helper(0, -1, nums, dp);
    }
    private int helper(int i, int prev, int[]nums, int[][]dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int include = 0;
        // Now we just need to check for one condition for the include case
        if(prev==-1 || nums[i]!=nums[prev]+1){
            include = nums[i]+helper(i+1, i, nums,dp);
        }
        int exclude = helper(i+1, prev, nums,dp);
        return dp[i][prev+1]=Math.max(include, exclude);
    }
    

    public int deleteAndEarnTabulation(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int[] freq = new int[max+1];
        for(int i=0; i<nums.length; i++){
            freq[nums[i]]+=nums[i];
        }
        int prev1 = freq[0];
        int prev2 = 0;
        for(int i=0; i<freq.length; i++){
            int include=freq[i];
            if(i>1){
                include+=prev2;
            }
            int exclude = prev1;
            int curr = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}