package DSA450Restart.Strings;
import java.util.*;
class Solution_printSubsequnces
{
    // We need our stirng, our index i, our resultant final array, 
    public static ArrayList<ArrayList<Character>> helper_func(String str, int i, ArrayList<Character> ds)
    {
        // Maybe this will work
        int n = str.length();
        ArrayList<ArrayList<Character>> ans = new ArrayList<>();
        // THis is our base case
        if(i==n)
        {
            ans.add(ds);
            return ans;
        }

        helper_func(str, i+1, ds);
        ds.add(str.charAt(i));
        helper_func(str, i+1, ds);
        ds.remove(ds.size()-1);


        return ans;
    }


    public static ArrayList<ArrayList<String>> printSubsequnces(String str)
    {

    }
}