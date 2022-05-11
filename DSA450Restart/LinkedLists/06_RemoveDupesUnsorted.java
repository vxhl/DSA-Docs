package DSA450Restart.LinkedLists;
import java.util.*;
class RemoveDupesUnsorted {
    public ListNode removeDuplicates(ListNode head) 
    {
          // Your code here
        HashSet<Integer> hs = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        // ListNode next = null;

        while(curr!=null)
        {
            int currVal = curr.val;
            if(!hs.contains(currVal))
            {
                hs.add(currVal);
                prev = curr;
            }
            else
            {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return head;
         
    }
}
