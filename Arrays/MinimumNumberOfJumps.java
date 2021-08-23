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
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int count = 0;
        int jumps = 0;
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            jumps = arr[i];
            if(jumps==0)
            {
                System.out.print(0);
                break;
            }
            i+=jumps;
            if(i>n)
            {
                i=n;
            }
            count+=1;
        }
        System.out.print("The minimum number of jumps are: "+ count);
    }
}
