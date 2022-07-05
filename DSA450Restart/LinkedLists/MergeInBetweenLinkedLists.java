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
   int length(ListNode head)
   {
       int count = 0;
       while(head!=null)
       {
           head = head.next;
           count++;
       }
       return count;
   }
   /*
       We are given two linked lists list1 and list2
       We are to remove list1's nodes from the ath node to the bth node and put list2 in their place
       */
       
       /*
       prev , curr
       so our curr moves ahead and our previous keeps getting updated as curr
       So travese for a times in list1
               
       1 2 3 -> 1001 -> 1002 -> 1003
       
       a = 3    b = 6
       so we are removing till b
       so we traverse from the curr for b-a times
       6 - 3 = (3-1) times

          curr
           |
       4 5 6 7 8 
       So store the reference for the node next to curr in a next variable
       next = curr.next;
       
       Now we can just traverse till the end of the 2nd list and then point it to the next variable
       But before doing that we will make curr.next = null
       1001 1002 1003
       
       */
   
   
   public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
       // Edge cases 
       if(list1 == null){
         return null;
       }
       if(a==0 && b==length(list1)){
           return list2;    
       }
       
       if(a>b) {
           return null;
       }
       
       if(list2 == null){
           return list1;
       }
       
       // Main Code
       ListNode curr = list1;
       ListNode prev = null;
       int currA = a;
       while(currA>0){
           prev = curr;
           curr = curr.next;
           currA--;
       }
       
       // So we point the previous to our second list's head
       prev.next = list2;
       int remPos = b-a;
       
       ListNode prev2 = null;
       for(int i=0; i<=b-a+1 && curr!=null; i++){
           prev2 = curr;
           curr = curr.next;
       }
       ListNode curr2 = list2;
       ListNode prev3 = null;
       
       while(curr2!=null){
           prev3 = curr2;
           curr2 = curr2.next;
       }
       
       prev3.next = prev2;
       
       return list1;
   }
   
   public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
       // Otherwise we can just traverse to the predecessor of the first list
       ListNode start = list1;
       
       for(int i=1; i<a; i++)
       {
           start = start.next;
       }
       
       ListNode end = start.next;
       start.next = list2;
       
       for(int i=0; i<b-a; i++)
       {
           end = end.next;
       }
       
       while(list2.next!=null)
       {
           list2 = list2.next;
       }
       
       list2.next = end.next;
       
       return list1;
   }
}
