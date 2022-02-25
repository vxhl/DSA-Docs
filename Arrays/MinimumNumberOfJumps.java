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
    // Time Complexity: O(2^N)
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
    // arr[] = { 1, 3, 6, 1, 0, 9 };
 

    // O(N^2) approach
    static int minJumpsDynamicApproach(int[] arr, int n)
    {
        // jumps[n-1] will hold our result
        int jumps[] = new int[n];
        int i, j;

        jumps[0] = 0;
        // Find the minimum number of jumps to reach arr[i]
        // from arr[0] and assign this value to jumps[i]
        for(i=1; i<n; i++)
        {
            jumps[i] = Integer.MAX_VALUE;
            for(j=0; j<i; j++)
            {
                if(i<=j +arr[j] && jumps[j] != Integer.MAX_VALUE)
                {
                    jumps[i] = Math.min(jumps[i], jumps[j]+1);
                    break;
                }
            }
        }
        return jumps[n-1];

    }


    // O(N) Approach
    static int minJumpsN(int[] arr)
    {
        // We first intialise the maximum number of steps
        int maxR = arr[0];
        // We set out current number of steps 
        int step = arr[0];
        // We already have done one jump if our arr[0]>0
        int jumps = 1;

        if(arr.length==1) return 0;
        if(arr[0] == 0) return -1; 

        // We start from our second element now
        for(int i=1; i<arr.length; i++)
        {
            // If our index is at the last index we return the jumps
            if(i==arr.length-1) return jumps; 
            // We assign maxR and get the maxR between our already assigned reach and current reach
            maxR = Math.max(maxR, i+arr[i]);
            // Wait this is similar to my approach ain't it? 
            // We then reduce the number of steps
            step--;
            // Now if we have reached our current amount of reach
            if(step==0)
            {
                // We increase our jumps
                jumps++;
                // If our current i is greater than our maxR or equal
                if(i>=maxR)
                {
                    return -1;
                }
                else
                {
                    step = maxR - i;
                }
            }

        }
        
        return jumps;
    }



    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 1, 0, 9 };
        int n = arr.length;
        System.out.println(minJumpsDynamicApproach(arr, n));
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
