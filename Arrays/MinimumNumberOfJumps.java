/*
Problem Statement:

Find the minimum number of jumps to reach the end of the array 
(starting from the first element). If an element is 0, then you cannot move through that element.
Example-1__
Input:
N = 11 
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
Output: 
3 
*/

package Arrays;
import java.util.*;

public class MinimumNumberOfJumps {


    // Approach 1: Naive Recursive Approach 
    // Time Complexity: O(N^2)
    static int minjumps(int arr[], int l, int h)
    {
        // Base Case: When source and destination are same
        if(h==l) return 0;
        
        // When nothing is reachable from the given source
        if(arr[l]==0) return -1;

        // Traverse through all the points reachable from arr[l].
        // Recursively get the minimum number of jumps needed to reach arr[h]
        // from these reachable points.
        int min = Integer.MAX_VALUE;
        for(int i=l+1; i<=h && i<=l+arr[l]; i++)
        {
            int jumps = minjumps(arr, i, h);
            if(jumps != Integer.MAX_VALUE && jumps + 1< min)
            {
                min = jumps+1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};

        // int count = 0;
        // int jumps = 0;
        // int n = arr.length;
        // for(int i=0; i<n; i++)
        // {
        //     jumps = arr[i];
        //     if(jumps==0)
        //     {
        //         System.out.print(0);
        //         break;
        //     }
        //     i+=jumps;
        //     if(i>n)
        //     {
        //         i=n;
        //     }
        //     count+=1;
        // }
        // System.out.print("The minimum number of jumps are: "+ count);
    }
}
