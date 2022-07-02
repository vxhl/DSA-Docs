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


// Adding Doubly Linked List Implementation for the same
class LRUCache3 {
    
    // Our Doubly Linked List holds both the key and the value together 
    private class Node
    {  
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
        // For initialising a dummy node
        Node(){}
    }
    
    // Our hashmap holds both the key and the Node holding the key
    Map<Integer, Node> mp;
    int capacity;
    // We use count to track the capacity of our Cache
    int count;

    // We initialise the doubly linked list first
    private Node head, tail;

    public LRUCache3(int capacity) {
        mp = new HashMap<>();
        // So we maintain a doubly linked list
        // head and tail are two dummy nodes with 0 as their values
        
        // dummy head and tail nodes initialised and referenced
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        // We initalise our cache having 0 entries
        count = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // We get the node from the map, and check if it is null
        // Since HashMap can hold null values this does not throw and exception
        Node curr = mp.get(key);
        if(curr!=null)
        {
            // If we have the node we update it
            update(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node curr = mp.get(key);
        // If we alredy have it in the linkedlist
        if(curr!=null)
        {
            // We simply update the value
            curr.val = value;
            // And set it back to head
            update(curr);
        }
        else
        {
            // If we don't have it we form a new node with the given key and value
            curr = new Node(key, value);
            // We put the node and key into the map
            mp.put(key, curr);
            // And then add it to the head of the linkedlist thus making it MRU
            add(curr);
            // We update the size of our cache here
            count++;
        }

        // if we find our curr cache to be greater than the capacity
        if(count>capacity)
        {
            // Our node that is at the tail of the linkedlist becomes the LRU so we point to it
            Node toRemove = tail.prev;
            // And then we remove it
            remove(toRemove);
            // We also simultaneously remove it from the HashMap
            mp.remove(toRemove.key);
            // And we reset the size of our cache back to what it initially was before overflowing.
            count--;
        }
    }
    
    // Our update method simply remove the node from wherever it is and adds it to the head of the linkedlist
    private void update(Node node)
    {
        remove(node);
        add(node);
    }
    

    private void add(Node node)
    {
        // Our add operation adds the node to the start of our linked list
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node)
    {
        // Our remove removes the element from the linked list if it cointains it
        // We can easily access the node since we are storing it everytime inside the hashmap so there is no need to iterate the linkedlist and find the 
        // node for deletion.
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}
