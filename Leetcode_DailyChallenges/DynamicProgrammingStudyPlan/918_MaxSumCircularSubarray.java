class Solution {
    // O(N*N) Kadane's Algorithm

    public int maxSubarraySumCircular_2(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max = Integer.MIN_VALUE;
        int curr=0;
        for(int i=0; i<n; i++){
            int stop = i;
            int k = (stop+1)%n;
            curr = nums[i];
            while(k!=stop){
                curr+=nums[k];
                max = Math.max(curr,max);
                if(curr<0){
                    curr = 0;   
                }
                k = (k+1)%n;
                
            }
        }
        return max;
    }

    // O(N) Single pass
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curr_maxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int curr_minSum = 0;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            curr_maxSum+=nums[i];
            maxSum = Math.max(maxSum, curr_maxSum);
            if(curr_maxSum<0){
                curr_maxSum=0;
            }
            curr_minSum += nums[i];
            minSum = Math.min(minSum, curr_minSum);
            if(curr_minSum>0){
                curr_minSum = 0;
            }
            sum+=nums[i];
        }
        if(sum==minSum){
            return maxSum;
        }
        return Math.max(maxSum, (sum-minSum)); 
    }
}public class 918_MaxSumCircularSubarray {
    
}
