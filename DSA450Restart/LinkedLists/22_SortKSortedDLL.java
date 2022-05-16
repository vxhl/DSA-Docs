package DSA450Restart.LinkedLists;
import java.util.*;

class ksorteddll
{
    static class dlnode
    {
        int data;
        dlnode next;
        dlnode prev;
        dlnode(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }
    static class compareNode implements Comparator<dlnode>
    {
        public int compare(dlnode n1, dlnode n2)
        {
            return n1.data-n2.data;
        }
    }

    public static dlnode sortKSortedLinkedList(dlnode head, int x)
    {
        if(head == null) return head;
        PriorityQueue<dlnode> pq = new PriorityQueue<dlnode>(new compareNode());
        // dlnode curr = head;
        dlnode res = null;
        dlnode curr = null;
        for (int i = 0; head != null && i <= x; i++)
        {
            
            // push the node on to 'pq'
            pq.add(head);
        
            // move to the next node
            head = head.next;
        }
        // After doing the above operation the pointer for head arrives at
        // (k+1)th position and in the next iterations we traverse from there
        // dlnode res = new dlnode(0); // our result will be in res.next
        
            while(!pq.isEmpty())
            {
                if(res == null)
                {
                    res = pq.peek();
                    res.prev = null;
                    curr =res;
                }
                else
                {
                    curr.next = pq.peek();
                    pq.peek().prev = curr;
                    curr = pq.peek();
                }
                pq.poll();
                
                if(head!=null)
                {
                    pq.add(head);
                    head = head.next;
                }

            }
            curr.next = null;

        return res;
    }
    static dlnode insert(dlnode head, int data)
    {
        dlnode temp = new dlnode(data);
        
        if(head == null)
        {
            head = temp;
        }
        else
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        return head;
    }
    public static void printList(dlnode head)
    {
        while(head!=null)
        {
            System.out.println("Working");
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        dlnode head = null;
        insert(head, 3);
        insert(head, 6);
        insert(head, 2);
        insert(head, 12);
        insert(head, 56);
        insert(head, 8);
        dlnode sorteddll = sortKSortedLinkedList(head, 2);
        printList(sorteddll);
        System.out.println(sorteddll.data);
    }
}
