
class ListNode
{
    ListNode next;
    int val;
    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }
}
public class ReverseAlternateKNodes 
{
    ListNode reverseAlternateKNodes(ListNode head, int k)
    {
        ListNode curr = head, prev = null, next = null;

        int count = 0;

        while(curr!=null && count<k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(A!=null)
        {
            A.next = curr;
        }

        count = 0;

        while(count<k && curr!=null)
        {
            curr = curr.next;
            count++;
        }

        if(curr!=null)
        {
            curr.next = reverseAlternateKNodes(curr.next, k);
        }

        return prev;
    }
}
