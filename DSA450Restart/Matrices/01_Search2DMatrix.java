package DSA450Restart.Matrices;

class Solution
{
    public static boolean findRow(int[][] arr, int n, int m, int k)
    {
        int l = 0;
        int r = n-1;
        int mid = 0;

        while(l<=r)
        {
            mid = (l+r)/2;

            // We need to check the left and right most element of the row
            // so we can find whether k falls within the range

            if(k==arr[mid][0])
            {
                return true;
            }
            if(k==arr[mid][m-1])
            {
                return true;
            }

            if(k>arr[mid][0] && k<arr[mid][m-1])
            {
                // This obviously means that our target is int the range
                // so we do our binary search in this array
                return binarySearch(arr, n, m, k, mid);
            }
            // If not in range we either go down or go up the rows

            if(k<arr[mid][0])
            {
                r = mid-1;
            }
            if(k>arr[mid][m-1])
            {
                l = mid+1;
            }

        }
        return false;
    }
    public static boolean binarySearch(int[][] arr, int n, int m, int target, int targetrow)
    {
        int l = 0;
        int r = m-1;   
        int mid = 0;

        while(l<=r)
        {
            mid = (l+r)/2;

            if(arr[targetrow][mid] == target)
            {
                return true;
            }

            if(arr[targetrow][mid] > target)
            {
                r = mid-1;
            }

            if(arr[targetrow][mid]<target)
            {
                l = mid+1;
            }
        }
        return false;
    }

    public static boolean Search2DMatrix(int[][] arr, int target)
    {
        int n = arr.length;
        int m = arr[0].length;
        return findRow(arr, n, m, target);
    }
}