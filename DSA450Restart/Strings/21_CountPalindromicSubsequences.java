package DSA450Restart.Strings;

class Solution_CPS
{

    public static long countPS(String str)
    {
        // Your code here
        long mod = (long)(Math.pow(10,9) + 7);
        int n = str.length();
        long dp[][] = new long[n][n];
        // What does our first loop do?
        for(int k = 0; k<str.length(); k++)
        {
            for(int i=0, j=k; j<str.length(); i++, j++)
            {
                    if(k==0)
                    {
                        dp[i][j] = 1;
                    }
                    else if(k==1)
                    {
                        dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                        
                    }
                    
                    else
                    {
                        dp[i][j] = str.charAt(i) == str.charAt(j) ? (dp[i][j-1] + dp[i+1][j] + 1)%mod : (dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1])%mod;
                        
                    }
                    
                    if(dp[i][j]<0) dp[i][j] += mod;
                
            }
        }
        
        return (dp[0][str.length()-1])%mod;
        
        
    }

    public static void main(String[] args) {
        String s = "abcd";

        System.out.println(countPS(s));


    }





}