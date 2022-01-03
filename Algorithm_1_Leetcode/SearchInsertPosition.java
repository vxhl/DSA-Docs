/*
Problem Statement:
Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1
*/
package Algorithm_1_Leetcode;

public class SearchInsertPosition {
    

    // Linear Search Approach
    static int searchInsertLinear(int[] nums, int target)
    {
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] >= target) // Well this is smart ain't it. 
            {
                return i;
            }
        }
        return n;
    }
    // Binary Search Approach
    static int searchInsertPosition1(int[] nums, int target)
    {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int ans = -1;

        while(l<=r)
        {
            mid = l + (r-l) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]<target)
            {
                l = mid+1;
                ans = mid + 1;
            }
            else
            {
                ans = mid;
                r = mid-1;
            }
            }
            return ans;
    }

    
    public static void main(String[] args) {
        int[] nums = {7,6,4,8,10};
        int target1 = 2;
        int target2 = 11;
        System.out.println(searchInsertPosition1(nums, target2));
    }
}
