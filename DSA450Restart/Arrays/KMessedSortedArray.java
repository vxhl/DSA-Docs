import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    // your code goes here
    int[] tempArr = arr;
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
            tempArr[i-k-1] = minHeap.peek();
            minHeap.poll();
            minHeap.add(tempArr[i]);
        }

        i = n-minHeap.size();
        while(!minHeap.isEmpty())
        {
            tempArr[i] = minHeap.peek();
            i++;
            minHeap.poll();
        }

        return tempArr;
    
  }

  public static void main(String[] args) {

  }

}