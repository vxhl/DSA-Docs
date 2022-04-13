package DSA450Restart.SearchingSorting;
import java.util.*;
class Solution_FirstLastOccurence {
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        int first = -1;
        int last = -1;
        long[] res = {-1,-1};
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] != x)
            {
                continue;
            }
            if(res[0] == -1)
            {
                res[0] =(long) i;
            }
            res[1] = (long)i; 
        }
        if(res[0] == -1)
        {
            res[1] = -1;
            ArrayList<Long> ans = new ArrayList<>();
            for(int i=0; i<res.length; i++)
            {
                ans.add(res[i]);
            }
            
        }
        
        ArrayList<Long> ans = new ArrayList<>();
        for(int i=0; i<res.length; i++)
        {
            ans.add(res[i]);
        }
        
        return ans;
        
        
        
        
    }
}
