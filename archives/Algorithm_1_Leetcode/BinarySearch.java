/*
Problem Statement:
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
*/

package Algorithm_1_Leetcode;

public class BinarySearch {
    static int binarysearch1(int[] nums, int target)
    {
       for(int i=0; i<nums.length; i++)
       {
           if(nums[i]==target)
           {
               return i;
           }
       }
       return -1;
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(binarysearch1(nums, target));
    }
}
