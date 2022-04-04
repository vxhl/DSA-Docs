package DSA450Restart.Arrays;

public class CountElementSortedArray {
    // We are given a sorted array we are to find the number of occurences of
    // an element x in that array

    // arr = {1,1,2,2,2,2,3}
    // k = 2
    // output => 4
    
    /*
    Ok how is this possible using binary search
    1 1 2 2 2 2 3
    I think we do 2 binary searches on both sides of the array
    while doing so we count occurences of k

    Wow that was amazing, exactly like the previous one we did for first and last occurence but what we return is
    the lastindex-firstindex+1 that's it and look out for the edge cases

    */


    public static int countOccurences(int[] arr, int k)
    {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int first = -1;
        int last = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(arr[mid] == k)
            {
                last = mid;
                start = mid+1;
            }

            else if(arr[mid]<k)
            {
                start = mid+1;
            }
            else if(arr[mid]>k)
            {
                end = mid-1;
            }
        }

        start = 0;
        end = arr.length-1;
        
        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(arr[mid] == k)
            {
                first = mid;
                end = mid-1;
            }

            else if(arr[mid]<k)
            {
                start = mid+1;
            }
            else if(arr[mid]>k)
            {
                end = mid-1;
            }
        }

        return last-first+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,4};
        int k = 2;
        System.out.print(countOccurences(arr, k));
    }





}
