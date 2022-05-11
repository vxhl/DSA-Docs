package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class CountSortedVowelsStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        // Let's first fill the array with our base case when the n=1
        Arrays.fill(dp,1);
        
        // We start the loop from 2 since we already have the answer for 1;
        for(int i=2; i<=n; i++)
        {
            // This loop is for our vowel string
            // We traverse in reverse from the last 2nd element since the last elemnet
            // is always 1
            for(int j=3; j>=0; j--)
            {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        int ans = 0;
        for(int el: dp)
        {
            ans+=el;
        }
        return ans;
    }
}
