package DSA450Restart.Matrices;

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max = 0;
        int row = 0;
        for(int i=0; i<n; i++)
        {
            int count = binarySearch(arr, i);
            if(count>max)
            {
                max = count;
                row = i;
            }
        }
        if(max == 0) return -1;
        return row;
        
    }
    
    public static int binarySearch(int [][] arr, int i)
    {
        int low = 0;
        int high = arr[0].length-1;
        // We are setting this as m since we need the condition for 
        // when our array does not have any 1s at all
        int firstIndex1 = arr[0].length;
        int c1 = 0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            // We are checking in the current row for i and we are comparing the mid
            if(arr[i][mid] == 1) 
            {
                firstIndex1 = mid;
                high = mid-1;
                c1 = arr[0].length-firstIndex1;
                
            }
            else
            {
                low = mid+1;
            }
            
        }
        
        return c1;
    }
}