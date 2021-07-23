/*
Problem Statement: 
Write a function that takes a list sorted in non-decreasing order and deletes 
any duplicate nodes from the list. The list should only be traversed once. 
For example if the linked list is 11->11->11->21->43->43->60 
then removeDuplicates() should convert the list to 11->21->43->60. 
*/

package LinkedLists;

public class RemoveDuplicatesSorted {
 
    static NODE head;
    static class NODE
    {
        int data;
        NODE next;
        NODE(int d)
        {
            data = d;
            next = null;
        }
    }
    // Iterative Approach
    void removeDupesSortedIterative()
    {
        NODE curr = head;
        while(curr!=null)
        {
            NODE temp = curr;
            // We traverse as long as we do not see a different element 
            while(temp!=null && temp.data == curr.data)
            {
                temp = temp.next;
            }
            // When we finally encounter a different element we 
            // first store the address for the most recent duplicated element
            curr.next = temp;
            // And then traverse for the next node
            curr = curr.next;
        }
    }

    // Recursive Approach
    NODE removeDupesSortedRecursive(NODE head)
    {
        NODE dupes;
        if(head==null) return null;

        while(head!=null)
        {
            // For when we find duplicates
            if(head.data== head.next.data)
            {
                // We first set the duplicate to the address node
                dupes = head.next;
                head.next = head.next.next; // Then we traverse to the next node after the duped node
                removeDupesSortedRecursive(head); // We then check again to see if there are more duplicates for the present element
            }
            else
            {   // Otherwise we traverse to the next node;
                removeDupesSortedRecursive(head.next);
            }
        }
        return head;
    }




    static void printList(NODE head)
    {
        while(head!=null)
        {
            System.out.print(head.data+ " ");
            head = head.next;
        }   
    }
    void push(int new_data)
    {
        // We allocate the node and put in the data
        NODE new_node = new NODE(new_data);
        // We make the next of the new node as head
        new_node.next = head;
        // We then move the head to point to new node
        head = new_node;
    }
    public static void main(String[] args) {
        RemoveDuplicatesSorted llist = new RemoveDuplicatesSorted();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);
         
        System.out.println("List before removal of duplicates");
        printList(head);
         
        llist.removeDupesSortedIterative();
        System.out.println(" ");
        System.out.println("List after removal of elements");
        printList(head);
    }
}
/*
List before removal of duplicates
11 11 11 13 13 20
List after removal of elements
11 13 20
*/
