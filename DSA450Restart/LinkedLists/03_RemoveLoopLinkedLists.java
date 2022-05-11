package DSA450Restart.LinkedLists;

class RemoveLoopLinkedLists {
    public static void removeLoop(ListNode head){
        // code here
        // remove the loop without losing any nodes
        if(head.next == head)
        {
            head.next = null;
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow.next == head)
            {
                slow.next = null;
                return;
            }
            
            if(slow == fast)
            {
                slow = head;
                while(slow.next!=fast.next)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                return;
            }
        }
        return;
    }   
}
