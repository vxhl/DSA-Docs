package DSA450Restart.Arrays;
import java.util.*;

class Solution_day4
{
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        // We first add all the elements into our heap
        for(int i: arr)
        {
            maxHeap.add(i);
        }
        
        while(maxHeap.size()>1)
        {
            maxHeap.add(maxHeap.poll() - maxHeap.poll());
        }
        
        
        return maxHeap.poll();
    }
}