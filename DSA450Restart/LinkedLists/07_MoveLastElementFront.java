package DSA450Restart.LinkedLists;

class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = next;
    }
}


class MoveLastElementFront {
    public static Node MoveLastFront(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        Node curr = head;
        Node prev = null;

        while(curr!=null)
        {
            if(curr.next == null)
            {
                // We set the next to our head
                curr.next = head;
                // And we set the pointer for the previous node that was on the last node initially as our last node
                prev.next = null;
            }
            
            prev = curr;
            curr = curr.next;

        }

        return head;
    }
}
