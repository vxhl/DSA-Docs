package DSA450Restart.Matrices;

class Solution {

    public static int medianRowWise(int[][] arr)
    {
        // We take the minimum and max value for our low and high since we do
        // not know whether the elements can be negative or positive in our array
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        
        // Now we look at our given array
        // And get the respective lengths of our rows and cols
        int n = arr.length;
        int m = arr[0].length;
        while(low<=high)
        {
            int mid = (low + high)/2;
            // We also have a count value that counts our number of elements that
            // are smaller than the mid of our range
            // as we keep reducing and reach a valye that isl lower than our mid of our
            // given array we then start increaseing the low pointer for our array
            // Otherwise we keep decreasing high by doing high = mid-1 like in standard binary search
            int count = 0; 

            for(int i=0; i<n; i++)
            {
                // We do a nested binary search helper function that
                // simply searches in the given array with the given mid from the
                // larger mid
                count += countSmallerThanMid(arr[i], mid);
            }

            if(count<=(n*m)/2) low = mid+1;
            else high = mid-1;

        }

        // In the end our median rests in our low value
        return low;

    }

    public static int countSmallerThanMid(int[] row, int mid)
    {
        int low = 0;
        int high = row.length-1;
        while(low<=high)
        {
            int m = (low+high)/2;
            if(row[m] <= mid)
            {
                low = m +1;
            }
            else
            {
                high = m-1;
            }
        }
        return low;

    }
}
