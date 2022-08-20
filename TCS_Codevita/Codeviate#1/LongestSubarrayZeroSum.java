import java.util.*;
public class LongestSubarrayZeroSum {
    // Ofc there is the obvious O(N^2) approach for this
    // The O(N) approach with extra space of O(N) uses a HashMap
    
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer, Integer> mp = new HashMap<>();
        int maxi = 0;
        int curr = 0;
        for(int i=0; i<n; i++){
            curr+=arr[i];
            if(curr==0){
                maxi = i+1;
            }else{
                if(mp.containsKey(curr)){
                    // If we already had the current sum in the map, that means we found another 
                    // subarray of length 0
                    // The length of this subarray would be currSumIndex-IndexOfPreviousFoundIndex => 5-3 = 2 would be the length
                    maxi = Math.max(maxi, i-mp.get(curr));
                }else{
                    // Otherwise we just put the current sum into the map with the current index
                    mp.put(curr,i);
                }
            }
        }
        return maxi;
        
    }
}
