package DSA450Restart.Strings;
import java.util.*;
class Solution_Anagrams
{
    // Basically we have a stringlist and we have to check for every string whether it is an anagram of the current string that we are on
    // and we need to add that in a group. HOW
    public static List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<>();
        // {act,god,cat,dog,tac} -> {{act,cat,tac}, {dog, god}};
        boolean[] vis = new boolean[string_list.length];

        // THe idea is to visit each stirng in our array and put it into a map and mark it as visited
        // then we traverse the rest of the array and see if the element when put into our map has the same values and keys if it does then we add
        // it into our answer, and also mark that as visited. 

        HashMap<Character, Integer> anagram  = new HashMap<>();

        for(int i=0; i<string_list.length; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                for(char c: string_list[i].toCharArray())
                {
                    anagram.put(c, anagram.getOrDefault(c,0)+1);
                }
                int j = i;
                List<String> ds = new ArrayList<>();
                while(j<string_list.length)
                {
                    if(!vis[j])
                    {
                        vis[j] = true;
                        if(anagram.containsKey(string_list[j].charAt(0)))
                        {
                            HashMap<Character, Integer> dummy  = new HashMap<>();
                            for(char x: string_list[j].toCharArray())
                            {
                                dummy.put(x, dummy.getOrDefault(x,0)+1);
                            }
                            if(dummy.equals(anagram))
                            {
                                
                            System.out.print("Worked");
                                ds.add(string_list[j]);
                                
                            }

                        }
                    }
                    j++;
                }
                System.out.println("Workinggggg");
                ans.add(ds);
                ds.clear();
            }
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