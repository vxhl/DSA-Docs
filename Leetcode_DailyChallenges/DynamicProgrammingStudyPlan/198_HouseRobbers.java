import java.util.*;
class Solution_Dynamic {
    
    public int rob_constantSpace(int[]nums){
        // We first take a previous count for the previous most house
        int prev1 = nums[0];
        // We set prev2 for the non adjacent position
        int prev2 = 0;

        for(int i=0; i<nums.length; i++){
            int include = nums[i];
            // If we include we need to be at the 3rd position atleast for having a non adjacent element previously
            if(i>1){
                include+=prev2;
            }
            // If we exclude we simply start with the current element
            int exclude = prev1;
            int curr = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }

    
    public int rob_tabulated(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            int include = nums[i];
            if(i>1){
                include+=dp[i-2];
            }
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[nums.length-1];
    }
    

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
        int[] arr= {2,7,9,3,1};
        int[] dp = new int[arr.length];
        Solution_Dynamic sol = new Solution_Dynamic();
    
        System.out.print(sol.rob(arr));
        for(int i=0; i<dp.length; i++)
        {
            System.out.print(dp[i]+ " ");
        }
    
    }

    // Tabulated
    public int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        // So if we are at the first index, then the max houses we can rob is only the first index
        dp[0] = nums[0];
        
        // then we start to calculate for the rest of the indexes
        for(int i=1; i<nums.length; i++)
        {
            // We first try and pick for the previous non-adjacent house and add it up after checking the boundary
            int include = nums[i];
            if(i>1) include+=dp[i-2];
            int exclude = dp[i-1];
            
            // We store for i, the include and exclude case
            dp[i] = Math.max(include, exclude);
        }
        
        return dp[nums.length-1];
    }

    // Space Optimised: Tabulation
    // Memoised
    public int rob3(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1; i<nums.length; i++)
        {
            int include = nums[i];
            if(i>1) include+=prev2;
            int exclude = prev1;
            int curr = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
