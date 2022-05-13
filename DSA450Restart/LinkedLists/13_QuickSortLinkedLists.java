package DSA450Restart.LinkedLists;


class ListNode
{
    int val;
    ListNode next;
    public ListNode(int val)
    {
        this.val = val;
    }
}
class quicksortLL
{
    // This problem falls on the hard side so be aware that it is fine if you don't get it immediately.
    // Just keep making notes and keep dry running until you figure it out, don't block the process let it flow,
    // be water my friend. 

    public static ListNode partition(ListNode head)
    {
        // During partition we take the pivot and have a current and previous pointers inorder to keep track of the swaps right
        ListNode pivot = head;
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr!=null)
        {
            if(curr.val<pivot.val)
            {
                // Now we simply swap our values
                int tmp = curr.val;
                curr.val = prev.val;
                prev.val = tmp;
                prev = prev.next;
            }
            curr = curr.next;
        }

        // once we swap our pivot and our prev
        int tmp = prev.val;
        prev.val = pivot.val;
        pivot.val = tmp;


        return prev;
    }


    public static ListNode quicksort(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode pivot = partition(head);
        // We store the reference so we do not lose it
        ListNode temp = pivot.next;
        // Now let us get the two parts of the node on which we will apply our quicksort
        // first let us break the linkedlist
        pivot.next = null;
        // Doing this applies our quicksort till the pivot
        quicksort(head);
        // Doing this applies quicksort from pivot.next to end so we have these two parts to apply our operations on
        quicksort(temp);
        // We now link back our nodes
        pivot.next = temp;

        return head;


    }
}