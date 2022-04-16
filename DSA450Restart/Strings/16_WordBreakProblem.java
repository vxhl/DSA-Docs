package DSA450Restart.Strings;
import java.util.*;
class Solution_WordBreak
{

    // Tabulation Approach
    public static boolean wordBreak(String str, ArrayList<String> wd)
    {
        /*
            We make a boolean dp array, the length of it will ofc be the same as
            the length of our given string str
            What we are trying to do is for each length of our str, we search in our
            wd which words have the same length as it and then we compare our choices 
            As we compare our choices, if we find a result for that length of the str
            then we just set that length as true, incase we don't find then we cache it as 
            false. That is the main idea ig. 
        */            
        Boolean[] memo = new Boolean[str.length()];
        return canBreak(str, 0, memo, wd);

    }

    public static boolean canBreak(String s, int i, Boolean[] memo, List<String> wd)
    {
        // First of all we define our base conditons using our memo and index

        // If we are able to reach the end of the string, only then can we say that yeah we have successfully been able to
        // find the word s in our wd
        if(i == s.length()) return true;

        // Otherwise, if for the current pattern we already have cached our answer in the memo then we just return that initally and ednthe call
        if(memo[i] != null)
        {
            return memo[i];
        }
        String sub = s.substring(i);
        boolean doesMatch = false;

        for(String word: wd)
        {
            if(sub.startsWith(word))
            {
                if(canBreak(s, i+word.length(), memo, wd))
                {
                    doesMatch = true;
                    memo[i] = true;
                }
            }
        }
        memo[i] = doesMatch;
        return doesMatch;
    }
}