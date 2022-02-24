/*

*/

package DSA450Restart.Arrays;
import java.util.*;
public class MinimiseHeightII {
    
    
    public static int mhII(int[] arr, int k)
    {
        // First we find the min and max element
        int min = arr[0];
        int max1 = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>max1)
            {
                max1 = arr[i];
            }
            if(arr[i]<min && arr[i]<max1)
            {
                min  = arr[i];
            }
        }

        return Math.max((max1-k)-(min+k), (max1+k)-(min-k));

    }

    // A better approach

    public static int minimiseheight(int[] arr, int key)
    {
        // We first sort our array so we can easily find our smaller and bigger elements

        Arrays.sort(arr);
        
        // We first initialise our min and max values with the key operations
        int smallest = arr[0] + key;
        int largest = arr[arr.length-1] - key;
        // we also initialise our answer
        int ans = Math.abs(arr[arr.length-1] - arr[0]);
        int mi = 0;
        int ma = 0;

        // Now that we have the initial values we
        // traverse our array to find whether the samllest and largest can be updated

        for(int i=0; i<arr.length-1; i++)
        {
            mi = Math.min(smallest, arr[i+1]-key);
            ma = Math.max(largest, arr[i]+key);
            // If our values get updated our ans gets updated as well
            // We continue and don't update answer
            // when our mi becomes negative since we need non negative heights
            if(mi<0) continue;
            ans = Math.min(ans, Math.abs(ma-mi));
        }
        return ans;


    }
   
    public static void main(String[] args) {
        int[] arr = {1,5,8,10};
        System.out.println(minimiseheight(arr, 2));
        
    }
}
