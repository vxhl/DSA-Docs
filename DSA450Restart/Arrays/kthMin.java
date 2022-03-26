package DSA450Restart.Arrays;
import java.util.*;

public class kthMin {
    
    public static int kthSmallest(int[] arr, int k) 
    { 
        // In java by default we have the priority queue as a maxHeao
        // to convert into a minHeap we use the comparators
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        
        for(int i=0; i<arr.length; i++)
        {
            
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek();
        
    } 
    public static void main(String[] args) {
        int[] arr = {7,10,4,20,15};
        System.out.println(kthSmallest(arr, 3));
        //System.out.print(kthMinUtil(arr, 2));
    }
}
