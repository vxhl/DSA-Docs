package DSA450Restart.Arrays;

class Solution {
    
    static int findKRotation(int arr[], int n) {
        // code here
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            // We are not searching for anything we just know that we need the peak, so this time
            // instead of checking for a specific element we check on the two sides of mid
            
            if(arr[low] <= arr[high]) return low;
            if(arr[mid]<=arr[(mid+1)%arr.length] && arr[mid]<=arr[(mid+arr.length-1)%arr.length])
            {
                return mid; // We just return the mid as our peak
            }
            
            // case 2: 
            else if(arr[low]<=arr[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }            
        }
        return 0;
    }  
    
    // Now we implement two more binary searches on two arrays
    // let's define a binary search first
    public static int binarysearch(int[] arr,int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
    
    public int search(int[] arr, int target) {
        int n = arr.length;
        int split = findKRotation(arr, n);
        int p1 = binarysearch(arr, target, 0, split-1);
        int p2 = binarysearch(arr, target, split, arr.length-1);
        
        if(p1>=0) return p1;
        else return p2;
    }
}
