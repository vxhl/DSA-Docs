package DSA450Restart.LinkedLists;

class DeletionReverseCLL {
    //This method returns the head of the LL after deleting node with value d.
    public static ListNode deleteNode(ListNode head,int d)
    {
        //Add your code here.
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr.next!=head)
        {
            if(curr.val == d)
            {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    //This method returns the head node of the reversed Linked list.
    public static ListNode reverse(ListNode head)
    {
        //Add your code here
        if(head == null)
        {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        
        do
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while(curr!=head);
        
        head.next = prev;
        return prev;
    }
}
