package Recurssion;

import java.util.*;

public class CombinationSumII
{
    private static void findCombinationII(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds)
            {
               if(target == 0)
               {
                   // When our target is 0 we add our data structure to the target
                   ans.add(ds);
                   return;
               }
               for(int i=ind; i<arr.length; i++)
               {
                   if(i>ind && arr[i] == arr[i-1]) continue;
                   if(arr[i]>target) break;
                   ds.add(arr[i]);
                   findCombinationII(i+1, arr, target-arr[i], ans, ds);
                   ds.remove(ds.size()-1);    
                }
            }
            
            public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
                List<List<Integer>> ans = new ArrayList<>();
                Arrays.sort(candidates); // since we need them in lexicographical order
                findCombinationII(0, candidates, target, ans, new ArrayList<>());
                return ans;
            }
     

}