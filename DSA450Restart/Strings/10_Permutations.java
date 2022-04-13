package DSA450Restart.Strings;
import java.util.*;
class Solution_permutations
{
    /*
    I hear permutations I think recursion.
    We need to form and print all the elements that form a permutation of the array ABC.
    */
    
    public List<String> find_permutation(String S) {
        // Code here
        List<String> res = new ArrayList<String>();
        int i = 0;
        find(S, i, res);
        Collections.sort(res);
        return res;
    }
    
    public void find(String S, int i, List<String> res)
    {
        if(i >= S.length())
        {
            res.add(S);
            return;
        }
        for(int j = i; j < S.length(); j++)
        {
            S = swap(S, i, j);
            find(S, i+1, res);
            S = swap(S, i, j);
        }
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}