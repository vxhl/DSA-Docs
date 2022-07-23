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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
        Without using a dummyNode
        */
        
        if(head == null)
        {
            return null;
        }
        
        ListNode curr = head, prev = null;
        
        // So we just iterate till the start position
        while(left>1)
        {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        // We then store the previous pointer to make the final connection
        // We also store the point where our current node is at
        ListNode finalConnection = prev, tail = curr;
        ListNode next = null;
        
        // We then iterate for the rest of the list till the right position
        while(right>0)
        {
            // We keep reversing as we usually do
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        
        // If we find our final connection to be not null
        // We point our finalConnetion to the prev after the reversal is over
        if (finalConnection!=null)
        {
            finalConnection.next = prev;
        }
        else
        {
            head = prev;
        }
        // Our tail.next will then point to our current since we need to connect back all the links on both sides
        // Basically tail is the start of the point where we start our reversal and curr is at the point after we exceed the right boundary
        // so our starting pointer should point to the boundary 
        tail.next = curr;
        return head;
    }
}