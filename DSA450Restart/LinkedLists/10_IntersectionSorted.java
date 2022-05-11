package DSA450Restart.LinkedLists;

class IntersectionSorted {
    public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node newList = new Node(0);
        Node current = newList;
        Node curr1 = head1;
        Node curr2 = head2;
        
        while(curr1!=null && curr2!=null)
        {
            if(curr1.data == curr2.data)
            {
                Node newNode = new Node(curr1.data);
                current.next = newNode;
                current = current.next;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            else if(curr1.data<curr2.data)
            {
                curr1 = curr1.next;
            }
            else
            {
                curr2 = curr2.next;
            }
        }
        
        return newList.next;
        
        
    }  
}
