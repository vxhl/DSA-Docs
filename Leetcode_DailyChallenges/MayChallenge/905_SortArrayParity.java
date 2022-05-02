package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
 class SortArrayParity {

    // Constant space N time appraoch
    public int[] sparity(int[] nums)
    {
        // Our condition is that
        // All elements to the left of i should have a parity of 0
        // and a parity of 1 on the right of j
        int i = 0;
        int j = nums.length-1;

        while(i<j)
        {
            // Incorrect then we swap the elements at the i and jth position
            if(nums[i]%2 > nums[j]%2)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            // If we have the correct parity in our ith position we move forward
            if(nums[i] % 2 ==0) i++;
            if(nums[j]%2 == 1) j--;
        }

        return nums;
    }



    // Extra space N time appraoch
    public int[] sortArrayByParity1(int[] nums) {
        ArrayList<Integer> even  = new ArrayList<>();
        ArrayList<Integer> odd  = new ArrayList<>();
        
        for(int i: nums)
        {
            if(i%2==0)
            {
                even.add(i);
            }
            else
            {
                odd.add(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<even.size(); i++)
        {
            res.add(even.get(i));
        }
        
        for(int j=0; j<odd.size(); j++)
        {
            res.add(odd.get(j));
        }
        
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = res.get(i);
        }
        return nums;
        
        
        
    }


    // IN place rotating constant space N^2 time appraoch
    public static void rotate(int[] nums, int first, int last)
    {
        int temp = nums[last];
        
        for(int i=last; i>first; i--)
        {
            nums[i] = nums[i-1];
        }
        nums[first] = temp;
        
    }        

    public int[] sortArrayByParity(int[] nums) {
        int ptr1 = 0;
        int ptr2 = ptr1+1;
        
        while(ptr1<nums.length-1 && ptr2<nums.length)
        {
            if(nums[ptr1]%2!=0)
            {
                while(nums[ptr2]%2!=0 && ptr2<nums.length-1)
                {
                    ptr2++;
                }
                if(nums[ptr2]%2==0) { 
                    rotate(nums, ptr1, ptr2);
                    ptr1++;
                }
                else
                {
                    break;
                }
            }
            else
            {
                ptr1++;
                ptr2++;
            }
        }
        
        return nums;
    }
}
