package DSA450Restart.Arrays;

public class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] arr) {
        /*
        Ok let us talk about the logic first.
        We first set our minimum value as Integer.MAX_VALUE since we ofc need the minimum
        */
         int res = Integer.MAX_VALUE;
         // We have a left pointer and what this pointer does is it keeps on reducing the
         // elements from the back of the subarray and check for whether the sum of the subarray
         // is still >= the target that we need
         // As we keep decrementing values from the back we get a smaller and smaller subarray 
         // but at the same time we store the result as well. 
         int left = 0;
         int sum = 0;
         
         for(int i=0; i<arr.length; i++)
         {
             // We add to our result
             sum+=arr[i];
             
             // now we start another loop 
             // Whenever sum is greater than or equal to our target we compute our result
             while(sum>=target)
             {
                 /*
                 On subtracting left from the current index we ofc get the number of elements that we have
                 traversed till now. We give +1 to match the 0-based indexing. 
                 */
                 res = Math.min(res, i-left +1); 
                 sum -= arr[left];
                 // We are incrementing left since we need to delete the reference to the element that we just
                 // deleted. So on incrementing we also simultaneously reduce the size of the subarray
                 left++;
             }
             
         }
         
         return res!=Integer.MAX_VALUE ? res : 0;
         
         
         
     }
}
