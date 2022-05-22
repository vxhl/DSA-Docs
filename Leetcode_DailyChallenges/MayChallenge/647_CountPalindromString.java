package Leetcode_DailyChallenges.MayChallenge; 

class CountPalindromString {
    /*
    I need to write down my approaches more often. 
    
    Ok when i first saw the problem i thought of it to be similar to the longest palindrome substring finding problem so i just made that
    matrix and traversed to find whatever does not have a value for it's palindrome length but that was wrong. I did not figure out exactly why 
    it did not work. 

    Anyway, the actual approach, alteast the first one, is yeah a dynamic programming approach but it is not as simple as it may seem. 
    First we take the single characters and ofc they are all gonna be palindromes so we fill them accrordingly.
    THen we take the double character, ofc this is simple as well, so we take the current char and previous character and fill them accordingly.
    
    This seems pretty easy for a recursive approach but we have overlapping subproblems,
    First let's implement the recursive approach and cross check it with the judge 

    */

    public static int solve_recursive(int i, int j, String s)
    {
        // Ok we return when our indices are equal or i surpasses j
        if(i>=j) return 1;

        // Otherwise we apply our recursive conditions
        if(s.charAt(i) == s.charAt(j))
        {
            // Since we have found both elements as equal we move inward
            return solve(i+1, j-1, s);
        }
        return 0;
    }

    public static int CountPalindromString_recursive(String s)
    {
        int ans = 0;
        for(int i=0; i<s.length()-1; i++)
        {
            for(int j=i; j<s.length(); j++)
            {
                ans += solve_recursive(i+1, j-1, s);
            }
        }

        return ans;
    }

    // Solve memoisation
    public static int solve_memo(int i, int j, String s, boolean[][] dp)
    {
        // Ok we return when our indices are equal or i surpasses j
        if(i>=j) return 1;
        
        if(dp[i][j])
        {
            return 1;
        }
        // Otherwise we apply our recursive conditions
        if(s.charAt(i) == s.charAt(j))
        {
            // Since we have found both elements as equal we move inward
            return dp[i][j] = solve(i+1, j-1, s);
        }
        return 0;
    }

    public static int CountPalindromString_memo(String s)
    {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length()-1; i++)
        {
            for(int j=i; j<s.length(); j++)
            {
                ans += solve_memo(i+1, j-1, s);
            }
        }
        dp[i][j] = ans;

        return ans;
    }


    public static int CountPalindromString_Tabulatio(String s)
    {
        boolean[][] dp = new boolean[n][n];
        for(boolean[] dp1: dp)
        {
            Arrays.fill(dp1, false);
        }
        // First we fill for our originals
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            dp[i][i] = true;
            ans++;
        }

        // We then fill our elements with length 2
        
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] = true;
                ans++;
            }
        }

        // Now we traverse for all elements that are greater than 
        for(int len=3; len<=n; len++)
        {
            for(int i=0, j=i+len-1; j<n; j++, i++)
            {
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
                {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    // The other approach is an expand from middle one where we call isPalindrome function twice for two different types
    // of lengths, odd and even.
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        char[] c = s.toCharArray();
        
        for(int i=0; i<n; i++)
        {
            // We first pass in the same index
            // When we do so this signifies everytime we have an odd length of integers within our range
            ans+=isPalindrome(i, i, c);
            // When we have an even length of integers within our range, the two middle elements always have to
            // be equal
            ans+=isPalindrome(i, i+1, c);
        }
        return ans;
    }
    
    public int isPalindrome(int start, int end, char[] c)
    {
        int count = 0;
        while(start>=0 && end<c.length && c[start--] == c[end++])
        {
            count++;
        }
        
        return count;
    }
}