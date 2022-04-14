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


    // O(N) average time complexity quick select approach
    public static int kthSmallestQuickSelect(int[] arr, int k)
    {
        /*
        Ok I get what we are supposed to do. Let's first choose our pivot and just
        partition our array, then when we find that our pivot position is smaller then we
        recur the same on the right side, otherwise we do on the left side. 
        */
        // Ok looks like we do need a helper function for this, do I right 
        // the general partition logic here? Well let's write it first after that we
        // will modify it accordingly
        return findKthSmallestHelper(arr, 0, arr.length-1, k);
    }

    public static int findKthSmallestHelper(int[] arr, int low, int hig, int k)
    {
            int pos = quickselect(arr, low, hig);
            if(pos == k-1)
            {
                return arr[pos];
            }

            if(pos<k-1)
            {
                return findKthSmallestHelper(arr, pos+1, hig, k);
            }
            else
            {
                return findKthSmallestHelper(arr, low, pos-1, k);
            }
    }


    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int quickselect(int[] arr, int low, int high)
    {
        // We define our pivot as usual as the middle element
        int pivot = arr[high];
        // Our low and high are defined in the calls anyway
        int i = low;
        for(int p = low; p<=high; p++)
        {
            if(arr[p] < pivot)
            {
                // We swap our element at p with our pivot point
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
                i++;
            }

        }
        // We break out of the loop when we find that j has crossed i
        // We now swap our element at pivot with j
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }









    
    public static void main(String[] args) {
        int[] arr = {7,10,4,20,15};
        System.out.println(kthSmallestQuickSelect(arr, 3));
        //System.out.print(kthMinUtil(arr, 2));

    }
}
