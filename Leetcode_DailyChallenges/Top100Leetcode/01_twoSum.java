package Leetcode_DailyChallenges.Top100Leetcode;
import java.util.*;
class Solution
{
    public int[] twoSum(int[] arr, int target) {
        // We create a hashmap for checking whetehr target-arr[i] is in our map, if it is then
        // we just return the ith index and the target-arr[i] elements index
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0; i<arr.length; i++)
        {
            if(mp.containsKey(target-arr[i]))
            {
                ans[0] = mp.get(target-arr[i]);
                ans[1] = i;
                return ans;
            }
            else
            {
            mp.put(arr[i], i);
            }
        }
        
        return ans;
        
        
    }
}