package DSA450Restart.LinkedLists;

class Solution_DeleteNodeRightSide
{

    static class Node
    {
        int data;
        Node next;
        Node (int data)
        {
            this.data = data;
        }
    }

    Node computeDummyNodes(Node head)
    {
        // your code here
        Node newHead = reverse(head);
        Node curr = newHead;
        Node dummy = new Node(0);
        Node temp = dummy;
        int max = curr.data;
        temp.next = new Node(max);
        temp = temp.next;
        // 3 2 6 5 11 10 20 15 12
        // 3 
        while(curr.next!=null)
        {
            if(curr.next.data>=max)
            {
                max = curr.next.data;
                temp.next = new Node(max);
                temp = temp.next;
            }
            curr = curr.next;
        }
        
        return reverse(dummy.next);
    }
    
    Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Approach 2: Using pointer manipulation
    Node computeManipulatePointers(Node head)
    {
        // your code here
        // This time around let's implement just using pointers
        Node newHead = reverse(head);
        Node prev = newHead;
        Node curr = newHead;
        int max = curr.data;
        curr = curr.next;
        
        while(curr!=null)
        {
            if(curr.data>=max)
            {
                max = curr.data;
                prev = curr;
                curr = curr.next;
            }
            else
            {
                prev.next = curr.next;
                curr = prev.next;
            }
            // curr = curr.next;
        }
        
        return reverse(newHead);
        
    }
    
}