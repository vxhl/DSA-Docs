import java.io.*;
import java.util.*;

class Solution {

    // Brute Force insertion sort approach
    static int[] insertionSortApproach(int[] arr, int k)
    {
        
    }




    // Time Complexity: O(N*logK) -> Since we are replacing for all N elements in the heap and heapifying in our heap takes
    // log(k+1) time for the k+1 elements that can present at any time in our heap
  static int[] sortKMessedArray(int[] arr, int k) {
    // your code goes here
        int[] tempArr = arr;
        // We use a minHeap for populating the elements in the range that we have
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        int n = arr.length;
        // We first populate our queue
        for(; i<=k; i++)
        {
            minHeap.add(arr[i]);
        }

        for(; i<arr.length; i++)
        {
            // Since i will be k+1
            // We replace the element at the start of our range with the least element from our minHeap and then remove it
            tempArr[i-k-1] = minHeap.peek();
            minHeap.poll();
            // After removing we add back into the minHeap the element where we are currently at
            minHeap.add(tempArr[i]);
        }
        // Our minHeap is still not empty so we populate the places while popping the elements from the minHeap
        i = n-minHeap.size();
        while(!minHeap.isEmpty())
        {
            tempArr[i] = minHeap.peek();
            i++;
            minHeap.poll();
        }

        return tempArr;
    
  }

}