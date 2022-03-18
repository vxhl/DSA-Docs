package DSA450Restart.Arrays;
import java.util.*;
public class ChocolateDistribution {
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        int r = (int)m - 1;
        int l = 0;
        long curr = 0;
        long max = a.get(r)-a.get(0);
        
        while(r<a.size())
        {
            curr = a.get(r) - a.get(l);
            
            if(curr<max)
            {
                max = curr;
            }
            l++;
            r++;
        }
        
        return max;
        
    }
}
