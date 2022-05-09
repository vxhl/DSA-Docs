package Leetcode_DailyChallenges.MayChallenge;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class NestedIterator implements Iterator<Integer> {
    List<Integer> flattenList = null;
    int current = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();

        // For each of the value present in nestedlist we have the helper method where
        // we pass int the integer
        for (NestedInteger integer : nestedList) {
            helper(integer);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(current++);
    }

    @Override
    public boolean hasNext() {
        // If our current index is smaller than our last elements index that means
        // we still have elements but if equal or greater we simply return false
        return current < flattenList.size();
    }

    // This helper method checks whether the current value is an integer or list and
    // adds the values accordingly
    private void helper(NestedInteger value) {
        if (value.isInteger()) {
            flattenList.add(value.getInteger());
        } else {
            for (NestedInteger integer : value.getList()) {
                helper(integer);
            }
        }
    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */