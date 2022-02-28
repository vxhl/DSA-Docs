package DSA450Restart.Arrays;

public class CountInversions {

    // Lmao. I thought I optimised or something
    // Well I got the answer but it was way too slow.
    public static int countInv(int[] arr)
    {
        int ptr1 = 0;
        int n = arr.length;
        int ptr2 = n-1;
        int count = 0;
        while(ptr1!=arr.length-1)
        {
            // If our right element is smaller than the left element
            if(arr[ptr2]<arr[ptr1])
            {
                // We then increment our count
                count++;
                // And we decrement our ptr2 either way
                ptr2--;

                // If at any point our ptr2 comes to be equal to ptr1 
                
            }

            else if(arr[ptr2]>arr[ptr1])
            {
                ptr2--;
            }

            if(ptr2 == ptr1)
            {
                ptr2 = n-1;
                ptr1++;
            }
        }
        return count;
    }


    // Optimal Approach using O(NlogN) merge sort

    public static int merge(int[] arr, int temp[], int left, int mid, int right)
    {
        // We assign i and j as pointer for the left and right array

        int i=0, j=0, k = 0;
        // We also count the number of inversions during our merging step
        int invCount = 0;

        // We traverse till we reach the end of the left and right arrays respectively
        while((i<=mid-1) && (j<=right))
        {
            // If we find our 
            if(arr[i]<=arr[j])
            {
                // If the left element is smaller we don't increment inversion count
                // and just copy it into our temporary array for the sorted
                temp[k++] = arr[i++];   
            }
            else
            {
                temp[k++] = arr[j++];
                // We add the count of elements to the right of the mid
                invCount += (mid-i);
            }
        }

        while(i<=mid-1)
        {
            temp[k++] = arr[i++];
        }
        while(j<=right)
        {
            temp[k++] = arr[j++];
        }

        for(i=left; i<=right; i++)
        {
            arr[i] = temp[i];
        }

        return invCount;
    }


    public static int mergeSortInvCount(int[] arr, int left, int right, int temp[])
    {
        int mid, invCount = 0;
        // Our condition is that whenever the greater element comes from the
        // right hand side of the recursion tree then it means we have an inverted pair
        if(right>left)   
        {
            mid = (right+left)/2;
            // What are we using the temp for then?
            invCount += mergeSortInvCount(arr, left, mid-1, temp);
            invCount += mergeSortInvCount(arr, mid, right, temp);

            invCount+= merge(arr, temp, left, mid+1, right);
        }

        return invCount;
    }


    

    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        int[] arr1 ={2,3,4,5,6};
        int[] arr2 = {4,6,3,2,1};
    }
}
