package DSA450Restart.Strings;
import java.util.*;
class Solution_RepeatedWord
{
    /*
    Ravi had been saying that he had been there
    
    How do you find the first repeated word in a string? 
    Well for starters, maybe we can split the string from the spaces to make it 
    into a String array

    String[] words = s.split("\\s");
    After that we get the count for each word in the array
    If we find any word to be occuring more than once we print it? But
    we may have multiple words with the same count then what

    Well we can traverse through the string and then look for the repeating 
    number for each of them in the hashmap, and return the first one that we
    find to be greater than 1
    */

    public static String firstRepeatedWord(String s)
    {
        HashMap<String, Integer> mp = new HashMap<>();

        String[] words = s.split("\\s");

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


        for(int i=0; i<words.length; i++)
        {
            if(mp.get(words[i])>1)
            {
                return words[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "Ravi had been saying that he had been there";
        for(int i=0; i<firstRepeatedWord(s).length(); i++)
        {
            System.out.print(firstRepeatedWord(s).charAt(i));
        }
    }

}