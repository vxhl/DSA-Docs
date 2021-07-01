/*
Problem Statement:
Given an array of integers A, find and return the peak element in it.
An array element is peak if it is not smaller than it's neighbours

Example:
1. Input: A = [4,17,100,11] Output: 100
2. Input: A = [4,18,17,100,11] Output: 18
*/

package CodeWithScaler.Week6_GoogleInterviewQuestions;

public class peakOfArray {

    // Approach 1: Iterative O(N) approach
    // Time Complexity: O(N)
    static int peakElement(int[] arr)
    {
        int n = arr.length; // Length of the array
        // If our first element is the peak 
        if(arr[0]>arr[1]) return arr[0]; 
        // If our last element is our answer
        if(arr[n-1]>arr[n-2]) return arr[n-1];
        // If only one element in the array
        if (n==1) return arr[0];


        for(int i = 1; i< n-1; i++)
        {
            if(arr[i]>arr[i+1] && arr[i]>arr[i-1])
            {
                return arr[i];
            } 

        }
        return 0;
    }

    // Approach 2: Binary Search approach
    // Time Complexity: O(logN)
    static int peakElementOptimised(int[] A)
    {
        int n = A.length;
        int l = 0;
        int r = n-1;
        int mid = l+r/2;
        if(n==1) return A[0];
        while(l<=r)
        {
            if((mid == 0 || A[mid-1]<=A[mid]) && (mid==n-1 || A[mid+1]<=A[mid]))
            {
                return A[mid];
            }
            if(mid-1>=0 && A[mid-1]>A[mid]) 
            {
                mid = mid-1;
            }
            if(mid+1>=0 && A[mid+1]>A[mid])
            {
                mid = mid+1;
            }
            l++;
            r--;
        }
        return A[mid];
    }
    public static void main(String[] args) {
        int arr[] = {5,18,17,100,11};
        System.out.println("The peak element is: " + peakElement(arr));
        System.out.println("The peak element is: " + peakElementOptimised(arr));
    }

}