package DSA450Restart.LinkedLists;


class ListNode {
    int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
         class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 =  head;
        ListNode p2 = head;
        ListNode curr = head;
        int count = 1;
        
        while(curr!=null)
        {
            if(count<k)
            {
                p1 = p1.next;

            }
            if(count>k)
            {
                p2 = p2.next;
            }
            count++;
            curr = curr.next;
        
        }
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
        // Why tf would this work and the other one won't? It doesn't make sense
        
        return head;
    
    
    }
}
