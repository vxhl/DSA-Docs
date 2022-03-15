package DSA450Restart.Arrays;
import java.util.*;
public class TripletSum {
    public static boolean find3Numbers(int arr[], int n, int X) { 
    
        // Your code Here
        int i = 0;
        int j = 0;
        int k = n-1;
        Arrays.sort(arr);
        for(i=0; i<n; i++)
        {
            
                j = i+1;
                k = n-1;
                while(j<k)
                {
                    if(arr[j] + arr[k] + arr[i] == X)
                    {
                        return true;
                    }
                    else if(arr[j] + arr[k] + arr[i] > X)
                    {
                        k--;
                    }
                    else
                    {
                        j++;
                    }
                    
                }
            
            
        }
        return false;
}
}
