package DSA450Restart.LinkedLists;
import java.util.*;
class RemoveDupes
{
    ListNode removeDuplicates(ListNode head)
    {
	    // Your code here	
	    Set<ListNode> set = new HashSet<>();
	    ListNode curr = head;
	    ListNode next = null;
	    while(curr!=null && curr.next!=null)
	    {
	        if(curr.val == curr.next.val)
	        {
	            next = curr.next.next;
	            if(next == null)
	            {
	                curr.next = null;
	                break;
	            }
	            else
	            {
	                curr.next = next;
	            }
	        }
	        else
	        {
	            curr = curr.next;
	        }
	    }
	    return head;
	    
    }
}