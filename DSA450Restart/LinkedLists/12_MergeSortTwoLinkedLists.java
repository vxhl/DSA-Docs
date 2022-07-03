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



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    private int length(ListNode head)
    {
        int count = 0;
        
        while(head!=null)
        {
            head = head.next;
            count++;
        }
        
        return count;
    }
    // Iterative approach for sorting two linked lists using merge sort
    public ListNode sortList(ListNode head) {
        
        if(head == null)
        {
            return head;
        }
        
        // Ok so for this approach there are quite a few things to consider
        /*
        1. When doing bottom up merge, we are merging first 1 element with another and
        then we move on to mergin 2 elements with another two and so on till we reach the size
        of our given input list
        
        So in bottom up approach, we will be considering these windows, we will start from
        1 then 2 then 4 then 6 and so on till we reach the size of our input list
        
        Since this is linkedlist merge, there is quite a lot of tracking to do in terms of pointers
        and taking care of references that we may lose out on. So I will be commenting on each and every line
        as we explain through this
        */
        
        // First we define the start and end for the two linkedlists that we are merging for the current range
        ListNode start1 = null;
        ListNode end1 = null;
        ListNode start2 = null;
        ListNode end2 = null;
        ListNode previousEnd = null;
        // We then define the length of the linkedlist where our range will lie
        int len = length(head);
        
        // We traverse exponentially by 2 times 
        for(int gap=1; gap<len; gap=gap*2)
        {
            // First ofc we merge all the nodes of length 1 together
            start1 = head;
            
            while(start1!=null)
            {
                boolean isFirstIteration = false;
                if(start1 == head)
                {
                    isFirstIteration = true;
                }
                
                // In the first iteration our counter is 1
                int counter = gap;
                end1 = start1;
                
                // We get the range for our first subList
                while(--counter>0 && end1.next!=null)
                {
                    end1 = end1.next;
                }
                // Now our second linkedlist will start from the end of the first one so 
                start2 = end1.next; 
                
                if(start2 == null) 
                {
                    break;
                }
                counter = gap;
                end2 = start2;
                while(--counter>0 && end2.next!=null)
                {
                    end2 = end2.next;
                }
                
                ListNode next = end2.next;
                
                merge(start1, end1, start2, end2);
                
                if(isFirstIteration)
                {
                    head = start1;
                }
                else
                {
                    previousEnd.next = start1;
                }
                
                // We then store the reference for where our previous merge ended
                previousEnd = end2;
                // And we move our start1 ahead using the reference that we store for end2.next
                start1 = next;
            }
            
            // This is the only step i am super hazy on so let's make a dry run for this
            previousEnd.next = start1;
        }
        return head;
        
    }
    
    private ListNode merge(ListNode start1, ListNode end1, ListNode start2, ListNode end2)
    {
        ListNode temp = null;
        if ((start1).val > (start2).val)
        {
            ListNode t = start1;
            start1 = start2;
            start2 = t;
            t = end1;
            end1 = end2;
            end2 = t;
        }
 
        // Merging remaining nodes
        ListNode astart = start1, aend = end1;
        ListNode bstart = start2, bend = end2;
        ListNode bendnext = (end2).next;
        while (astart != aend && bstart != bendnext)
        {
            if (astart.next.val > bstart.val)
            {
                temp = bstart.next;
                bstart.next = astart.next;
                astart.next = bstart;
                bstart = temp;
            }
            astart = astart.next;
        }
        if (astart == aend)
            astart.next = bstart;
        else
            end2 = end1;

        return start1;

    }
    
}