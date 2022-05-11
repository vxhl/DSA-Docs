package DSA450Restart.LinkedLists;

class IntersectionUnsorted
{
    public static int length(ListNode head)
    {
        int count = 0;
        ListNode curr = head;
        while(curr!=null)
        {
            count++;
            curr = curr.next;
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
        int diff = length(headA) - length(headB);
        // System.out.print(diff);
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while(diff!=0)
        {
            diff--;
            curr1 = curr1.next;  
        }
        System.out.println(curr1.val);
        System.out.println(curr2.val);
        while(curr1!=null || curr2!=null)
        {
            if(curr1 == curr2)
            {
                System.out.println(curr2.val);
                return curr2;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
        
        
    }
}