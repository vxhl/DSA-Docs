package DSA450Restart.SearchingSorting;
import java.util.*;
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        
        Map<Integer, Integer> set = new HashMap<>();
        for(int i: arr)
        {
            set.put(i, set.getOrDefault(i,0)+1);
        }
        
        for(int i: arr)
        {
            if(set.containsKey(n+i) && n!=0)
            {
                return true;
            }
            if(n==0)
            {
                if(set.containsKey(n+i) && set.get(n+i)>1)
                {
                    return true;
                }
            }
        }
        return false;
        
        
        
    }
}