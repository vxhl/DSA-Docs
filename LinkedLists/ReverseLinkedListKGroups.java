/*
Problem Statement: 
Given a linked list of size N. The task is to reverse 
every k nodes (where k is an input to the function) in the linked list.
Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.
*/
package LinkedLists;

public class ReverseLinkedListKGroups {
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
     NODE reverse_Kth_Groups(NODE head, int k)
    {
        NODE curr = head;
        NODE next = null;
        NODE prev = null;
        int count = 0;
        while(count<k && curr!=null)
        {
            // We first store the address 
            next = curr.next;
            // We then point curr towards it's previous node
            curr.next = prev;
            // Now for the next operation we change the previous to current
            prev = curr;
            // At the end we set the address for the next element to current
            curr = next;
            count++;

        }
        // Now for the main operation we change the link for the first head node of the sub sequence to the last node of the next sub sequence
        if(next!=null)
        {
            head.next = reverse_Kth_Groups(next, k);
        }
        return prev;
    }
    void printLinkedList(NODE head)
    {
        while(head!=null)
        {
            System.out.print(head.key + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ReverseLinkedListKGroups revlist = new ReverseLinkedListKGroups();
        revlist.head = new NODE(1);
        revlist.head.next = new NODE(2);
        revlist.head.next.next = new NODE(3);
        revlist.head.next.next.next = new NODE(4);
        revlist.head.next.next.next.next = new NODE(5);
        revlist.head.next.next.next.next.next = new NODE(6);
        revlist.head.next.next.next.next.next.next = new NODE(7);
        int k = 3;
 
        System.out.println("Given Linked list ");
        revlist.printLinkedList(head);
        System.out.println("The Reversed List is ");
        head = revlist.reverse_Kth_Groups(head, k);
        revlist.printLinkedList(head);

    }

}
