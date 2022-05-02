/*
Problem Statemnet:
Looks like this is a hard problem. Let's start with this and then do the easier
problems after like atleast 2 of the hard ones. 

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

package Recurssion;
import java.util.*;
public class KthPermutationSequence {
    // Well we know how to get the permutation
    // We need to find the kth permutation sequence for this one
    

    // Approach 1: Naive Solution using recursion
    private static void getPermutationUtil(int ind, int[] arr, int n, List<Integer> ds, List<List<Integer>>ans)
    {
        // Base Case? 
        // We stop when we find the sequnce in the kth position
        
        if(ind == n)
        {
            for(int i = 0; i<n; i++)
            {
                ds.add(arr[i]);
            }
        }
        ans.add(new ArrayList<>(ds));

        for(int i = ind; i<=n; i++)
        {
            swap(arr, ind, i);
            getPermutationUtil(ind+1, arr, n, ds, ans);
            swap(arr, ind, i);
        }
    }

    private static void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public String getPermutation(int n, int k)
    {
        int[] nums = new int[n];
        for(int i = 0; i<=n; i++)
        {
            int j = 1;
            nums[i] = j;
            j++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        getPermutationUtil(0, nums, n, ds, ans);
        String res = ans.get(k-1).toString();
        return res;
    } 

    
    // Approach 2: Faster Hard Approach 
    String getPermutationII(int n, int k)
    {   
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<n; i++)
        {
            // We compute the total number of permutations
            fact = fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        // SO all numbers from 1->n have been stored. 
        String ans = ""; // We initialised a string as empty
        // We reduce k to 0 based indexing
        k = k-1;
        while(true)
        {
            // This is the first number of our permutation.
            // And we then attach it to our answer
            ans = ans + numbers.get(k/fact);
            // We also remove the number we added from our numbers array
            numbers.remove(k/fact);
            // We keep running this unless our list is empty
            if(numbers.size() == 0)
            {
                break;
            }
            // We then do the modulo to get the next value of k which is the remaining amount.
            k = k%fact;
            // We also divide our factorial to reduce our factorial at every step.  
            fact = fact/numbers.size(); 

        }
        return ans;

    }
}
