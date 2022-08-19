import java.util.*;
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> nextSubsequence = new HashMap<>();
        for(int i: nums) freq.put(i, freq.getOrDefault(i,0)+1);
        for(int i:nums){
            if(freq.get(i)==0) continue;
            
            else if(nextSubsequence.getOrDefault(i,0)>0){
                nextSubsequence.put(i, nextSubsequence.get(i)-1);
                nextSubsequence.put(i+1,nextSubsequence.getOrDefault(i+1,0)+1);
            }
            // if the next two elements needed for the subsequence to be valid are in the hashmap
            else if(freq.getOrDefault(i+1,0)>0 && freq.getOrDefault(i+2,0)>0){
                // We reduce the frequency of these elements since we have used them up
                freq.put(i+1,freq.get(i+1)-1);
                freq.put(i+2,freq.get(i+2)-1);
                // And we append for the next subsequence we need to start from which is i+3
                nextSubsequence.put(i+3, nextSubsequence.getOrDefault(i+3, 0)+1);
            }
            // If none of the conditions are true we return false
            else { return false;}
            
            freq.put(i, freq.get(i)-1);
        }
        
        return true;
    }
}