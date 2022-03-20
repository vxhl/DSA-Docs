/*
Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.

Example 1:

Input : 
arr[ ] = {2, 1, 5, 6, 3} 
K = 3
Output : 
1
*/

package DSA450Restart.Arrays;
import java.util.*;
public class MinimumSwapsKTogether {
    private static void swap(int start, int end, int[] arr)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        // We are to bring all numbers less than or equal to k together
        // Like I thought this is indeed a Sliding windows problem
        // Now here are the steps to solve this

        // Initially I thought I would need a queue to keep track of the first element in each window but let's see if it can be done without it

        // First we count the good values which will be our window size
        int good = 0;
        for(int i: arr)
        {
            if(i<=k)
            {
                good++;
            }
        }
        // Now that we have found our window size what we do is,
        // we check in each window how many bad values are there
        // If there is a bad value we increment our window
        // But we also check whether the first value in the previous window was a bad value
        // if it was then we decrement
        // in this way we keep track of bad values and for the minimum that is pretty simple we just use a min function to compare the present and previous values
        int i = 0;
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        // we just first of all initialise our standard code for sliding windows
        int count = 0;
        int min = Integer.MAX_VALUE;
        while(j<n)
        {
            // I know the queue version for this works as well so let's do that first
            // So whenever we encounter an element that is greater than our k
            // we add it to our queue
            

            // We first initiliase our standard code for checking
            // what we want to check in the given window
            if(arr[j]>k)
            {
                q.add(arr[j]);
            }
            
            if((j-i+1) == good)
            {
                if(q.size() == 0)
                {
                    // What if we do not find anything? 

                    count += 0;
                }

                else
                {
                    if(q.peek()>k) count++;
                }

                // This is once again for checking whether the first element from our previous window
                // was the bad one
                if(q.size() > 0 && arr[i] == q.peek())
                {
                    q.poll();
                }
                
                i++;
                j++;
            } 

            else
            {
                j++;
            }
            min = Math.min(count, min);
            
            
        }

        return min;

    }




    // Function for finding maximum and value pair
    public static int minSwap1 (int arr[], int n, int k) {
        //Complete the function
        // Well this looks triky but let's see
        
        // We first find an element that is lesser than or equal to k
        // We then check whether the elements on it's left and right side are smaller
        // or greater than k
        // if they are greater than we run another loop from the i+1 position and once we find
        // an element smaller than equal to k then we swap and increment the pointer
        
        
        // Anyway what if we sort the array
        // If we sort it then we get
        // 1, 2, 3, 5, 6
        // If we get this then ofc there is no point
        int good = 0;
        int bad = 0;
        
        for(int i: arr)
        {
            // We initially get the number of good values we have in our array
            // Since we need to have a complete window where we have all good values of size `good`
            
            if(i<=k)
            {
                good++;
            }
            
        }
        
        // We count the number of bad values we have in our first window
        // And then move on to minimise this ans
        for(int i=0; i<good; i++)
        {
            if(arr[i]>k)
            {
                bad++;
            }
        }
            
            int ans = bad;
            int left=  0;
            int right = good;
            
            while(right<n)
            {
               
                    // Once we reach the size of the window we first check if the element
                    // at the start of our window is the bad value if it is then we decrement our count for bad values
                    // since that won't be considered in our window moving forward
                    
                    if(arr[left] > k)
                    {
                        bad--;
                    }
                    
                    // However if the bad value happens to be in the end of the window
                    // then we increase our bad value
                    // This is because our window will keep track of that value moving forawrd even in the next value
                    
                    if(arr[right]> k )
                    {
                        bad++;
                    }
                    
                    
                    ans = Math.min(bad, ans);
                    left++;
                    right++;
            
            }
            
            return ans;
            
        }

    public static void main(String[] args) {
        int[] arr = {2,7,9,5,8,4};
        int k = 6;
        int n = arr.length;
        System.out.println(minSwap(arr, n, k));

    }

}
