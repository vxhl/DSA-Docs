package DSA450Restart.Arrays;

public class nextPermutations {
    public void nextPermutation(int[] nums) 
    {
         // Edge Case: If our nums is null or there is only one element to be permuted we just return nothing
        if(nums== null || nums.length <= 1)
        {
            return;
        }

        // We traverse from the last 2nd element 
        int i = nums.length - 2;
        
        // We now run the loop for as long as we do not find a position where the left element is smaller than the right element. We are basically trying to find the breakpoint here. 
        
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        // Now that we have found the breakpoint we now start traversing inorder to find the element that is greater than the element at our current i
       // And we ofc only do this if the position where we found the element at exists 
        if(i>=0)
        {
            // Unlike for the previous traversal here we traverse from the rightmost element in the array
            int j = nums.length-1;
            // Once again we decrement our index as long as we do not find the element that is greater than our element at the ith position 
            while(nums[j] <= nums[i]) j--; 
            // Now once we do find the position we swap the two element at i and j respectively
            swapping(nums, i, j);
        }
        // After we are done with these steps inorder to get the lexicographical sequence next to our nums
        // we reverse the array from the right side of the element that we just swapped 
        reverse(nums, i+1, nums.length-1);
           
    }
    
    
    private static void swapping(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void reverse(int[] nums, int i, int j)
    {
        while(i<=j) swapping(nums, i++, j--);
    }
}
