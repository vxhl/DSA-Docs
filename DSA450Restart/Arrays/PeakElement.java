package DSA450Restart.Arrays;

class Solution {
    // Ok so we need to do it in O(log N) time
    // So what? Do we just find the maximum element using binary search or something? 
    // Well that is possible, but Binary search should only be implemented on a sorted array and what we have
    // here is not a sorted array, so how can it work? 
    // 
    public int findPeakElement(int[] arr) {
        // This may be possible using binary search, I mean that's what's given but I do not know how this is possible
        // using binary search
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(mid<1)
            {
               if(arr[mid]>arr[high])
               {
                   return mid;
               }
                else
                {
                    return high;
                }
            }
            if(low==high)
            {
                return high;
            }
          
            // We are not searching for anything we just know that we need the peak, so this time
            // instead of checking for a specific element we check on the two sides of mid
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
            {
                return mid; // We just return the mid as our peak
            }
            
            // case 2: 
            else if(arr[mid]<arr[mid-1])
            {
                high = mid-1;
            }
            else if(arr[mid]<arr[mid+1])
            {
                low = mid+1;
            }
        }
        return -1;
        
    }
}