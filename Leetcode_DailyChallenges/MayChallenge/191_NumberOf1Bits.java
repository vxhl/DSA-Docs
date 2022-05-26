package Leetcode_DailyChallenges.MayChallenge;

class Solution_1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // Approach 1: 
        int count = 0;
        // int mask = 1;
        int i=0;
        while(n!=0)
        {
            n = n&(n-1);
            count++;
        }
        
        return count;
    }
}