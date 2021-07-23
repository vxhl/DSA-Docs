package LinkedLists;

import java.util.HashSet;

public class Detect_and_Delete_Loop {
    static NODE head;
    static class NODE
    {
        int data;
        NODE next;
        NODE(int key)
        {
            data = key;
            next = null;
        }
    }
    //APPROACH1: O(1) solution
    // Function to detect the loop
    static void detectanddelete(NODE head)
    {
        // First we take two pointer low and high for the list
        // and initialise their addresses to head
        NODE low = head; 
        NODE high = head;

        while(low!=null && high!=null && high.next!=null)
        {
            // We traverse the low pointer by 1 position
            low = low.next;
            // We traverse the high pointer by 2 positions
            high = high.next.next;

            // When we finally find the point where they meet we break
            if(low==high)
            {
                break;
            }

        }

        // When our meeting point is at the head
        if(low==head)
        {
            // We travere high by 1 position till it is not equal to low and 
            // when we find it we set the address for high to null thus breaking the loop
            while(high.next!=low)
            {
                high = high.next;
            }
            high.next = null;
        }

        // Now we set the conditions for breaking the loop when the meeting
        // position is not at head
        else if(low==high)
        {
            // We first set low as head
            low = head;
            while(low.next!=high.next)
            {
                // We traverse both low and high by 1 position to find where the 
                // loop actually starts
                low = low.next;
                high = high.next;
            }
            // After finding it we set the address for high to null thus
            // breaking the loop
            high.next = null;
        }
    }



    static void printList(NODE node)
    {
        while(node!=null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Detect_and_Delete_Loop.head = new NODE(50);
        Detect_and_Delete_Loop.head.next = new NODE(20);
        Detect_and_Delete_Loop.head.next.next = new NODE(15);
        Detect_and_Delete_Loop.head.next.next.next = new NODE(4);
        Detect_and_Delete_Loop.head.next.next.next.next = new NODE(10);
 
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        detectanddelete(head);
        System.out.println(
            "Linked List after removing loop : ");
        printList(head);
    }

}
