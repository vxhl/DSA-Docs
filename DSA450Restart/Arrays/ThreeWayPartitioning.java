/*
Given an array of size N and a range [a,b]
The task is to partition the array around the range such that 
the array is divided into three parts. 
Rules - 
a. All elements smaller than a comes first
b. All elements in range a to b comes next
c. All elements greater than b appear in the end
*/
package DSA450Restart.Arrays;
import java.util.*;
public class ThreeWayPartitioning {
    
    // Time Complexity: O(N)
    public static int[] twp(int[] arr, int a, int b)
    {
        // First we add the elements that are smaller than a
        // then elements between a and b so greater than a and smaller than b
        // Then elements greater than b
        // We return 1 if an arrangement obeying atleast one of the rules appears? 
        // so if ds is not empty we return 1 and otherwise return 0?
        // Ok so we don't need to return anything just print the array ok

        // First we sort the array
        // Arrays.sort(arr);
        // Oh wait. That directly gives us the answer. 
        // Ok so how to do this O(N) time. 

        // 7,6,9,2,4,3
        // We need -> 2,3,4,6,7,9
        // So we are basically sorting the array in this problem but we have a few rules in place this
        // time around. 

        // We have let's say 3,4 as our A and B
        int k = 0;
        int N = arr.length;

        // we grab one by one all elements that are greater than and exchange it with array[k++]

        for(int i=0; i<N; i++)
        {
            if(arr[i]<a)
            {
                swapping(arr, k++, i);
            }   
        }

        // Ok exactly like how I did just with differnet loops lel
        for(int i=0; i<N; i++)
        {
            if(arr[i]>=a && arr[i]<=b)
            {
                swapping(arr, k++, i);
            }
        }

        for(int i=0; i<N; i++)
        {
            if(arr[i]>b)
            {
                swapping(arr, k++, i);
            }
        }
        return arr;
        
        }

        private static void swapping(int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    public static void main(String[] args) {
        int[] arr = {7,6,9,2,4,3};
        int a = 3;
        int b = 4;
        
        for(int i: twp(arr, a, b))
        {
            System.out.print(i + " ");
        }
    }
}
