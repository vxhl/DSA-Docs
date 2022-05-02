/*
Problem Statement - 
Given an array `nums` of distinct integers, return all the possible permutations.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
package Recurssion;

import java.util.*;
public class permutations 

{
    /*
    How are permutations any different? 
    Ok so subsets are basically always in the same order as the array
    but in permutations we have different arrangements of the same array
    So the length always stays the same only the arrangements keep changing
    Once again we can do this with recursion but can we actually do this using the permutation formula
    which is n!/(n-r)!so from that we just get the number of permutations that can be made but we do not actually get
    the permutations obviously.
    */
    

    // Approach 1 using a boolean freq array
    private static void permuteutil(int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans, boolean freq[])
    {
        // base case
        // So our base case is basically everytime we get the permutation that is the same size as our given array
        if(ds.size() == nums.length)
        {
            ans.add(ds);
            return;
        }
        // We then define our conditions
        for(int i=0; i<nums.length; i++)
        {
            // Instead of a map we use a boolean array to keep track of whether the
            // current element we are using at the start of the permutation has already been used or not
            // so basically freq is like a flag array
            if(!freq[i])
            {
                freq[i] = true;
                ds.add(nums[i]);
                permuteutil(nums, ds, ans, freq);
                // After our recursion when we get a full sized permutation we then
                // remove the element again and go back in the tree to create a new
                // permutation. This is very much like backtracking ain't it?
                ds.remove(ds.size()-1);
                // We then once again set the frequencey of the current variables as false since we need it for the 
                // other permutations
                freq[i] = false; 

            }
        }
    }

    // Approach 2 using swapping algorithm
    private static void permuteUtilsII(int ind, int[] nums, List<List<Integer>> ans)
    {
        // First of all we define our base case
        if(ind == nums.length)
        {
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }

        for(int i = ind; i<nums.length; i++)
        {
            swap(nums, ind, i);
            permuteUtilsII(ind+1, nums, ans);
            swap(nums, ind, i);
        }
    }

    private static void swap(int[] nums, int i , int j)
    { 
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }



    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        ArrayList<Integer> ds = new ArrayList<>();
        permuteutil(nums, ds, ans, freq);
        return ans;

    }     
}
