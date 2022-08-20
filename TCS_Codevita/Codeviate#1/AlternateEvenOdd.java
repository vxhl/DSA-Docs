class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] out = new int [nums.length];
        // J is for the positive elements
        int j = 0;
        // K is for the negative elements
        int k = 1;
        
        for(int i=0;i<nums.length;i++){
            // If the element is positive
            if(nums[i] >= 0){
                // We assign at jth index
                out[j] = nums[i];
                // And increase by 2 for the postiive
                j += 2;
            }else {
                // If negative put at kth index
                out[k] = nums[i];
                // Increment the kth index by 2
                k += 2;
            }
        }
        return out;
    }
}