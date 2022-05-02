package Algorithm_1_Leetcode;
import java.util.*;

class Solution
{
    static void sortSquares(int arr[])
    {
       int left = 0;
       int right = arr.length-1;
       int[] ans = new int[arr.length];
       int idx = 0;
       while(left<=right)
       {
            if(arr[left]*arr[left] < arr[right]*arr[right])
            {
                ans[idx] = arr[left];
            }
            else
            {
                ans[idx] = arr[left];
                left--;
            }
            idx++;
       }
       System.out.println(Arrays.toString(ans));
    }
    public static int[] sortedSquares1(int[] arr)
    {
        int n = arr.length;
        int[] a = new int[n];
        int smallestSquareidx = 0;
        
        int firstNonNegativeElementIndex = n;
        for(int i = 0; i<n; i++)
        {
            if(arr[i]>=0)
            {
                firstNonNegativeElementIndex = i;
                break;
            }
        }

        int negItr = firstNonNegativeElementIndex - 1;
        int posItr = firstNonNegativeElementIndex;
        while(negItr >= 0 && posItr < n)
        {
            int negElementSquare = arr[negItr]*arr[negItr];
            int posElementSquare = arr[posItr]*arr[posItr];

            if(negElementSquare < posElementSquare)
            {
                a[smallestSquareidx++] = negElementSquare;
                negItr--;
            }
            else
            {
                a[smallestSquareidx++] = posElementSquare;
                posItr++;
            }
        }
             // Add the square of remaining negative elements to the output
        while(negItr >= 0) {
            a[smallestSquareidx++] = a[negItr]*a[negItr];
            negItr--;
        }
        
        // Add the square of the remaining positive elements to the output
        while(posItr < n) {
            a[smallestSquareidx++] = a[posItr]*a[posItr];
            posItr++;                
        }
        return a;
    } 


    public static void main(String[] args)
    {
        int[] arr = {-4,-1,0,3,10};
        System.out.println(sortedSquares1(arr));
    }
}
