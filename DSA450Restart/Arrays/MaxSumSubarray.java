package DSA450Restart.Arrays;

public class MaxSumSubarray {
    static int mss(int[] arr)
    {
        int max = 0;
        int curr = 0;

        for(int i=0; i<arr.length; i++)
        {
            // We just increment our current element
            curr += arr[i];

            // As we add on every iteration we check if it is greater than max and update it
            if(curr>max)
            {
                max = curr;
            }

            // Now why this? -> 
            if(curr<0)
            {
                curr = 0;
            }
        }
        return max;
    }
}
