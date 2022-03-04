package DSA450Restart.Strings;
import java.util.*;
public class PrintAllDupes {

    public static void printDupesCount(String str)
    {
        // We have a hashmap for keeping track of the character as well as the frequencies of their occurence
        
        HashMap<Character, Integer> mp = new HashMap<>();
        char[] arr = str.toCharArray();

        // We have now made our frequency map for the array 
        for(char i: arr)
        {
            if(!mp.containsKey(i))
            {
                mp.put(i, 0);
            }
            mp.put(i, mp.get(i)+1);
        }

        // I am not very sure how to iterate over a map so I am copying and noting down this part

        for(Map.Entry mapElement: mp.entrySet())
        {
            char key = (char)mapElement.getKey();
            int value = ((int)mapElement.getValue());

            if(value>1)
            {
                System.out.println(key + ", count = " + value);
            }
        }
        
    }


    public static void main(String[] args) {
        String str = "test string";
        printDupesCount(str);
    }
}
