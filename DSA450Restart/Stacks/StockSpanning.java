package DSA450Restart.Stacks;
import java.util.*;
// O(n) solution using pair inside stack

class Pair{
    int value;;
    int index;
    Pair(int key,int value){
        this.value=value;;
        this.index=index;
    }
}

class Solution
{


    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            ans[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        return ans;
    }
// My approach that did not work for some reason.
    public static int[] calculateSpan2(int[] arr, int n)
    {
                // Your code here
                Stack<Integer> st = new Stack<>();
                int[] res = new int[n];
                // We push the first element into the stack
                st.push(0);
                // Also we add 1 to the answer for that element
                res[0] = -1;
                
                for(int i=1; i<n; i++)
                {
                    if(st.isEmpty())
                    {
                        res[i] = -1;
                    }
                    else if(!st.isEmpty() && arr[st.peek()]>=arr[i])
                    {
                        res[i] = st.peek();
                    }
                    else if(!st.isEmpty() && arr[st.peek()]<=arr[i])
                    {
                        while(!st.isEmpty() && arr[st.peek()]<=arr[i])
                        {      
                            st.pop();
                        }
                        if(st.isEmpty())
                            { res[i] = -1;}
                        else { res[i] = st.peek();}
                        
                    }
                    
                    st.push(i);
                    
                }
                int[] ans = new int[n];
                for(int i=0; i<n; i++)
                {
                    ans[i] = i - res[i];
                }
                
                return ans;
    }

}

