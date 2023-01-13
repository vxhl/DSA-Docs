class Solution {
    // Recursively reverse a linked list
    public ListNode reverseList(ListNode head) {
       return helper(head, null);
    }
    private ListNode helper(ListNode head, ListNode newHead){
        if(head==null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return helper(next, head);
    }
}