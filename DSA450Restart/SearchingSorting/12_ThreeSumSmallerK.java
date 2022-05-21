package DSA450Restart.SearchingSorting;
import java.util.*;
class Solution_ThreeSumSmallerK
{
    long countTriplets(long arr[], int n,int target)
    {
        // Same as 3 sum probably
        
        long ans = 0;
        Arrays.sort(arr);
        for(int i=0; i<n-2; i++)
        {
            int low = i+1;
            int high = n-1;
            
            while(low<high)
            {
                if(arr[i]+arr[low]+arr[high] >= target)
                {
                    high--;
                }
                // else if(arr[i]+arr[low]+arr[high]<target)
                else
                {
                    ans += high-low;
                    low++;
                }
            }
        }
        return ans;
    }
}
