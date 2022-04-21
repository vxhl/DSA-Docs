package DSA450Restart.Strings;
import java.util.*;
class Solution_RestoreIP
{
    // Our i keeps track of each substring and tracks it as long as it is smaller than 4, i.e, xxx. 
    // Our ds is used to store each valid IP
    public static void helper_restoreIP(int i, String s, String ds, List<String> ans)
    {
        // We first define our base cases
        if(i==4)
        {
            // We add till the last 2nd index since we don't need the last dot of the entire ip address, we just need 3 of them
            // Once we have exhausted our entire string it means we have made a successful IP address using the whole string
            if(s.length()==0) ans.add(ds.substring(0, ds.length()-1));
            return;
        }
    for(int k=1; k<=3; k++)
    {   
        // We first set a condition for the length of the string being valid for our IP subunits
        if(s.length() < k) continue;
        // Our loop runs till 3 indexes, thus taking all the possible units places necessary for each valid IP's sub units
        // We first calculate the value for the current IP of length 1
        int val = Integer.parseInt(s.substring(0,k));
        // Now we check whether the value is greater than 255 and whether it is prefixed with 0 or not
        if(val>255 || k != String.valueOf(val).length())
        {
            continue;
        }

        // Now we define our backtracking function
        helper_restoreIP(i+1, s.substring(k), ds + s.substring(0,k)+".", ans);
    }
}
}
