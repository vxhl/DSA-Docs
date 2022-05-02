/*
Problem Statement:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
*/

package Recurssion;
import java.util.*;
// Ofc this is similar to the previous one but here we have to print in a different way
// Do I need a helper function for this then?
public class CombinationSum 
{

        
            private static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds)
            {
                if(ind == arr.length) 
                {
                    if(target == 0)
                    {
                        ans.add(new ArrayList<>(ds));
                    }
                    return;
                }
                if(arr[ind] <= target)
                {
                    ds.add(arr[ind]);
                    findCombination(ind, arr, target - arr[ind], ans, ds);
                    ds.remove(ds.size() - 1);
                }
                findCombination(ind+1, arr, target, ans, ds);
            }
            
            public static List<List<Integer>> combinationSum(int[] candidates, int target) {
                List<List<Integer>> ans = new ArrayList<>();
                findCombination(0, candidates, target, ans, new ArrayList<>());
                return ans;
            }

        public static void main(String[] args) {
            int[] candidates = {2,3,5};
            int target = 8;
            combinationSum(candidates, target);

        }
}
