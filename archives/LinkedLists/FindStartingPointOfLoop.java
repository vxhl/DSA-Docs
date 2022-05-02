package LinkedLists;

public class FindStartingPointOfLoop {
    // I keep forgetting stuff. 
    // I need to start making notes again. I need the sticky notes. I need to order them. 
    // I need that shit infront of my fucking face at all times.
    public static newNode head;
    static class newNode
    {
        int data;
        newNode next;
        public newNode(int key)
        {
            data = key;
            next = null;
        }

    }

    static newNode detectStartOfLoop(newNode head)
    {
        if(head==null || head.next == null)
        {
            return null;
        }
        
        newNode slow_p = head;
        newNode fast_p = head;
        
        
        while(slow_p != null && fast_p!=null && head!=null && fast_p.next!=null)
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p == fast_p)
            {
                break;
            }
        }
        if(slow_p != fast_p)
        {
            return null;
        }
        slow_p = head;
        while(slow_p != fast_p)
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next;
        }
        return slow_p;
        
    }

    public static void main(String[] args) {
        newNode head = new newNode(50);
        head.next = new newNode(20);
        head.next.next = new newNode(15);
        head.next.next.next = new newNode(4);
        head.next.next.next.next = new newNode(10);
        head.next.next.next.next.next = head.next.next;
        newNode res= detectStartOfLoop(head);
        if(res == null)
        {
            System.out.println("There is no loop");
        }
        else
        {
            System.out.println("Loop starts from the node "+ res.data);
        }
    }
}
