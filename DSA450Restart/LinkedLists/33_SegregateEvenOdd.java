package DSA450Restart.LinkedLists;
import java.util.*;


class SegregateEvenOdd {
    static class Node
    {
        int data;
        Node next;

        Node (int data)
        {
            this.data = data;
        }
    }
    Node divide(int N, Node head){
        // code here
        Node curr = head;
        Node prev = null;
        Node end  = head;
        

        // We first get to the last node of the linkedlist where we will be adding our odd nodes 
        while(end.next!=null)
        {
            end = end.next;
        }

        // Let's get another pointer so that we can still have the reference for end while we are adding our odd pointers
        Node new_end = end;
        

        // First of all we just traverse our linkedlist and as long as we find odd characters in it, we add them to the end of the linkedlist
        // using our new_end pointer
        while(curr.data%2!=0 && curr!=end)
        {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        
        // Now after traversing to the end, we check our curr, and if we have even elements only then does
        // this condition execute, otherwise, it means we only have odd elements in our linkedlist
        if(curr.data%2==0)
        {
            // First of all, we set our head to where our current is, since we need the first even element
            // as the head of our linkedlist
            head = curr;
            
            // Now as long as we do not reach the end, the original end i mean
            while(curr!=end)
            {
                // If it is already even we don't do anything and just traverse forward
                if(curr.data%2==0)
                {
                    prev = curr;
                    curr = curr.next;
                }

                // Otherwise we delete our node, and add it to the end of the manipulated new_end of the linkedlist
                // using the new_end pointer
                else
                {
                    // We break the link between the odd node and the previous node
                    prev.next = curr.next;
                    // We set the odd node's next to null
                    curr.next = null;
                    // We add this odd node to the end of our new_end 
                    new_end.next = curr;
                    
                    // And we move our new_end forward
                    new_end = curr;
                    
                    // And we also set our previous forward, since we stored the reference to the next node in prev.next
                    curr = prev.next;
                }
            }
            
            
        }
        // This is for the null condition
        else
        {
            prev = curr;
        }
        
        // And this is for when there are no even nodes in the linkedlist
        // and if our end is actually also a odd node then we simply put this end node to the new_end of the linkedlist
        if(new_end!=end && end.data%2!=0)
        {
            prev.next = end.next;
            
            end.next = null;
            new_end.next = end;
        }
        
        return head;
        
        
        
    }
}
