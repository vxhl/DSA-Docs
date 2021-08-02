package LinkedLists;

public class IntersectionPointOfTwoLinkedLists {
    static Node head1 = null;
    static Node head2 = null;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static void IntersectionPoint(Node head1,Node head2)
    {   
        if(head1 == null || head2 == null) return;
        Node ptr1 = head1;
        Node ptr2 = head2;
        
        while(ptr1 != ptr2)
        {
            if(ptr1 == null)
            {
                ptr1 = head2;
            }
            else
            {
                ptr1 = ptr1.next;
            }
            if(ptr2 == null)
            {
                ptr2 = head1;
            }
            else
            {
                ptr2 = ptr2.next;
            }
            
        }
        System.out.print(ptr1.data);
        
    }
    public static void printList(Node node)
    {
        Node temp = node;

        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }        
    }

    public static void main(String[] args) {
        IntersectionPointOfTwoLinkedLists list = new IntersectionPointOfTwoLinkedLists();
        list.head1 = list.new Node(3);
        list.head1.next = list.new Node(6);
        list.head1.next.next = list.new Node(9);
        list.head1.next.next.next = list.new Node(15);
        list.head1.next.next.next.next = list.new Node(30);
        
        System.out.println("The first linkedlist:  ");
        printList(head1);
        System.out.println(" ");
        // creating second linked list
        list.head2 = list.new Node(10);
        list.head2.next = list.new Node(15);
        list.head2.next.next = list.new Node(30);
        System.out.println("The Second Linked List: ");
        printList(head2);
        // function call for intersection
        System.out.print("The intersection point of the two linked lists is: ");
        IntersectionPoint(head1, head2);

    }
}
