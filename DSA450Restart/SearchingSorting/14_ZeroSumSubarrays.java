import java.util.*;
class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
       // Our hashmap basically holds the amount of times a particular sum occurs
       // If any sum occurs more than 1 time than that means we have atleast one
       // zero sum subarray, cause one sum cannot occur more than one time unless it is reduced
       // by some equivalent range of negative numbers
       
       // the basic intuition here is that, if we find the sum already in the map
       // we increment the count by the value of that sum's occurence and then increment sum
       // in the map by 1 as well to keep track of the 0 sum subarray
       
       Map<Long, Integer> mp = new HashMap<>();
       // We start by putting in 0 -> 1 in the map
       // Since we are looking for zero sum subarrays, all elements that are 0 can be considered
       // as a subarray as well, so inorder to keep track of the first extra 0 we add +1 to the result
       
       long count = 0;
       mp.put(count,1);
       long sum = 0;
       for(int i=0; i<n; i++)
       {
           sum+=arr[i];
           
           if(mp.containsKey(sum))
           {
               count+=mp.get(sum);
               mp.put(sum, mp.get(sum)+1);
           }
           else
           {
               mp.put(sum, 1);
           }
       }
       
       return count;
       
    }
    
    
    
}