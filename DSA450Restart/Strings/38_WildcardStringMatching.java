package DSA450Restart.Strings;


    class Solution_WildcardMatching {
    



        public boolean isMatch(String s, String p) {
          
            boolean[][] dp = new boolean[p.length()+1][s.length()+1];
    //         for(int ii=0; ii<s.length(); ii++)
    //         {
    //             for(int jj=0; jj<p.length(); jj++)
    //             {
    //                 dp[ii][jj] = false;
    //             }
    //         }
            
            // First comes the initialisation steps for the tabulation
            
            // Base Cases
            dp[0][0] = true;
            
            // If we have exhausted our pattern string
            for(int i=1; i<=p.length(); i++)
            {
                dp[i][0] = false;   
            }
            
            for(int i=1; i<=p.length(); i++)
            {
                boolean flag = true;
                for(int ii = 1; ii<=i; ii++)
                {
                    if(p.charAt(ii-1) != '*')
                    {
                        flag = false;
                        break;
                    }
                }
                dp[i][0] = flag;
            }
            for(int i=1; i<=p.length(); i++)
            {
                for(int j=1; j<=s.length(); j++)
                {
                    if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?')
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
    
                    else if(p.charAt(i-1) == '*')
                    {
                    // We have two recursive calls in this case? 
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
    
                }
            }
            
            return dp[p.length()][s.length()];
            
        }
        public static boolean helper(String s, String p,int i, int j, boolean[][] dp)
        {
            // Base Cases
            if(i<0 && j<0)
            {
                return true;
            }
            
            if(i<0 && j>=0)
            {
                for(int k=0; k<=j; k++)
                {
                    if(p.charAt(k) != '*')
                    {
                       return false; 
                    }
                }
                return true;
            }
            
            if(i>=0 && j<0)
            {
                System.out.print("start");
                return false;
            }
            if(dp[i][j]!=false)
            {
                return dp[i][j];
            }
    
            // Functions
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            {
                return dp[i][j] = helper(s, p, i-1, j-1, dp);
            }
            
            else if(p.charAt(j) == '*')
            {
                // We have two recursive calls in this case? 
                return dp[i][j] = helper(s, p, i-1, j, dp) || helper(s, p, i, j-1, dp);
            }
            
            return dp[i][j] = false;
        }    
        
        
    }
