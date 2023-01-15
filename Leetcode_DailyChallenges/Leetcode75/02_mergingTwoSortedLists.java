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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // merging together the two linkedlists okkkk
      
      ListNode curr1 = list1;
      ListNode curr2 = list2;
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;
      while(curr1!=null && curr2!=null){
          if(curr1.val<curr2.val){
              curr.next = curr1;
              curr1 = curr1.next;
              curr = curr.next;
          }else{
              curr.next = curr2;
              curr2 = curr2.next;
              curr = curr.next;
          }
      }
      while(curr1!=null){
          curr.next = curr1;
          curr1 = curr1.next;
          curr = curr.next;
      }
      while(curr2!=null){
          curr.next = curr2;
          curr2 = curr2.next;
          curr = curr.next;
      }
      
      return dummy.next;

    }
    
    // Recursive
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // merging together the two linkedlists okkkk
        if(list1==null) return list2;
        if(list2==null) return list1;
  
        if(list1.val<=list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
  
      }
}