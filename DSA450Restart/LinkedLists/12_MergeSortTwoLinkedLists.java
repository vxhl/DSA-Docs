package DSA450Restart.LinkedLists;
import java.util.*;

class MergeSortTwoLinkedLists {
    static ListNode mergeSort(ListNode head)
    {
        // add your code here
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode mid = findMid(head);
        
        ListNode left = head;
        ListNode right = mid.next;
        // By doing mid.next as null we break the links and make two
        // linkedlists left and right
        mid.next = null;
        
        // Recursive calls to sort both halves
        left = mergeSort(left);
        right = mergeSort(right);
        
        // Merging both left and right halves
        
        ListNode res = merge(left, right);
        
        return res;
        
    }
    
    static ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static ListNode merge(ListNode head1, ListNode head2)
    {
        
        if(head1==null) return head2;
        if(head2 == null) return head1;
        
        if(head1.val
         > head2.val
        )
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
            
            while(head1!=null && head1.val
            <=head2.val
            )
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
}
