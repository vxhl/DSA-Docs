package Arrays.SlidingWindowsProblems;
import java.util.*;
public class FirstNegativeNumberSizek {
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        
         int left = 0;
         int right = 0;
         Queue<Long> q = new LinkedList<>();
         long[] ans = new long[N-K+1]; // Why is this the size of our answer tho? 
         // 
         int p = 0;
         while(right<N)
         {
             if(arr[right] < 0)
             {
                 q.add(arr[right]);
             }
             
             if(right-left+1 == K)
             {
                 // Ok so whenever our queue is empty this means
                 // that our current window has no negative elements at all
                 // so we add a 0 instead
                 if(q.size() == 0)
                 {
                     ans[p++] = (long)0;
                 }
                 else
                 {
                     // If not then we add the first element from our queue
                     // into the ans which is the first occuring negative element 
                     // in our current window
                     ans[p++] = q.peek();
                 }
                 
                 // Ok I do not entirely get this part
                 // So what we poll from the queueu whenever oour element at the left is equal to our element at the top of the quque?
                 // Oh ok
                 // SO IF in our current window we have our current element at left as the first negative element 
                 // then inorder to get the correct answer for the next window we need to move forward and remove that negative element
                 // from the previous windows answer from the queue
                 if(q.size() > 0 && arr[left] == q.peek())
                 {
                     // 
                     q.poll();
                 }
                 left++;
                 right++;
             }
             
             else
             {
                right++;
             }
         }
         return ans;
    }
}
