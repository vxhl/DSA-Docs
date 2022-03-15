package DSA450Restart.Arrays;

import java.util.*;

public class SubsetofAnother
{
    public String isSubset( long a1[], long a2[], long n, long m) {
       
        int n1 = (int) n;
        int m1 = (int) m;
        int count = 0;
        
        HashSet<Long> mp = new HashSet<>();
        
        for(long i: a2)
        {
            mp.add(i);
        }
        
        for(int i=0; i<a1.length; i++)
        {
            if(mp.contains(a1[i]))
            {
                count++;
                
            }
            else
            {
                continue;
            }
        }
        
        if(count==m1)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }
}