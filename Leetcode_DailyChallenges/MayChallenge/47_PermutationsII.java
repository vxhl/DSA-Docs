package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class PermutationsII
{
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Unlike the previous one here I don't think we need a frequency array do we
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ans1 = new HashSet<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        f(nums, ds, vis, ans1);   
        
        for(List<Integer> i: ans1)
        {
            ans.add(i);
        }
        return ans;
        
    }
    
    public static void f(int[] nums, List<Integer> ds, boolean[] vis, Set<List<Integer>> ans)
    {
        if(ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<nums.length; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                ds.add(nums[i]);
                f(nums, ds, vis, ans);
                vis[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
