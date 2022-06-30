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
   public ListNode reverseKGroup(ListNode head, int k) {
       if(head == null) return null;
       ListNode prev = null, curr = head, next = null;
       int k1 = 0;
       // Reverse till our k1 is not equal to k
       while(curr!=null && k1!=k){
           k1++;
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       
       /* Using temp node check whether we still have nodes greater than k
       If we do, we break and recursively reverse the next k groups
       if we don't we point our head.next to our next count of nodes smaller than k and return prev */
           
       ListNode temp = null;
       if(next!=null) temp = next;
       int i = 0;
       
       while(i!=k && temp!=null){
           temp = temp.next;
           i++;
           
           if(temp == null && i<k){
               head.next = next;
               return prev;
           }
           else if(i==k){
               break;
           }
       }
       // If the above while loop does not satisfy the condtions and we break, then we reverse the k groups recursively
       head.next = reverseKGroup(next, k);
       // And finally return the prev from our first k group that we reversed to get the head of the answer
       return prev;
   }
}
