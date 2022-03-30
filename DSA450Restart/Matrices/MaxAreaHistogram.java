package DSA450Restart.Matrices;
import java.util.*;
public class MaxAreaHistogram {


    // This is a O(N) approach, if you wanna submit this is GFG first 
    // make the NSL and NSR function non return types and make new NSR and NSL arr
    // when doing the MAH function, then the solution will be accepted without any TLE
    static class pair
    {
        long height;
        long index;

        pair(long height, long index)
        {
            this.height = height;
            this.index = index;
        }
    }


    private static long[] NSL(long[]arr)
    {
        Stack<pair> st = new Stack<>();
        int n = arr.length;
        long[] ans = new long[n];
        for(int i=0; i<n; i++)
        {
            if(st.isEmpty()) ans[i] = -1;
            else if(st.peek().height < arr[i])
            {
                ans[i] = st.peek().index;
            }
            else
            {
                while(!st.isEmpty() && st.peek().height >= arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty()) ans[i] = -1;
                else { 
                    ans[i] = st.peek().index;
                }
            }
            st.push(new pair(arr[i], (long) i)); 
        }

        return ans;
    }

    private static long[] NSR(long[] arr)
    {   
        Stack<pair> st = new Stack<>();
        int n = arr.length;
        long[] ans = new long[n];
        for(int i=n-1; i>=0; i--)
        {
            if(st.isEmpty()) ans[i] = n;
            else if(st.peek().height < arr[i])
            {
                ans[i] = st.peek().index;
            }
            else
            {
                while(!st.isEmpty() && st.peek().height >= arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty()) ans[i] = n;
                else { 
                    ans[i] = st.peek().index;
                }
            }
            st.push(new pair(arr[i], (long) i)); 
        }

        return ans;
    }
    

    public static long MAH(long[] arr)
    {
        // Now that we have our NSL and NSR we get the width array
        long[] width = new long[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            width[i] = NSR(arr)[i] - NSL(arr)[i] -1;
        }

        // Now we create a area array
        long[] area = new long[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            area[i] = arr[i] * (long) width[i];
        }

        long max = 0;

        for(int i=0; i<arr.length; i++)
        {
            if(area[i]>max)
            {
                max = area[i];
            }
        }

        return max;


    }
    // Smaller and directly optimised approach
    // Striver
    public int LRH(int[] heights) {
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int maxA = 0; 
        for(int i = 0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width; 
                if(st.isEmpty()) width = i; 
                else width = i - st.peek() - 1; 
                maxA = Math.max(maxA, width * height); 
            }
            st.push(i); 
        }
        return maxA;
    }
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5};
        System.out.print(MAH(arr));

        // for(int i: NSL(arr))
        // {
        //     System.out.println();
        // }
    }

}
