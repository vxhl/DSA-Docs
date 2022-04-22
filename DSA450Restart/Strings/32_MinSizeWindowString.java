package DSA450Restart.Strings;
import java.util.*;
class Solution_MinWindow
{
    public static int findSubString( String s) {
        // Your code goes here
        int ans = Integer.MAX_VALUE;
        int left=  0;
        int right = 0;
        HashMap<Character, Integer> mp = new HashMap<>(); 
        for(int i=0; i<s.length(); i++)
        {
            mp.put(s.charAt(i), 1);
        }
        
        int count = mp.size();
        while(right<s.length()-1)
        {
            if(count>0)
            {
                if(mp.containsKey(s.charAt(right)))
                {
                    mp.put(s.charAt(right), mp.get(s.charAt(right))-1);
                    if(mp.get(s.charAt(right)) == 0)
                    {
                        count--;
                        System.out.println("Does this work");
                        // Does this even work? 
                        // if(count == 0)
                        // {
                        //     ans = Math.min(ans, right-left+1);
                        // }
                    }
                    right++;
                }
            if(count==0)
            {
                
            ans = Math.min(ans, right-left+1);
            }
            
            while(count == 0)
            {
                if(mp.containsKey(s.charAt(left)))
                {
                    if(mp.get(s.charAt(left))<0)
                    {
                        // mp.put(s.charAt(left), mp.get(s.charAt(left))+1);
                        
                    ans = Math.min(ans, right-left+1);
                        left++;
                        System.out.println("No problems here");
                    }
                    else
                    {
                        mp.put(s.charAt(left), mp.get(s.charAt(left))+1);
                        
                        
                    // System.out.println("Heheheh");
                    count++;
                    }
                    
                        
                }
            }
            
            
        }
    }
    System.out.println(s.charAt(left));
    System.out.println(s.charAt(right));
    System.out.println(left);
    System.out.println(right);
        return ans;
        
        
    }


    // brute force using a hashmap
    public static int findSubString2(String s)
    {
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(mp.containsKey(s.charAt(i)))
            {
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }
            else
            {
                mp.put(s.charAt(i), 1);
            }
        }
        int count = mp.size();
        int size = Integer.MAX_VALUE;
        String res = "";

        for(int i=0; i<n; i++)
        {
            int c = 0;
            // We use a visited array of max_chars size
            boolean vis[] = new boolean[256];
            for(int j=0; j<256; j++)
            {
                vis[j] = false;
            }
            String sub_str = "";
            for(int j=i; j<n; j++)
            {
                if(!vis[s.charAt(j)])
                {
                    c++;
                    vis[s.charAt(j)] = true;
                }
                sub_str += s.charAt(j);
                if(c == count)
                {
                    break;
                }
            }

            if(sub_str.length()<size && count == c)
            {
                res = sub_str;
                size = res.length();
            }

            
        }
        return res.length();
    }

    // Sliding windows: My approach but with the right implementation

    public static int SmallestWindow(String s)
    {
        // As usual for a sliding window, we have our starting and ending indexes for the window
        int start = 0; 
        int end = 0;
        // We have the counter that counts the number of distinct characters for the current window
        int counter = 0;

        // Then we have our answer vairable set to max
        int min = Integer.MAX_VALUE;
        
        // We get the total number of distinct character using a hashset
        // though we can also use the 256 array to get it by seeing the ttoal characters that are not null
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++)
        {
            set.add(s.charAt(i));
        }

        int[] curr_count = new int[256];
        
        int size = set.size();
        // We run our usual loop for the window
        while(end<s.length())
        {
            // For any current element, we increment it's occurence 
            curr_count[s.charAt(end)]++;
            // If we find the occurence to be 1 only then do we increment our counter
            if(curr_count[s.charAt(end)] == 1)
            {
                counter++;
            }
            // When our counter reaches the desired size of the distinct substring
            if(counter == size)
            {
                // While the count for the curr character at the start of the window is greater than 1, meaning we have more
                // characters then we need
                while(curr_count[s.charAt(start)]>1)
                {
                    if(curr_count[s.charAt(start)]>1)
                    {
                        // We reduce the count
                        curr_count[s.charAt(start)]--;
                    }
                    // And move to the next element
                    start++;
                }
                // We then get the length of the current window and get the minimum of it
                int len_window = end - start + 1;
                if(min > len_window)
                {
                    min = len_window;
                }
            }
            end++;
        }


        return min;

    }



    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.print(SmallestWindow(s));
    }
}