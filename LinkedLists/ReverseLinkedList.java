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
    NODE reverse(NODE node)
    {
        NODE prev = null;
        NODE current = node;
        NODE next = null;
        while(current!=null)
        {
            // We first store the next node
            next = current.next;
            current.next = prev; 
            prev = current;
            current = next;
        }
        node = prev;
        return node;
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
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

}
