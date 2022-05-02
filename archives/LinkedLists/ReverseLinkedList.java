package LinkedLists;

class ReverseTheLinkedList
{
    static NODE head;
    static class NODE 
    {
        int key;
        NODE next;
        NODE(int data)
        {
            key = data;
            next = null;
        }
    }
    // Approach 1: Reversing LinkedList using Iterative method
    NODE ReverseIterativeLinkedList(NODE node)
    {
        // First let us define the previous node for the head node
        NODE prev = null;
        // We assign our head node to current
        NODE current = node;
        // We then assign a new node next for storing the link for the next nodes
        NODE next = null;
        while(current!=null)
        {   
            // As said before we store the address for the next node in the `next` node
            next = current.next;
            // Then we assign the pointer for the next node of current node to the previous node
            current.next = prev; 
            // We then change the value of prev for the operation with the next node
            prev = current;
            // We also get the address for the next node
            current = next;
        }
        // At the end we assign our head node as prev and completing the reverse operation
        node = prev;
        return node;
    }
    // Approach 2: Reversing linkedlist using recurssive method.
    static void ReverseRecursiveLinkedList(NODE node)
    {
        if(node.next == null)
        {
            head = node;
            return;
        }
        ReverseRecursiveLinkedList(node.next);
        NODE q = node.next;
        q.next = node;
        node.next = null;
    }


    void printList(NODE node)
    {
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        ReverseTheLinkedList list = new ReverseTheLinkedList();
        list.head = new NODE(85);
        list.head.next = new NODE(15);
        list.head.next.next = new NODE(4);
        list.head.next.next.next = new NODE(20);
 
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.ReverseIterativeLinkedList(head);
        System.out.println("");
        System.out.print("Reversed linked list using Iterative approach ");
        list.printList(head);
        ReverseRecursiveLinkedList(head);
        
        System.out.print("Reversed linked list using Recurssive approach ");
        list.printList(head);

    }

}
