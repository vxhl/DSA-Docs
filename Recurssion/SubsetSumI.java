/*
Problem Statement: 
Given a list arr of N integers, print sums of all subsets in it

Example: 
I/P - N = 2, arr = {2,3}
O/P - 0 2 3 5
*/

package Recurssion;
import java.util.*;
public class SubsetSumI {
    // Maybe we somehow combine the problems of printsubsequences and subsequencessum together to get the answer here let's see
    private static void subsetSumsUtil(int ind,ArrayList<Integer> ans, ArrayList<Integer> ds, ArrayList<Integer> arr)
    {   
        // So we define the base case first
        // As long as our index is not the last element
        int n = arr.size();
        if(ind == n)
        {
            int sum = 0;
            for(int x: ds)
            {
                sum += x; // this should do it
            }
            ans.add(sum);
            if(ds.size() == 0) System.out.print(0);
            return;
        }
        subsetSumsUtil(ind+1, ans, ds, arr);
        ds.add(arr.get(ind));
        subsetSumsUtil(ind+1, ans, ds, arr);
        ds.remove(ds.size()-1);
    }


    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N)
    {
        // Wait that's weird. Why return an ArrayList
        N = arr.size();
        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSumsUtil(0, ans, ds, arr);
        return ans;

    }

}
