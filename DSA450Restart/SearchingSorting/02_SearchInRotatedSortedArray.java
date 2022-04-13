package DSA450Restart.SearchingSorting;

class Sol_SearchInRotatedSortedArray {


    static int findtheSplit(int[] arr)
    {
        int low = 0;
        int high = arr.length-1;
        int n = arr.length;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            // 4 5 6 7 0 1 2
            // This condition is basically for when our arr has no rotations at all, 
            // in which case we simply return low
            if(arr[low] <= arr[high]) return low;

            // Ok so we are not finding our peak but instead finding the hole or whatever 
            if(arr[mid]<=arr[(mid+1)%n] && arr[mid] <= arr[(mid+n-1)%n])
            {
                return mid;
            }

            if(arr[low]<=arr[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        return low;
    }



    static int binarysearch(int arr[], int low, int high, int target) {
    
        // Welp binary search vibe chec
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] > target)
            {
                high = mid-1;
            } 
            else 
            {
                low = mid+1;
            }

        }
        return -1;    
    }


    public static int search(int[] arr, int target)
    {
        int split = findtheSplit(arr);
        int s1 = binarysearch(arr, 0, split-1, target);
        int s2 = binarysearch(arr, split, arr.length-1, target);
        if(s1>=0) return s1;
        else return s2;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.print(search(arr, target));

    }
}
