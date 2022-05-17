package DSA450Restart.LinkedLists;

class Clone {
static class Node
    {
        Node next;
        Node arb;
        int data;
        public Node(int data)
        {
            this.data = data;
            next = null;
            arb = null;
        }
    }
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        Node iter = head;
        Node front = head;
        
        // For step 1 we create a new node called copyNode let's say we had node(1) and we create
        // copynode(1) and what we do is, we point our node(1) to copynode(1) and copynode(1) points
        // to our node(1).next doing this we create a new linkedlist where we have copynode(1) alternating
        // between our original nodes
        while(iter!=null)
        {
            // FIrst we define our copy node
            front = iter.next; // We store our next in front
            Node copyNode = new Node(iter.data);
            iter.next = copyNode; // node(1) now points to copynode(1)
            copyNode.next = front; // copynode(1) now points to node(2)
            iter = front; // we move our iter ahead using the stored reference for the next pointer
        }
        // For step 2 we set up the random pointers for our copyNodes while not manipulating
        // the integrity of them in our original nodes
        Node iter2 = head;
        while(iter2!=null)
        {
            if(iter2.arb != null)
            {
                // The following step does this
                // iter2 represents presently node(1)
                // iter2.next points to our copyNode(1)
                // but we don't have a linked for copyNode(1).arb yet
                // So we set it's arb to the node(1).arb.next meaning node(1).arb => node(4) 
                // and it's next is copyNode(4)
                iter2.next.arb = iter2.arb.next; 
               
            }
             iter2 = iter2.next.next;
        }
        
        
        // For the 3rd step we finally restore the integrity of the orignial linkedlist
        // and thus in the process create our new required deep copy linkedlist / clone
        // Our result will be in pseudohead.next
        Node pseudoHead = new Node(0);
        // We take a current pointer for it's traversal
        Node curr = pseudoHead;
        // We ofc need a iter3 to keep track of our new nodes
        Node iter3 = head;
        
        while(iter3!=null)
        {
            Node front2 = iter3.next.next;
            // We first point our current of newHead to the copyNode
            // this forms node(0) -> copyNode(1) -> ....
            curr.next = iter3.next;
            // Then we break the link between node(1) and copyNode(1) and 
            // point them towards front 2 thus froming the link node(1)-> node(2)
            iter3.next = front2;
            
            curr = curr.next;
            iter3 = iter3.next;
            
        }
        
        // Thus we are done with all the required steps and so we return 
        
        return pseudoHead.next;
        
        
    }
}