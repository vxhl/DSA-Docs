package DSA450Restart.LinkedLists;

class CheckPalindromeSinglyLinkedLists {
    public static ListNode reverse(ListNode node)
    {
        
        ListNode curr = node, next = null, prev = null;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        node = prev;
        return node;
    }
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return true;
        }
        
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode revPart = reverse(slow.next);
        ListNode temp = head;
        
        while(revPart!=null)
        {
            if(revPart.val!=temp.val)
            {
                return false;
            }
            revPart = revPart.next;
            temp = temp.next;
        }
        
        return true;
        
    }
}
