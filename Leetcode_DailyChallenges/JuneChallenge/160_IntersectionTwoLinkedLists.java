/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static int length(ListNode head)
    {
        int count = 0;
        while(head!=null)
        {
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(length(headA)<length(headB))
        {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        
        int skips = length(headA) - length(headB);
        
        ListNode curr = headA;    
        while(skips!=0)
        {
            curr = curr.next;
            skips--;
        }
        
        ListNode curr2 = headB;
        
        while(curr!=null && curr2!=null)
        {
            if(curr==curr2)
            {
                return curr;
            }
            curr = curr.next;
            curr2 = curr2.next;
            
        }
        
        return null;
        
    }
}