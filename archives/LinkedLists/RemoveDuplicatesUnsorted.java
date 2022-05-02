package LinkedLists;

import java.util.HashSet;

import javax.lang.model.util.ElementScanner6;

public class RemoveDuplicatesUnsorted {
    
    static Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Approach 1: Using two loops 
    void removeDupesUnsorted()
    {
        // In this approach we use ptr1 and ptr2 to keep track of the 
        // elements comparison in the linkedlist
        Node ptr1 = null, ptr2 = null, dupe = null;
        ptr1 = head;
 
        /*Pick elements one by one*/
        while(ptr1 != null && ptr1.next != null)
        {
            ptr2 = ptr1;
            
            while(ptr2.next!=null)
            {
               if (ptr1.data == ptr2.next.data)
               {
                dupe = ptr2.next;
                ptr2.next = ptr2.next.next;
                System.gc();
            
            }
            else
            {
                ptr2 = ptr2.next;
            }

        }
        ptr1 = ptr1.next;


    }
}
    // Approach 2: Using Hashing
    static Node removeDupicatesUnsortedHashing(Node head)
    {
        HashSet<Integer> m = new HashSet<>();
        Node curr = head;
        Node prev = null;
        
        while(curr!=null)
        {
            int x = curr.data;
            if(m.contains(x))
            {
                prev.next = curr.next;
                System.gc();
            }
            else
            {
                m.add(x);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }




void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
public static void main(String[] args) {
    RemoveDuplicatesUnsorted list = new RemoveDuplicatesUnsorted();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next
            = new Node(10);
 
        System.out.println(
            "Linked List before removing duplicates : \n ");
        list.printList(head);
 
        removeDupicatesUnsortedHashing(head);
        System.out.println("");
        System.out.println(
            "Linked List after removing duplicates : \n ");
        list.printList(head);
}
}
