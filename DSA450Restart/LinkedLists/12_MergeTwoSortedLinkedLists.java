package DSA450Restart.LinkedLists;
import java.util.*;


class MergeTwoSortedLinkedLists {



    // Approach 2: Using Swapping and localpointers in constant space
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // We will be using the optimised no extra space method
        
        if(head1==null) return head2;
        if(head2 == null) return head1;
        
        if(head1.val > head2.val)
        {
            ListNode t = head1;
            head1 = head2;
            head2 = t;
        }
        
        ListNode res = head1;
        
        while(head1!=null && head2!=null)
        {
            // We have this temporary node inorder to keep track of our nodes in the head1 side and changing references to head2
            ListNode temp = null;
            
            while(head1!=null && head1.val<=head2.val)
            {
                // We keep running this loop till we find greater elements in our head1
                // if we don't then in the end we just link our temp to head2 and return our answer
                temp = head1;
                head1 = head1.next;
            }
            temp.next = head2;
            
            ListNode tmp = head1;
            head1 = head2;
            head2 = tmp;
        }
        
        return res;
        
        
    }

    // Approach 1: Using this appraoch we have an extra linkedlist node
    ListNode sortedMerge(ListNode curr1, ListNode curr2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        // Ok now we have to move our two linkedlists and check for which one is smaller, once we find a smaller one
        // we add it into our new linkedlist and then move our node forward
        while(true)
        {
            if(curr1 == null)
            {
                res.next = curr2;
                break;
            }
            if(curr2 == null)
            {
                res.next = curr1;
                break;
            }
            
            if(curr1.val <= curr2.val)
            { 
                res.next = curr1;
                curr1 = curr1.next;
            }
            else
            {
                res.next = curr2;
                curr2 = curr2.next;
            }
            
            res = res.next;
        }
        return dummy.next;
   } 


   
}
