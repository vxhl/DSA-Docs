package Leetcode_DailyChallenges.MayChallenge;

class Solution {

    int[][][] dp;
    
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m+1][n+1][strs.length];
        int[][] strFreq = new int[strs.length][2];
        int i = 0;
        for(String str: strs)
        {
            strFreq[i] = FindFreq(str);
            i++;
        }
        
        return findMaxForm_Utils(0, m, n, strs, strFreq, dp);
    }
    
    
    private static int findMaxForm_Utils(int index, int m, int n, String[] strs, int[][] strFreq, int[][][] dp)
    {
        if(index >= strs.length || (m+n)<=0)
        {
            return 0;
        }
        
        if(dp[m][n][index]!=0)
        {
            return dp[m][n][index];
        }
        
        int curr0s = strFreq[index][0];
        int curr1s = strFreq[index][1];
        
        int include = 0;
        int exclude = 0;
        
        if(curr0s<=m && curr1s<=n)
        {
             include = 1 + findMaxForm_Utils(index+1, m-curr0s, n-curr1s, strs, strFreq, dp);      
        }
        exclude = findMaxForm_Utils(index+1, m, n, strs, strFreq, dp);
        
        
        return dp[m][n][index] = Math.max(include, exclude);
        
        
    }
    
    
    
    private int[] FindFreq(String str)
    {
        int[] freq = new int[2];
        
        for(char c: str.toCharArray())
        {
            if(c=='0')
            {
                freq[0]++;
            }
            else
            {
                freq[1]++;
            }
        }
        return freq;
        
        
    }
}


/*

int[] freq = new int[2];
[freq0s, freq1s]

*/