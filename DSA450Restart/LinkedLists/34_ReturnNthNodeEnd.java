package DSA450Restart.LinkedLists;

class ReturnNthNodeEnd {

    static class Node
    {
        int data;
        Node next;
        Node (int data)
        {
            this.data = data;
        }
    }

    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node newHead = reverse(head);
    	Node curr = newHead;
    	int i=1;
    	while(curr!=null && i!=n)
    	{
    	    i++;
    	    curr = curr.next;
    	}
    	if(i==n && curr!=null)
    	{
    	    return curr.data;
    	}
    	return -1;
    	
    	
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
}
