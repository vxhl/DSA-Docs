package Leetcode_DailyChallenges;
import java.util.*;


class KthLargest {
    
    private static int k; 
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        for(int i: nums)
        {
            minHeap.add(i);
        }
        
        while(minHeap.size()>k)
        {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k)
        {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}