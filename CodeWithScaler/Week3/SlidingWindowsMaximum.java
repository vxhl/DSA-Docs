package CodeWithScaler.Week3;

import java.util.Deque;
import java.util.LinkedList;

public  class SlidingWindowsMaximum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {4,3,1,2,5,3,4,7,1,9};
        int ans[] =  solution.slidingMaximum(a, 4);
        for(int x: ans)
        {
            System.out.println(x + " ");
        }
    }
    static class Solution {

        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] slidingMaximum(final int[] A, int B) 
        {
            int n = A.length;
            if(n<=1) return A;
            Deque<Integer> dq = new LinkedList<>();
            int ans[] = new int[n-B+1]; // Since this is the length of the array we have to return
            int i = 0;
            // Let us fill the doubly ended queue with the first B values
            for(; i < B; i++)
            {
                // In this for loop : 
                // We need to fill the indices in the deque
                // We need to check if the element at the rightmost
                // is larger than the element we are currently checking
                
                while(!dq.isEmpty() && A[dq.peekLast()] <= A[i])
                {
                    dq.removeLast();
                    // SO we remove the last element if our current element >= the element at the rightmost 
                }
                dq.addLast(i); // Once we remove we add the current element to our deque
            
            }
            // Now we check for the rest of the array
            for(; i<n; i++) 
            {
                ans[i-B] = A[dq.peekFirst()]; // Our first element gets appended
                // Now we set the condition for whenever our number gets out of the window
                while(!dq.isEmpty() && dq.peekFirst() <= i-B)
                {
                    dq.removeFirst(); // We remove the element since it is now outside our windoe i-B
                }

                // We again do the loop for whenever our rightmost number is not greater than our current number
                while(!dq.isEmpty() && A[dq.peekLast()] <= A[i])
                {
                     dq.removeLast();         
                }
                dq.addLast(i);

            }
            ans[i-B] = A[dq.peekFirst()]; // Then we add our last number
            return ans;

        }
    }
    
}
