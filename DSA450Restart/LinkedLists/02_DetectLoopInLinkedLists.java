package DSA450Restart.LinkedLists;

class DetectLoops {
    public boolean hasCycle(ListNode head) {
        
        // So understanding this problem all depends on coming up with the formula
        // We have two pointers slow and fast, where fast moves twice the speed of slow
        ListNode slow = head;
        ListNode fast = head;
    
        
        int flag = 0;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            // If we find slow to be equal to fast than we just break 
            // If we never find this that means a loop does not exist so we check if our flag
            // is 0 and we return false, otherwise we go on with the next step.
            if(slow==fast)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
        {
            return false;
        }
        
        // Now we set another node from the start of the linkedlist
        // and move it in the same speed as our slow pointer until they meet
        ListNode start = head;
        ListNode prev = null;
        while(start!=slow)
        {
            prev = start;
            start = start.next;
            slow = slow.next;
        }
        prev.next = null;
        if(start==slow)
        {
            return true;
        }
        return false;
        
    }
}