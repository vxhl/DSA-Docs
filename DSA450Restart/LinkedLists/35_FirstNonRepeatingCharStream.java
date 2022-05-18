package DSA450Restart.LinkedLists;
import java.util.*;
class FirstNonRepeatingCharStream {
    public String FirstNonRepeating(String A)
    {
        // code here
        int MAX_CHARS = 26;
        int[] freq = new int[MAX_CHARS];
        Arrays.fill(freq,0);
        
        Queue<Character> q = new LinkedList<>();
        // First we add all the characters into our queue
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++)
        {
            // We first push the first character into the queue
            q.add(A.charAt(i));
            freq[A.charAt(i)-97]++;
            
            while(!q.isEmpty() && freq[q.peek()-97]!=1)
            {
                q.poll();
            }
            if(!q.isEmpty())
            {
                sb.append(q.peek());
            }
            else
            {
                sb.append('#');
            }
        }
        return sb.toString();
        
    }
}
