import java.util.*;

class Solution {
    
    public boolean comparePossible(String wordA, String wordB)
    {
        if(wordA.length()!=wordB.length()+1) return false;
        
        int startA = 0;
        int startB = 0;
        
        while(startA<wordA.length() && startB<wordB.length())
        {
            if(wordA.charAt(startA) == wordB.charAt(startB))
            {
                startA++;
                startB++;
            }
            else
            {
                startA++;
            }       
        } 
        
        if(startA == wordA.length() && startB == wordB.length()) return true;
        return false;
        
    }
    public int longestStrChain(String[] words) {
        
        // first we do the longest increasing subsequence
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        int max = 1;
        for(int i=0; i<words.length; i++)
        {
            for(int prev = 0; prev<i; prev++)
            {
                if(comparePossible(words[i], words[prev]))
                {
                    dp[i] = Math.max(dp[i], 1+dp[prev]);
                }
            }
            max = Math.max(max, dp[i]);
            
        }
        
        return max;
    }
}