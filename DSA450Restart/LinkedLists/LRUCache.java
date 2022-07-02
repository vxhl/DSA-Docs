class LRUCache {

    // We define our q for the actual result
    Deque<Integer> q = new LinkedList<>();
    // We have the map for easier extraction
    Map<Integer, Integer> mp = new HashMap<>();
    int capacity = 0;
    
    // We initialise whatever our capacity is
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    // We first do the get key thing which is possible with the map if it does contain
    public int get(int key) {
        // If our map contains the thing, then and only then do we return mp.get(key)
        if(mp.containsKey(key))
        {
            // Pair p = new Pair(key, mp.get(key));
            q.remove(key); 
            q.offer(key);
            return mp.get(key);
        }
        else
        {
        return -1;
        }
    }
    int i = 0;
    public void put(int key, int value) {
        i++;
        // We first check whether the current key is in our queue
        if(mp.containsKey(key))
        {
            mp.put(key, value);
            // We delete the previous entry
            q.remove(key);
            // And we add the latest entry thus making it the MRU
            q.offer(key);
            // And we update the value in the map as well
            
        }
        else
        {
            // If we find our capacity to exceed we evict the least recently used from the top
            // of the queue
            // And then we add the current new Pair into the queue, thus making it the MRU
            if(q.size()<capacity) q.add(key);
            // And we also update the corresponding values in the map for extraction
            
            else
            {
                mp.remove(q.poll());
                // System.out.print(i+ ". polled " + q.peek().key + "key |");
                q.add(key);
            }
            mp.put(key,value);
        }
        
    }
}


class LRUCache2 {
    private LinkedHashMap<Integer, Integer> mp;
    int capacity = 0;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        mp = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size()>capacity;
            }
        };
    }
    
    public int get(int key) {
        return mp.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        mp.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */