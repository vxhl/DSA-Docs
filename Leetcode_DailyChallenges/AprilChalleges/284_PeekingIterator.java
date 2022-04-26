package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;


class PeekingIterator implements Iterator<Integer> {
    // So first we define a public iterator object
	private Iterator<Integer> itr = null;
    // And also the integer for performing our operations
    private Integer nextVal = null;
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        // We nake our constructor and assign iterator to the globally made iterator
	    itr = iterator;
        // And If our hasNext is true for the iterator at present
        // We set our nextVal integer to our pointer
        if(itr.hasNext()) nextVal = itr.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        // We simply return the current element in the iterator
        return nextVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        // Since we need to move our pointer forward
        // we first store the current element in a temp variable
	    Integer val  =nextVal;
        // And then we check if we have any next elements/
        // if we do we simply move the pointer forward
        // otherwise we just set it as null
        if(itr.hasNext())
        {
            nextVal = itr.next();
        }
        else
        {
            nextVal = null;
        }
        return val;
	}
	
	@Override
	public boolean hasNext() {
        // We simply return whether we have
	    return nextVal != null || itr.hasNext();
	}
}