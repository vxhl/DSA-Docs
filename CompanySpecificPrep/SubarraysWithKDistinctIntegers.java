class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Math.abs(atmost(nums, k)-atmost(nums,k-1));
    }
    
    private int atmost(int[]nums, int k)
    {
        int start = 0;
        int end = 0;
        int count = 0;
        // We are gonna do a sliding windows for the atmost conditions
        Map<Integer, Integer> mp = new HashMap<>();
        while(end<nums.length)
        {
            mp.put(nums[end], mp.getOrDefault(nums[end],0)+1);
            // If the size of our map exceeds the threshold we remove the element from the map or decrease it
            // freq
            while(mp.size()>k)
            {
                mp.put(nums[start], mp.get(nums[start])-1);
                if(mp.get(nums[start])==0) mp.remove(nums[start]);
                start++;
            }
            count+= start+end-1; // We add the current length of the valid subarray that we added into the map
            end++;
            
        }
        return count;
    }
}