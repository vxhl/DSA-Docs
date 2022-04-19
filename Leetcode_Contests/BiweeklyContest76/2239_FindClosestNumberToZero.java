package Leetcode_Contests.BiweeklyContest76;
import java.util.*;
class Solution {
    public int findClosestNumber(int[] nums) {
        int comp = Integer.MAX_VALUE;
        int ans = 0;
        ArrayList<Integer> ans1 = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            ans1.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++)
        {
            if(Math.abs(nums[i])<comp)
            {
                comp = Math.abs(nums[i]);
                ans = nums[i];
            }
        }
        return ans1.contains(Math.abs(ans)) ? Math.abs(ans) : ans;
    
    }
}