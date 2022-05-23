package DSA450Restart.SearchingSorting;
import java.util.*;
class Solutions_MergeNoExtraSpace
{
    // This takes n*O(mlogm) time since we are sorting n times the array of length m
    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i = 0;
        int j = 0;
        
        // if(arr1[0]<arr2[0])
        // {
        //     int[] tmp = arr1;
        //     arr1 = arr2;
        //     arr2 = tmp;
        // }
        
        while(i!=arr1.length)
        {
            if(arr1[i]>arr2[j])
            {
        	    int temp = arr1[i];
        	    arr1[i] = arr2[j];
        	    arr2[j] = temp;
        	    Arrays.sort(arr2);
            }	
        i++;
        }
    }

    // This takes O(m*n) time in the worst case, and the worst case is only possible if all the elements from the first array other than the last one
    // are greater than the last element of the 2nd array, this means we will be moving to the first element of the n length array every time we move our 
    // pointer for mth node forward. So for every element of 2nd array we will be moving the entire n length of our 1st array
    public void merge2(int arr1[], int arr2[], int n, int m) {
        
        
        for(int i=arr2.length-1; i>=0; i--)
        {
            
            int last = arr1[n-1];
            int j = 0;
            for(j=n-2; j>=0 && arr1[j]>arr2[i]; j--)
            {
                arr1[j+1] = arr1[j];
            }
            
            if(j!=n-2 || last>arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
        
    }


    // THe gap method in O(M+N) time, no extra space
    // This will most likely be not asked in interviews since this is more of a pre existing problem,
    // so not too important.
    private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
    public void merge3(int arr1[], int arr2[], int n, int m) {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            // comparing elements in the first
            // array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
 
            // comparing elements in both arrays.
            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
 
            if (j < m)
            {
                // comparing elements in the
                // second array.
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap])
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }


}
