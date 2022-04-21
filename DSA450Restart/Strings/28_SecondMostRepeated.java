package DSA450Restart.Strings;
import java.util.*;
class Solution_IIRepeated
{
    static String secFrequent(String words[], int N)
    {
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<words.length; i++)
        {
            if(!mp.containsKey(words[i]))
            {
                mp.put(words[i], 1);
            }
            else
            {
                mp.put(words[i], mp.get(words[i])+1);
            }
        }

        int max = 0;
        for(String a: mp.keySet())
        {
            if(mp.get(a)>max) 
            {
                max = mp.get(a);
            }
        }


        int sec = 0;
        String str = "";
        for(String a: mp.keySet())
        {
            if(mp.get(a)<max && mp.get(a)>sec)
            {
                sec = mp.get(a);
                str = a;
            }
        }
        
        return str;
    }

    public static void main(String[] args) {
        String[] word = {"geek", "for", "geek", "for", "geek", "aaa"};
        for(int i=0; i<secFrequent(word, word.length).length(); i++)
        {
            System.out.print(secFrequent(word, word.length).charAt(i)+ " ");
        }
    
    }
}