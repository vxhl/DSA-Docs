public class Solution {
    public int maxProduct(int[] nums) {
        // There is an overflow problem with this solution since we are multiplying in a more general case where nums[i]<=10^5
        // So while Kadane's might work for this, it won't for other cases.
        
        // Let's look at the recurrence relation here?
        int left = 0;
        int right = nums.length-1;
        int ans = Integer.MIN_VALUE;
        int leftVal = 1;
        int rightVal = 1;
        while(left<=nums.length-1 && right>=0){
            leftVal = leftVal==0?1:leftVal;
            rightVal = rightVal==0?1:rightVal;
            leftVal*=nums[left];
            rightVal*=nums[right];
            ans = Math.max(ans, Math.max(leftVal, rightVal));
            left++;
            right--;
        }
        
        return ans;
    }
    
}
