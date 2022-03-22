package Arrays.SlidingWindowsProblems;
import java.util.*;

public class MaxSubarraySizeK {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
         int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> q=new LinkedList<>();
        while(j<arr.length){
            // We peek at the end of the window and see whether our current element is greater than the
            // current element, if it is greater than we remove that element since there is no longer a need for it
            if(q.isEmpty()==false && q.peekLast()<arr[j]){
                while(q.peekLast()!=null && q.peekLast()<arr[j]){
                    q.removeLast();
                }
            }
            // After removing we ofc also add that greater element into the queue
            q.addLast(arr[j]);

            // We traverse as long as we don't hit the window size
            if(j-i+1<k){
                j++;
            }

            // Here we do our calculations for the answer
            else if(j-i+1==k){
                // While our queue is not empty the element at the start of the queue gets added as the max of that window
                if(q.isEmpty()==false) list.add(q.peekFirst());

                // Now for before sliding our window, if we find that the element that we just added from our queue into our
                // list is the first element of the current window or not, if it is then we remove that element from the queue since it
                // is no longer relevant to the next window
                if(q.isEmpty()==false && q.peekFirst()==arr[i]){
                    q.removeFirst();
                }
                // And like usual after that we slide our window forward
                i++;
                j++;
            }
        }
        return list;
    }
}
