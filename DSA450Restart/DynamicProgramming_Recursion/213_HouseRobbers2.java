import java.util.*;

class Solution {
    public int rob(int[] arr) {
        if(arr.length==1) return arr[0];
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        
        for(int i=0;i<arr.length; i++)
        {
            if(i!=0) temp1.add(arr[i]);
            if(i!=arr.length-1) temp2.add(arr[i]);
        }
        int n = temp1.size();
        int[] temp11 = new int[n];
        int[] temp22 = new int[n];
        for(int i=0; i<n; i++)
        {
            temp11[i] = temp1.get(i);
            temp22[i] = temp2.get(i);
        }
        return Math.max(helper(temp11), helper(temp22));
    }
    
    private int helper(int[] nums)
    {
        int[] dp = new int[nums.length];
        // So if we are at the first index, then the max houses we can rob is only the first index
        // dp[0] = nums[0];
        int prev1 = nums[0];
        int prev2 = 0;
        // then we start to calculate for the rest of the indexes
        for(int i=1; i<nums.length; i++)
        {
            // We first try and pick for the previous non-adjacent house and add it up after checking the boundary
            int include = nums[i];
            if(i>1) include+=prev2;
            int exclude = prev1;
            int curr = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = curr;
            // We store for i, the include and exclude case
        }
        return prev1;
    }
}