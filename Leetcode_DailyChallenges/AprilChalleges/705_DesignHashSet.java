package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class MyHashSet
{
    // We are given MAX_VALUE assumption so we take that constant
    private final int MAX_VALUE = 1000000;
    // We set the arraysize for the linkedlist
    private final int ARRAY_SIZE = 100;
    // What is the parentlist? It is the list of buckets and inside it we have
    // the list of the linkedlists that are repeated from collisions
    private List<List<Integer>> parentList;
    public MyHashSet()
    {
        // We initially set the size of the the ArrayList<>
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0; i<ARRAY_SIZE; i++)
        {
            // We also initialise our inner linkedlists as null initially
            parentList.add(null);
        }

    }

    public void add(int key)
    {
        // We map it to a bucket in our arraylist
        int index = key % ARRAY_SIZE;
        // We then check the childList in that index 
        List<Integer> childList = parentList.get(index);
        // If we find it as null, meaning the current element has
        // not been added to our hashset then we add the element and create
        // a new linkedlist following the element
        if(childList == null)
        {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            // We then add the list to the index in our parentlist
            parentList.set(index, list);
        }
        // If we already have added a value into the index
        else
        {
            if(!childList.contains(key))
            {
                childList.add(key);
            }
        }
    }

    public void remove(int key)
    {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList!=null)
        {
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key)
    {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList!=null)
        {
            if(!childList.contains(key))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}