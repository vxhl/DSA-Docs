/*
Problem Statement - 
nums that may contain duplicates
return all possible subsets meaning the powerset 
The solution subset must not contains duplicate subsets
return the solution in any order we can

Example 1: 
I/P - nums = [1,2,2]
O/P - [[],[1],[1,2],[1,2,2],[2],[2,2]]
*/

package Recurssion;
import java.util.*;
public class SubsetsII {
    // So should we use the the hashset method to negate the duplicates? 
    private static void subsetSumsUtilII(int ind,ArrayList<Integer> ans, ArrayList<Integer> ds, ArrayList<Integer> arr)
    {   
        // So we define the base case first
        // As long as our index is not the last element
        ans.add(ds);
        
        ds.add(arr.get(ind));
        subsetSumsUtilII(ind+1, ans, ds, arr);
        ds.remove(ds.size()-1);
    }


    ArrayList<Integer> subsetSumsII(ArrayList<Integer> arr, int N)
    {
        // Wait that's weird. Why return an ArrayList
        N = arr.size();
        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSumsUtil(0, ans, ds, arr);
        return ans;

    }

}
