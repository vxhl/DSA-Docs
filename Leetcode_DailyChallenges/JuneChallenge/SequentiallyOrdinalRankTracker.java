class SORTracker {

    /*
    Ok here is what I have uncovered so far
    We can use a TreeMap kind of a structure inorder to sort the records in sequential order accoridng to the score that
    we have
    
    What we need to uncover is the fact that we need to do the records in lexiocgraphically sorted order
    How do we do that? 
    
    Is there a way to store in the TreeMap in lexicographical order? 
    
    */
    
    // We will be using a TreeMap to store the elements in sorted order according to their ranks from top to bottom
    private TreeMap<Integer, List<String>> mp;
    
    // We have the queryCount for counting the number of times that the get method is invoked
    private int queryCount = 0;

    // We intialise TreeMap with a reversed order
    public SORTracker() {
        mp = new TreeMap<>(Collections.reverseOrder());        
    }
    
    
    public void add(String name, int score) {
        // We first put in the list for the current score
        mp.putIfAbsent(score, new ArrayList<>());
        
        // We assign a locationList with the new ArrayList
        List<String> locationList = mp.get(score);
        
        // If our locationList's size is 0 we simply add 1 name to it no need to check for lexicographical orders
        if(locationList.size() == 0)
        {
            locationList.add(name);
        }
        
        // Otherwise we invoke the helper method, that compare all the strings in ArrayList with the current name that we have and asign it a index
        // We can easily check for this index using binary search and the .compareTo method for Strings that check for the difference lexiocgraphically between two string
        // Example: If str1 is lexicographically greter than str2 in that case we get a positive value, otherwise we get a negative value and 0 if it is equal
        
        else
        {
            int i = lexicoInsert(locationList, name);
            locationList.add(i, name);
        }
        
        // In the end after putting in the values, we just add the list of strings into our arraylist
        mp.put(score, locationList);
    }
    
    
    public String get() {
        // First we set a temp variable for the current queryCount
        int search = queryCount;
        String res = "";
        
        // We traverse for the keys in the map from the greatest to the smallest score
        for(int score: mp.keySet())
        {
            // If we find the our current score has greater than the rank that we need, that means our answers lies in this list itself so we simpy get the search index from the list
            if(search<mp.get(score).size())
            {
                res = mp.get(score).get(search);
                break;
            }
            else
            {
                // If we don't we simply decrement our search space with whatever our number of elements in the current rank are
                search -= mp.get(score).size(); 
            }
        }
        // We increment the query count as well
        this.queryCount++;
        
        return res;
    }
    
    private int lexicoInsert(List<String> list, String t)
    {
        // We use binary search inorder to store the current string in the list where the index has it ordered lexicographically
        int left = 0;
        int right = list.size()-1;
        
        
        while(left<right)
        {
            // We get the mid
            int mid = left+(right-left)/2;
            // If we find that our current string is greater lexicolly compared to our string at mid, we simply start searching on the right side so left=mid+1
            if(list.get(mid).compareTo(t)<0)
            {
                left = mid+1;
            }
            // Otherwise we search on the left side
            else
            {
                right = mid;
            }
        }
        // If we find the string at our left index to be greater or equal we can 
        return list.get(left).compareTo(t)>=0 ? left: left+1;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */