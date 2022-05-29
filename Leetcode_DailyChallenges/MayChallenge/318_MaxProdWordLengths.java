import java.util.*;

class MaxProdWordLengths {

    // Brute Force using Maps
    public int maxProduct(String[] words) {
        int max = 0;
        
        for(int i=0; i<words.length; i++)
        {
            HashMap<Character, Integer> mp = new HashMap<>();
            for(char c: words[i].toCharArray())
            {
                mp.put(c, mp.getOrDefault(c, 0)+1);
            }
            
            
            for(int j=0; j<words.length && j!=i; j++)
            {
                boolean flag = false;
                for(int k=0; k<words[j].length(); k++)
                {
                    if(mp.containsKey(words[j].charAt(k)))
                    {
                        flag = true;
                    }
                }
                if(flag == false)
                {
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        
        return max;
    }


    public int maxProduct2(String[] words) {
        int n = words.length;
        int[] state = new int[n];
        G
        for(int i=0; i<n; i++)
        {
            state[i] = stateBased(words[i]);
        }
        int max = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                // If we find the ands of the two states to be 0 that means there are no common characters, and so we calculate the max
                if((state[i]&state[j])==0)
                {
                    max = Math.max(words[i].length()*words[j].length(), max);
                }
            }
        }
        return max;
    }
    
    
    public static int stateBased(String word)
    {
        int state = 0;
        // We loop over all characters in the string
        for(char c: word.toCharArray())
        {
            // We calculate the index where the current letter is at in the
            // range of 1-26
            // For example if it is 'c' we get the position 2
            int index = c - 'a';
            // We then shift 1 by whatever the value of our index is
            // for example 1 is represented in binary as 001 so if we shift by 'c'-'a' which is 2 positions, we get 100 which in decimal form is actually 4
            // so our state becomes 4 initially
            // similarly if we keep or'ing and the resulting state for the string cba becomes 110 and if we and ed with it which is 11000 we get 0 because
            // there are no similar characters between cba and ed
            state |= 1 << (index);
        }
        
        return state;
    }

public static void main(String[] args) {
    int state = 0;
    int index = 'l'-'a';
    
    System.out.println(1<<index);
    state = state | 1<<index;
    System.out.println(state);
}
}
