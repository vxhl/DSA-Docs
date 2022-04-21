package DSA450Restart.Strings;
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int A, int B, String s1, String s2)
    {
        // your code here
        int[][] dp = new int[A+1][B+1];
        
        // for(int i=0; i<A+1; i++)
        // {
        //     for(int j=0; j<A+1; j++)
        //     {
        //         if(i==0 || j==0)
        //         {
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
        
        
        for(int i=1; i<A+1; i++)
        {
            for(int j=1; j<B+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[A][B];
    }
    
}