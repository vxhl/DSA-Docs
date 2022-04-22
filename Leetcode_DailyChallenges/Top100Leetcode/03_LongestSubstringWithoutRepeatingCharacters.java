package Leetcode_DailyChallenges.Top100Leetcode;
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = Integer.MIN_VALUE;
        if(s.length()==0) return 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        
        while(right<s.length())
        {
            // if our elements index is already in the map
            // In that case we compare if that index is smaller than or greater than our left index
            // If it turns out to be greater than our left index, in that case we set our left index as
            // left = mp.get(s.charAt(right))+1;
            // If it turns out to be smaller than our left index, in that case we don't do anything, we simply continue
            if(mp.containsKey(s.charAt(right)))
            {
                // If we find that our elements positions if greater than or equal to our left pointer than we reset our left pointers
                // position by one position and we keep doing it until our repeating character is out of the window meaning our left pointer is greater than our right pointer
                if(mp.get(s.charAt(right))>=left)
                {
                    left = mp.get(s.charAt(right))+1;
                }
            }
            mp.put(s.charAt(right), right);
            ans = Math.max(ans, right-left+1);
            right++;
            
        }
        
        return ans;
        
    }
}