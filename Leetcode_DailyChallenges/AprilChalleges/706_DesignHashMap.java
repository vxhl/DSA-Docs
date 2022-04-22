package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;



class MyHashMap
{
    // Ok let's implement this on our own and write down what we understand and do not understand
    // we have 3 methods
    public static int size = 769;
    // We take a array that contains linkedlists of our object
    // Now why do we take a linkedlist? It is for handling collisions when we find elements that are of same values, something like that
    LinkedList<Pair>[] map;
    public MyHashMap()
    {
        map = new LinkedList[size];
    }

    public int get(int key)
    {   
        // First we get the hashcode for the bucket in which our key may be located
        int bucket = key%size;
        // We get the linkedlist for our current index
        LinkedList<Pair> pairs = map[bucket];
        if(pairs == null) return -1;
        // We then search in all the pairs in the given bucket(remember the analogy that our bucket is the linkedlist and it contains all our pairs)
        for(Pair p: pairs)
        {
            // if we find our key we return it
            if(p.key == key)
            {
                return p.val;
            }

        }
        // Otherwise we return -1
        return -1;

    }
    public void remove(int key)
    {
        int bucket = key%size;
        // We initially set the Pair that we have to remove as null since we do not know if it exists yet or not
        Pair toRemove = null;
        if(map[bucket] == null)
        {
            return;
        }
        else
        {
            // We loop through our bucket looking for the key
            for(Pair p: map[bucket])
            {
                // If we find the key
                if(p.key == key)
                {
                    toRemove = p;
                }
            }
            if(toRemove == null) return;
            map[bucket].remove(toRemove);
        }

    }

    public void put(int key, int value)
    {
        int bucket = key%size;
        if(map[bucket] == null)
        {
            map[bucket] = new LinkedList<Pair>();
            map[bucket].add(new Pair(key, value));
        }
        else
        {
            for(Pair p: map[bucket])
            {
                if(p.key == key)
                {
                    p.val = value;
                    return;
                }

            }

            map[bucket].add(new Pair(key, value));
        }   

    }


}

class Pair
{
    public int val;
    public int key;
    public Pair(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */