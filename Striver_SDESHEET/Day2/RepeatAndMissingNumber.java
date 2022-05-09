/*
Problem Statemnt:
We are given an array of N+1 integers with elements from 1 -> N
We are to return A from here which is repeated twice and B which is missing and
A,B belong to 1-N
*/

package Striver_SDESHEET.Day2;

import java.util.*;

public class RepeatAndMissingNumber {
    // Approach 1: O(N^2)
    public static int[] repeatMissing(int[]arr)
    {
        Arrays.sort(arr);
        int[] res = new int[2];
        if(arr.length == 2){  
            if(arr[0] == arr[1]) 
                res[0] = arr[0]; 
                if(res[0]>1)
                    res[1] = 1;
                else res[1] = 2;
            return res; 
        } 
        
        int flag = 0;
        // We define our index initially since we need to know where our array will find it's missing or duplicate number
        // and then we start from i+1 in the next loop
        int i = 0;
        // We need a flag for determining whether the dupes come first or the missing number
        for(i=0; i<arr.length; i++)
        {
            // Either of these cases will be executed first and we break out of the loop
            
            // Case 1: For finding the dupe
            
            
            if(arr[i] - 1 != i)
            {
                res[1] = i+1;
                flag = 1;
                break;
            }
            
            
            if(arr[i] == arr[i+1])
            {   
                res[0] = arr[i];
                flag = 0;
                break;
            }

            // Since we have our array as sorted we break out of the loop as 
            // soon as we find that our element when subtracted with it' s index is greater than 1
            // and we add it to the resultant array
            
        }

        if(flag == 1)
        {
            // Condition for duplicate as missing is found
            for(int j = i; j<arr.length-1; j++)
            {
                if(arr[j] == arr[j+1])
                {   
                    res[0] = arr[j];
                }
            }

        }
        else
        {
            // condition for missing since duplicate is found
            for(int j = i+1; j<arr.length-1; j++)
            {
                if(arr[j] - 1 != j)
                {
                res[1] = j+1;
                }
            }

        }

        return res;

        
    }

    // Approach 2: The XOR method but without sorting this time.
    public static int[] repMis(int[] arr)
    {
        int[] res = new int[2];
        for(int i=1; i<arr.length-1; i++)
        {
            if(arr[i-1] == arr[i])
            {
                res[0] = arr[i];
            }
            arr[i] ^= arr[i];
            if(arr[i] != 0) res[1] = i;
            
        }
        return res;
    } 

    public static void   main(String[] args) {
        int[] arr = {1,3,3,4,5,6};
        int[] arr2 = {1,2,2,3,5,6};
        int[] arr3 = {1,1,3,4,5,6};
        int[] arr4 = {1,1};
        int[] arr5 = {2,2};
        int[] arr6 = {5,1,3,2,3,4}; // 3, 6
        //repeatMissing(arr2);
        for(int i: repeatMissing(arr6))
        {
            System.out.println(i + " ");
        }
    }
}
