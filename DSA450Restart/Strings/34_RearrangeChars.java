package DSA450Restart.Strings;
import java.util.*;

class Solution_rearrange
{


	// ACTUAL SOLUTION -> everything below this function is junk for practice, refer if you want
	public String reorganizeString(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
		for(char c: s.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c,0)+1);
        }
        
        // for(int i=0; i<s.length(); i++)
        // {
        //     if(mp.get(s.charAt(i))>(s.length()/2))
        //     {
        //         return "";
        //     }
        // }
		// A maxHeap that orders elements based on our hashMap counts
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> mp.get(b) - mp.get(a));
		maxHeap.addAll(mp.keySet());
		// The maxHeap's root holds the characters that occur most frequently
		StringBuilder sb = new StringBuilder();
		while(maxHeap.size()>1)
		{
			// We take two different characters with different frequencies
			// put them into our answer string, and then check if they have any remaining
			// frequencies, if they do, then we put them back into our heap again
			char curr = maxHeap.remove();
			char next = maxHeap.remove();
			// We added them into our result string
			sb.append(curr);
			sb.append(next);
			// We also reduce their frequences after adding into the result string 
			mp.put(curr, mp.get(curr)-1);
			mp.put(next, mp.get(next)-1);

			//Now we need to check if the count for the characters is still
			// greater than 0 or not, if they are then we put them back into our heap
			// otherwise we don't
			if(mp.get(curr)>0)
			{
				maxHeap.add(curr);
			}
			if(mp.get(next)>0)
			{
				maxHeap.add(next);
			}
		}

		if(!maxHeap.isEmpty())
		{
			char last = maxHeap.remove();
			// If we have more than 2 repeating characters for the 
			// last element in our heap, that means we cannot arrange them in 
			// a way that they are not together so we return an empty string
			if(mp.get(last)>1)
			{
				return "";
			}
			// Otherwise we just add it into our answer
			sb.append(last);
		}

		return sb.toString();
    }



 

    public static int CanRearrangeChars(String s)
    {
        
		    HashMap<Character, Integer> mp = new HashMap<>();
		    for(int i=0; i<s.length(); i++)
		    {
		        if(mp.containsKey(s.charAt(i)))
		        {
		            mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
		        }
		        else
		        {
		            mp.put(s.charAt(i), 1);
		        }
		    }
		    
		    for(int i=0; i<s.length(); i++)
		    {
		        if(mp.get(s.charAt(i))>(s.length()/2)+1)
		        {
		            
		            return 0;
		        }
		    }
		    return 1;
    }


	public static String rearrangeChars(String s)
	{
		int i=0;
		int j = i+1;
		char[] sArray = s.toCharArray();
		while(i<s.length()-1)
		{
			if(sArray[i] == sArray[j])
			{	int flag = 0;
				int k = j;
				while(k<s.length())
				{
					
					if(sArray[j] != sArray[k])
					{
						flag = 1;
						break;
					}
					k++;
				}
				if(flag == 1)
				{
					swap(sArray, j, k);
				}
				else
				{
					return "-1";
				}
		}
		else
		{
			i += 1;
			j=i+1;
		}
	}

	String res = String.valueOf(sArray);
	return res;
	}
	private static void swap(char[] sArray, int i, int j)
	{
		char temp = sArray[i];
		sArray[i] = sArray[j];
		sArray[j] = temp;
	}

	public static Pair2[] mostFreq(String s)
	{
		HashMap<Character, Integer> mp = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			if(mp.containsKey(s.charAt(i)))
			{
				mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
			}
			else
			{
				mp.put(s.charAt(i), 1);	
			}
		}
		int max = Integer.MIN_VALUE;
		char c = '$';
		Pair2[] ans = new Pair2[mp.size()];
		for(int i=0; i<mp.size(); i++)
		{
		Pair2 p = new Pair2(c, max);
		for(int k=0; k<s.length(); k++)
		{
			if(mp.get(s.charAt(k))>max)
			{
				p.c = s.charAt(k);
				p.val = mp.get(s.charAt(k));
				
				ans[i] = p;
			}
		}
		
		}
		System.out.println(mp.size());

		return ans;

	}
	public static String adjChars(String s)
	{
		int del = 0;
		char[] ans = new char[s.length()];
		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);
		s = String.valueOf(sArray);
		boolean [] visited = new boolean[s.length()];
		Arrays.fill(visited, false);
		// First we check for valid
		if (CanRearrangeChars(s)==1)
		{
			// First we put all the most freq occuring characters in alternating positions.
			for(int i=0; i<s.length(); i++)
			{
				if(i%2 == 0 && !visited[i])
				{
					visited[i] = true;
					Pair2 p = mostFreq(s.substring(0, s.length()-del));
					del = p.val;
					while(p.val>0)
					{
					ans[i] = p.c; 
					p.val--;
					}
				}
				else
				{
					if(!visited[i]) { visited[i] = true; ans[i] = s.charAt(i);  } 
				}
			}

			String res = String.valueOf(ans);
			return res;
		}
		else
		{
			return "";
		}


	}

    public static void main(String[] args) {
        String s = "bbbabaaacd";
		String s2 = "aabbbghdfdzziz";
		// for(int i=0; i<adjChars(s2).length(); i++)
		// {
		// 	System.out.print(adjChars(s2).charAt(i) + " ");
		// }
		for(int i=0; i<mostFreq(s2).length; i++)
		{
			System.out.println(mostFreq(s2)[i].c + " " + mostFreq(s2)[i].val);
		}
	}
}

class Pair2
{
	char c;
	int val;
	public Pair2(char c, int val)
	{
		this.c = c;
		this.val = val;
	}
}
