/*
Porblem Statment:
Maximum Sum subarray so the Kadane's algorithm problem idk. 

Example 1:  - 

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
*/

package Striver_SDESHEET.Day1;
import java.util.*;
public class maxSubarray {
    // Approach 1:
    //  Well we just take the sum for every subarray from every index and
    // update the value everytime we get a larger value than the current. 
    // But goddamn this seems to take like a huge ass time but let's try it

    public static int kadane(int[] arr)
    {
        int max = 0;
        int curr = 0;
        // First we define our edge cases
        if(arr.length == 1) return 1;
        if(arr.length == 0) return 0;

        // We traverse our array from 0 - N-1
        for(int i=0; i<arr.length; i++)
        {
                curr += arr[i];
                if(curr>max) max = curr;
                
 
            if(curr<0)
            curr = 0;
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(kadane(nums1));
    }
}
