package DSA450Restart.Matrices;
import java.util.*;


class Solution
{
    /*
    Don't feel like much of a talker today so I'll just type what I understand here

    Our matrix is row-column wise sorted
    How were we supposed to take advantage of that again? Binary Search ain't it? 
    Even if we do binary search we need the kth smallest element from this matrix

    One way to do this is ofc the previous method where we put all elements in the 
    matrix into a 1D array and then use either the Quick Select algorithm or the
    priority queue method to find the kth element

    So yeah that's one approach, what can be other approaches? 

    Looks like a space of N is expected from us and not one of N*N
    Well I get that the heap is gonna give us a TC of K*LogN but what about the space it takes? 
    The heap will ofc take the N*N amount of space as well won't it? 

    */

    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
       int n = arr.length;
       for(int i=0; i<n; i++)
       {
           for(int j=0; j<n; j++)
           {
               maxHeap.add(arr[i][j]);
               if(maxHeap.size()>k)
               {
                   maxHeap.poll();
               }
           }
       }
       
       return maxHeap.peek();
   }

   // This is fine and all but how do we implement binary search on here

   // 1,2,3,4,5,7,8,10,11 -> let's say this is the matrix that we have
   // Now the matrix is ofc sorted right. Since it is sorted, we can think of applying binary search in here
   // Let's say we take the arr(0,0)th element as our left and the (n-1,n-1)th element at our right
   // Now we calculate the mid ofc
   // we make a new function like we did for the median problem. What we do is we count the number of elements that are smaller than our mid 
   // Now if the count is >= mid then we just set our ans as mid for now and do high = mid-1;
   // wait up
   // We have 1,2,3,4,7,8,10,11 right
   // We find our mid here as 6 right
   // We count the number of elements that are smaller than or equal to 6
   // The value initially will come out as 4 and the case here is that
   // our 4<k or 4>=k
   // on our first case ofc we update low to mid+1 thus getting a new range
   // the other case we take a variable ans where we store the value of mid
   // and we reduce our search space from high = mid-1
   // Now the question is why do we update the value of ans whenever we find that
   // our mid is greater than or equal to k

   // Let us take the example where k = 7
   // In this case what happens in 1,2,3,4,7,8,10,11 here mid = 6
   // We see our count for elements smaller than k is smaller than 6 so
   // now we have low = mid+1 -> low = 7 high = 11
   // We again update our mid for here between 7 8 10 11 mid -> 9
   // We see if our mid is smaller 

   // Sorry if the comments don't make a lot of sense, these are more for my own purposes.


   public static int kthSmallest2(int[][] arr, int k)
   {
       // Using the ranking algorithm for binary search
       int n = arr.length;
       // Keep in mind we have taken the left and right
       // as the values and not the indices
       int low = arr[0][0];
       int high = arr[n-1][n-1];
       while(low<high)
       {
           // We get the middle element
           int mid = low+(high-low)/2;
           // we now check the rank of the middle element in the matrix
           // basically what we do is we count the number of elements that are lesser than our current
           // element and if it is greater than k then we reduce high to mid-1
           // otherwise if the count/rank is smaller than k then we increase low to mid+1
           int count = lessEqualk(arr, mid);
           if(count<k) low = mid+1;
           else high = mid;
       }
       
       return low;
       
   }
   
   public static int lessEqualk(int[][] arr, int mid)
   {
       // Here we check the number of elements that are smaller than our mid
       int count = 0;
       int n = arr.length;
       int i = n-1;
       int j = 0;
       while(i>=0 && j<n)
       {
           // If the element at the current index is greater than 
           // This is from search 2D matrix II. I need to do that after this then. 
           if(arr[i][j] > mid) i--;
           else
           {
               count = count + i+1;
               j++;
           }
              
       }
       
       return count;
       
   }

}