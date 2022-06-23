class Solution {
    
    // Memoised
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robHelper(0, nums,dp);
    }
    
    private int robHelper(int ind, int[] arr, int[] dp)
    {  
        if(arr.length-ind<1) return 0;
        
        if(dp[ind]!=-1) return dp[ind];
        
        int include = arr[ind]+robHelper(ind+2, arr,dp);
        int exclude = robHelper(ind+1, arr,dp);
        
        return dp[ind]=Math.max(include, exclude);
    }

    public static void main(String[] args) {
        
    }
}
