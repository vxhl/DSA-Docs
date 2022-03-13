package DSA450Restart.Arrays;
import java.util.*;
public class MaxProductSubarray {
    
    public static long maxProduct(int[] arr, int n)
    {
        long max = arr[0];
        long min = arr[0];
        long res = arr[0];

        for(int i=1; i<n; i++)
        {
            if(arr[i] == 0)
            {
                min = 1;
                max = 1;
            }
            long p1 = max*arr[i];
            long p2 = min*arr[i];
            
            max = Math.max(arr[i], Math.max(p1, p2));
            min = Math.min(arr[i], Math.min(p1, p2));
            res = Math.max(res, max);

        }
        return res;
    }



    public static void main(String[] args) {
        int[] arr = {8,-2,-2,0,8,0,-6,-8,-6,-1};
        int[] arr1 = { -8, 5,7,9,10};
        System.out.println(maxProduct(arr, arr.length));
    }
}
