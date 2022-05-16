package DSA450Restart.LinkedLists;

class Sort012LL {

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    static Node segregate(Node head)
    {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        // add your code here
        Node curr_0 = new Node(1);
        Node final_0 = curr_0;
        // join them all together later
        Node curr_1 = new Node(-1);
        Node final_1 = curr_1;
        Node curr_2 = new Node(-1);
        Node final_2 = curr_2;
        Node curr = head;
        
        while(curr!=null)
        {
            if(curr.data == 0)
            {
                curr_0.next = new Node(curr.data);
                curr_0 = curr_0.next;
            }
            else if(curr.data == 1)
            {
                curr_1.next = new Node(curr.data);
                curr_1 = curr_1.next;
            }
            else
            {
                curr_2.next = new Node(curr.data);
                curr_2 = curr_2.next;
            }
            
            curr = curr.next;
        }
        
        // Now we know that all the nodes are at their end positions
        // First let's join curr_0 and curr_1, the question is HOW
        
        // We have the pointer for curr_0 but we don't have curr_1 since it's all the way in the end
        // We first join the 1 and 2 lists
        curr_1.next = final_2.next;
        // Then we join them all in the 0th list
        curr_0.next = final_1.next;
        
        return final_0.next;
        
        
    
    }
}
