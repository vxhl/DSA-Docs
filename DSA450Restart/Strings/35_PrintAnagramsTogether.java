package DSA450Restart.Strings;
import java.util.*;
class Solution_Anagrams
{
    
    // Approach 2: HashMap<HashMap, List> 
    // WOW THAT WORKED! 

    public static List<List<String>> Anagrams(String[] list)
    {
        List<List<String>> ans = new ArrayList<>();

        HashMap<HashMap<Character, Integer>, List<String>> mp = new HashMap<HashMap<Character, Integer>, List<String>>();

        for(int i=0; i<list.length; i++)
        {
            HashMap<Character, Integer> tempHash = new HashMap<>();
            for(char c: list[i].toCharArray())
            {
                tempHash.put(c, tempHash.getOrDefault(c, 0)+1);
            }
            
            if(!mp.containsKey(tempHash))
            {
                
            List<String> ds = new ArrayList<>();
                ds.add(list[i]);
                mp.put(tempHash, ds);
            }
            else
            {
                mp.get(tempHash).add(list[i]);
            }

        }

        for(Map.Entry mapElement: mp.entrySet())
        {
            ans.add((List<String>) mapElement.getValue());
        }

        return ans;

    }


    public static void main(String[] args) {
        String[] list = {"dog", "god", "cat", "act", "tac"};
        
        for(int i=0; i<Anagrams(list).size(); i++)
        {
            for(int j=0; j<Anagrams(list).get(i).size(); j++)
            {
                for(int k=0; k<Anagrams(list).get(i).get(k).length(); k++)
                {
                    System.out.print(Anagrams(list).get(i).get(k).charAt(k) + " ");
                }
                System.out.println();
            }
        }
    }
}