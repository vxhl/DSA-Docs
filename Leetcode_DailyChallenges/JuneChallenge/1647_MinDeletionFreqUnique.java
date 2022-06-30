import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minDeletions(String s) {
        int ans = 0;
        // For storing the count of the letters in our string
        int[] freq = new int[26];
        
        for(int i=0; i<s.length(); i++)
        {
            // Since we need to only consider the smaller elements
            ++freq[s.charAt(i)-'a'];
        }
        
        Set<Integer> uniqueFrequencies = new HashSet<>();
        for(int i=0; i<26; i++)
        {
            while(freq[i]>0 && !uniqueFrequencies .add(freq[i]))
            {
                freq[i]--;
                ans++;
            }
            uniqueFrequencies.add(freq[i]);
        }
        
        return ans;
    }

    public int minDeletionsApproach2(String s)
    {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            // Since we need to only consider the smaller elements
            ++freq[s.charAt(i)-'a'];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++)
        {
            if(freq[i]!=0)
            {
                maxHeap.add(freq[i]);
            }
        }
        int deletionCount = 0;
        while(!maxHeap.isEmpty())
        {
            int curr = maxHeap.poll();
            if(curr == maxHeap.peek())
            {
                curr--;
                maxHeap.add(curr);
                deletionCount++;
            }
        }

        return deletionCount;


    }

    public int minDeletions2(String s) {
        
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            // Since we need to only consider the smaller elements
            ++freq[s.charAt(i)-'a'];
        }

        // In our maxHeap we will be storing the count of the characters int he string
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++)
        {
            if(freq[i]!=0)
            {
                maxHeap.add(freq[i]);
            }
        }
        int deletionCount = 0;
        while(!maxHeap.isEmpty())
        {
            // We pop our current top and compare it with the new top
            int curr = maxHeap.poll();
            if(!maxHeap.isEmpty() && curr == maxHeap.peek())
            {
                // If we find it to be equal it ofc means that we have a non-unique freq count
                // so we reduce our current freq count and add it back into our heap
                // we keep doing this until our heap is not empty
                curr--;
                deletionCount++;
                if(curr>0) maxHeap.add(curr);
            }
    
        }

        return deletionCount;


    }
}