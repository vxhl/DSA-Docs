import java.util.*;
class CheckIfStringContainsAllBinaryCodesSizek {
    public boolean hasAllCodes(String s, int k) {
        // Ok so where were we
        HashSet<String>  set = new HashSet<>();
        // we now form all the possible substrings in a sliding window fashion
        
        int i = 0;
        int j = 0;
        
        while(j<s.length())
        {
            if(j-i+1 == k)
            {
                set.add(s.substring(i, j+1));
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        
        if(set.size() == (int)Math.pow(2, k))
        {
            return true;
        }
        System.out.print(set.size() + " " + Math.pow(2,k));
        return false;
    }
}
