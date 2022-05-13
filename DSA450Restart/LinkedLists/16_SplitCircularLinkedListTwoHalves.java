package DSA450Restart.LinkedLists;

class SplitCircularLinkedListTwoHalves 
{
    public static void splitHalves(ListNode head, ListNode head1, ListNode head2)
    {
        // Ok we need to split the two linkedlists in such a way that the new two linkedlists are also circular

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=head && fast.next != head)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Once we are done traversing, we have slow pointer as the middle right
        // the first half will have all nodes from head to slow as it's nodes
        // The second half will have all nodes from slow.next to the end
        
        // We have our first half
        head1 = head;
        // We define our second half's head
        head2 = slow.next;
        // We make the first half circular
        slow.next = head1;
        
        ListNode curr = head2;

        // We reach the end of our given list and when we find the point of circulation we change the reference to our head2
        // thus making the second half circular as well
        while(curr.next!=head)
        {
            curr = curr.next;
        }
        curr.next = head2;
        
    }    
}
