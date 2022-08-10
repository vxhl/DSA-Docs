class Solution {    
    //         [2,3,1,1,4] -> We need to reach 4 so, n-2 can reach 4, n-3 can reach n-2, n-4 can reach n-3, n-5 can reach n-4 so true
    //         [3,2,1,0,4] -> n-2 cannot reach n-1, n-3 can reach 0, n-4 can reah 0, n-5 can reach 0 so return false
    //         [2,0,0]-> n-2 cannot reach n-1, n-3 can reach n-1 so return true
        // Greedy
        public boolean canJump_Greedy(int[] nums) {
            // We loop from the last element of the array, which is the destination for this given problem
            int lgip = nums.length-1;
            for(int i = nums.length-1; i>=0; i--)
            {
                if(i+nums[i]>=lgip) // While the 
                {
                    lgip = i;
                }
            }
            return lgip==0;
        }

        // DP
        public boolean canJump(int[] nums) {
            int[]dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return helper(0, nums,dp);
        }
        
        private boolean helper(int idx, int[]nums, int[]dp){
            // We can reach the goal when our current idx is equal to the last elements index
            if(idx==nums.length-1){
                return true;
            }
            // If we ever encounter a 0, we can return a false
            if(nums[idx]==0){
                dp[idx]=0;
                return false;
            }
            if(dp[idx]!=-1){
                return dp[idx]==1?true:false;
            }
            int jumps = nums[idx];
            // Now for the range of jumps that we have, we loop till the range we have from the current index meaning currIdx+i till nums[currIdx]
            for(int i=1; i<=jumps; i++){
                if(helper(idx+i, nums,dp)){
                    dp[idx]=1;
                    return true;
                }
            }
            // If the loop doesn't return true, we return false for the current call
            dp[idx]=0;
            return false;
        }
    }