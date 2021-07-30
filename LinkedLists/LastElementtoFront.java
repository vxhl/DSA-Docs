package LinkedLists;

public class LastElementtoFront 
{
    static Node head;
    class Node
    {
        int data;
        Node next;
        Node (int d)
        {
            data = d;
            next = null;

        }
    }
    void MoveToFront()
    {
        if(head==null || head.next == null)
        {
            return;
        }
        /* Initialise second last and last pointers */
        Node secLast = null;
        Node last = head;

        // We then traverse the linkedlist to get the pointers to the last
        // and second last nodes respectively
        while(last.next!=null)
        {
            secLast = last;
            last = last.next;
        }
        // After doing so we set the next for second last node as null
        // thus making it into the last node
        secLast.next = null;

        // We then set the address for the actual last node as head
        last.next = head;
        
        // At the end we change the head and make it as the last node
        head = last;
    }

    // We use the push function since it makes the 
    // adding nodes process much less tedious
    void push(int new_data)
    {
        // We first allocate the node and put it in the data
        Node new_node = new Node(new_data);

        // We then make the next of new node as head
        // since we always add the nodes at the front of the linked list
        new_node.next = head;

        // We move the head to point to new node
        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LastElementtoFront llist = new LastElementtoFront();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
          
        System.out.println("Linked List before moving last to front ");
        llist.printList();
          
        llist.MoveToFront();
          
        System.out.println("Linked List after moving last to front ");
        llist.printList();
    }

}
