
import java.util.*;
public class LongestIncreasingSubsequence {
    
    static int dp[];
    
    public static int LongestIncreasingSubsequence(int[] arr)
    {
        
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        

        return helper(0, arr, Integer.MIN_VALUE, dp);
    }

    public static int helper(int i, int[] arr, int curr, int[] dp)
    {
        if(i==arr.length)
        {
            return 0;
        }

        if(dp[i] != -1)
        {
            return dp[i];
        }

        int include = 0;
        int exclude = 0;
        
        if(arr[i]>curr)
        {
            include = 1+helper(i+1, arr, arr[i], dp);
        }
        else
        {
            exclude = helper(i+1, arr, curr, dp);
        }

        return dp[i] = Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] arr = {4,10,3,8,9};
        System.out.println(LongestIncreasingSubsequence(arr));
    }

}
    // Memoisation Solution
class Solution {
    
        static int[][] dp;
        public static int lengthOfLIS(int[] arr) {
            int n = arr.length;
            
            dp = new int[n][n+1];
            for(int[] dp1: dp)
            {
            Arrays.fill(dp1, -1);
            }
            return helper(0, arr, -1, dp);
            
            // return max;
        
        }
        
         public static int helper(int i, int[] arr, int curr, int[][] dp)
        {
            if(i==arr.length)
            {
                return 0;
            }
    
            if(dp[i][curr+1] != -1)
            {
                return dp[i][curr+1];
            }
    
            int include = 0;
            
            if(curr == -1 || arr[i]>arr[curr])
            {
                include = 1+helper(i+1, arr, i, dp);
            }
            int exclude = helper(i+1, arr, curr, dp);
    
            return dp[i][curr+1] = Math.max(include, exclude);
        }

        public static void main(String[] args) {
            int[] arr = {4,10,3,8,9};
            System.out.println(lengthOfLIS(arr));
        }

        
    }
    

