package Leetcode_DailyChallenges.MayChallenge;

import java.util.*;

class MyStack {
    
    
    Queue<Integer> st;
    public MyStack() {
        st = new LinkedList<>();
    }
    
    public void push(int x) {
        st.add(x);
        for(int i=0; i<st.size()-1; i++)
        {
            st.add(st.peek());
            st.poll();
        }
    }
    
    public int pop() {
        return st.poll();
    }
    
    public int top() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}
