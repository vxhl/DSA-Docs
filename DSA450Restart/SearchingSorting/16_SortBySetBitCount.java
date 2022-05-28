import java.util.*;
class SetBitCount_Solution
{

    // Approach 1: Using Insertion Sort -> Time Complexity: 
    static int findBits(Integer x)
    {
        int count = 0;
        while(x!=0)
        {
            x = x&(x-1);
            count++;
        }
        
        return count;
    }
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        for(int i=1; i<arr.length; i++)
        {
            Integer value = arr[i];
            int k = i;
            while(k>0 && findBits(arr[k-1])<findBits(value))
            {
                arr[k] = arr[k-1];
                k--;
            }
            arr[k] = value;
        }
        
    }
    // GFG Optimised solution
    static void sortBySetBitCount2(Integer arr[], int n)
    { 
        // Your code goes here
        Arrays.sort(arr, (a,b)-> Integer.compare(Integer.bitCount(b), Integer.bitCount(a)));
    } 

    // Leetcode optimised solution
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        arr[i] += 10001 * Integer.bitCount(arr[i]);
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n ; i++)
        arr[i] = arr[i] % 10001;
        return arr; 
    }
}