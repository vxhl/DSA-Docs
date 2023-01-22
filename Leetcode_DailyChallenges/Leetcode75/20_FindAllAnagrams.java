class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // For the actual result
        List<Integer> result = new LinkedList<>();
        if(p.length()>s.length()) return result;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int i = 0, j = 0;
        int lead = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(j < s.length()){
            char c = s.charAt(j);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                // Whenever we eliminate all the characters from ht map, we reduce our counter which is the size of the map
                if(map.get(c) == 0) counter--;
            }
            // And we move ahead
            j++;

            // If we find all the characters eliminated from the map 
            while(counter == 0){
                // We now start moving from the left side
                char tempc = s.charAt(i);
                // If our map contains the character at the window start
                if(map.containsKey(tempc)){
                    // We simply increment the window
                    map.put(tempc, map.get(tempc) + 1);
                    // And when it becomes non negative we increase our counter as well
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }

                // So in other words, we only add to the result when we find that our window size is what we want and the counter is 0 as well
                // that is when we add i, and then increment i to search for our next substring. 
                if(j-i == p.length()){
                    result.add(i);
                }
                i++;
            }
            
        }
        return result;
    }
}