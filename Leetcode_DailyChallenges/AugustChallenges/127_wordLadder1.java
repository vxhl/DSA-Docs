import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        // We first put all the elements inside the set
        for(String w: wordList){
            set.add(w);
        }
        q.offer(beginWord);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();    
            while(size-->0){
                // So we take the string out and check for all the combinations from 0->26 for lowecase letters
                String curr = q.poll();
                if(curr.equals(endWord)) return ans+1;
                // For transforming each and every letter and checking
                for(int i=0; i<curr.length(); i++){
                    for(int k='a'; k<='z'; k++){
                        char arr[] = curr.toCharArray();
                        arr[i] = (char)k;
                        String str = new String(arr);
                        // We then check if the current word is in the set, if it is then we add into the queue and 
                        // remove it from the set
                        if(set.contains(str)){
                            q.add(str);
                            set.remove(str);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
    
}