package Arrays.SlidingWindowsProblems;

public class MaxSumSubarraySizeK {
    
    public static int mssk(int[] arr, int k)
    {
        // Ok so how does sliding windows work
        // We have a window that has it's left as 0 initially and
        // it's right as k-1
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (right<arr.length)
        {
            
            sum += arr[right];

            if(k==right-left+1)
            {
                max = Math.max(max, sum);
                sum -= arr[left];
                left++;
                right++;
            }
            else
            {
                right++;   
            }
        }
        return max;
    }

    
    public static void main(String[] args) {
        int[] arr = {2,5,1,8,2,9,1};
        int k = 3;
        System.out.println(mssk(arr, k));
    }
}
