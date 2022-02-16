/*
Problem Statement:
Given an array `nums` with n objects colored red, white or blue. 

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
*/

package Striver_SDESHEET.Day1;

public class SortColor75 {
    // Ok so what about this is medium
    // Well tbf i don't really know any sorting algorithms very well lel
    // We need to inplace sort this as well
    
    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }

    public static int[] sortcolor(int[] arr)
    {
        int i = 0;
        int j = arr.length-1;

        while(i<=j)
        {
            if((arr[i] == 1 || arr[i] == 2) && arr[j] == 0)
            {
                swap(arr, i,j);
            }
            if(arr[i] == 2 && arr[j] == 1)
            {
                swap(arr, i, j);
            }
            i++;
            j--;
        }
        printarr(arr);
        return arr;
    }

    // Approach 2: Dutch National Flag Algorithm
    // Goddamn I love doing DSA sometimes when it just clicks
    // TC - 0(1) SC - O(1)
    public static int[] sortColors(int[] arr)
    {
        int temp = 0;
        int mid = 0;
        int low = 0;
        int high = arr.length-1;
        while(mid<=high )
        {
            switch(arr[mid]) {
                case 0:
                {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:
                {
                    mid++;
                    break;
                    
                }
                case 2:
                {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
            
                
        }
        return arr;
    }
    private static void printarr(int[] nums)
    {
        for(int i: nums)
        {
            System.out.print(nums + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i: nums)
        {
            System.out.print(i + " ");
        }

    }



}
