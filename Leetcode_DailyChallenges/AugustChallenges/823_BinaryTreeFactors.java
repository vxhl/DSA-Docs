import java.util.*;
class Solution{
    public int binaryTreeFactors(int[] nums){
        Map<Integer, Long> mp = new HashMap<>();
        mp.put(nums[0],1);
        long count=1;

        for(int i=1; i<nums.length; i++){
            count=1;
            for(Integer it: mp.keySet()){
                if(A[i]%it==0 && mp.containskey(A[i]/it)){
                    count+=(mp.get(it)*mp.get(A[i]/t));
                }
            }
            mp.put(nums[i], count);
        }
        long ans = 0;
        for(Integer i: mp.keySet()){
            ans = (ans+mp.get(i))%(Math.pow(10,9)+7);
        }

        return (int)ans;

    }
}