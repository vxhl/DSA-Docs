/*
Problem Statement: 
Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed. 

Example: 
Input: 
First linked list: 1->2->3->4->6
Second linked list be 2->4->6->8, 
Output: 2->4->6.
*/
package LinkedLists;
public class IntersectionOfTwoSortedLinkedLists {
    static Node head;
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

    // Approach: Two pointer approach
    // We use two pointer to traverse through both lists and add to the result list when both nodes have same data
    // If not have same data we traverse the pointer in the list with smaller element
    Node Intersection_List()
    {
        // We first define our two pointers for both linkedlists
        Node ptr1 = head1;
        Node ptr2 = head2;
        // We then define our new resultant linkedlists head node
        Node head = null;
        // A curr node for keeping track of the new linked list 
        Node curr = null;

        while(ptr1!=null && ptr2!=null)
        {
            // First define the conditions for adding the Intersected nodes into the linked list
            if(ptr1.data == ptr2.data)
            {
                if(head==null)
                {
                    Node t = new Node(ptr1.data);
                    head = t;
                    curr = t;
                }
                else
                {
                    Node t = new Node(ptr1.data);
                    curr.next = t; 
                    curr = curr.next;
                }
                // We traverse both the pointers together
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            else
            {
                if(ptr1.data<ptr2.data)
                {
                    ptr1 = ptr1.next;
                }
                else
                {
                    ptr2 = ptr2.next;
                }
            }
        }
        return head;

    }
    public static void printList(Node node)
    {
        Node temp = node;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
    }
   

    public static void main(String[] args) {
        IntersectionOfTwoSortedLinkedLists list = new IntersectionOfTwoSortedLinkedLists();
        list.head1 = list.new Node(1);
        list.head1.next = list.new Node(2);
        list.head1.next.next = list.new Node(3);
        list.head1.next.next.next = list.new Node(4);
        list.head1.next.next.next.next = list.new Node(6);
        
        System.out.println("The first linkedlist:  ");
        printList(head1);
        System.out.println(" ");
        // creating second linked list
        list.head2 = list.new Node(2);
        list.head2.next = list.new Node(4);
        list.head2.next.next = list.new Node(6);
        list.head2.next.next.next = list.new Node(8);
        
        System.out.println("The Second Linked List: ");
        printList(head2);
        // function call for intersection
        
        System.out.println(" ");
        list.head = list.Intersection_List();
       
        // print required intersection
        System.out.println("Linked list containing common items of a & b");
        printList(head);
    }
}
/*
OUTPUT: 
The first linkedlist:  
1 2 3 4 6
The Second Linked List:
2 4 6 8
Linked list containing common items of a & b
2 4 6
*/
