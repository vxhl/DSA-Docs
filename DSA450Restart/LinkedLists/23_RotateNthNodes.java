package DSA450Restart.LinkedLists;

class rotateNthNode
{
    static class dlnode
    {
        int val;
        dlnode next;
        dlnode prev;
        dlnode(int val)
        {
            this.val = val;
        }
    }

    public static dlnode rotatebyKTimes(dlnode start, int x)
    {
        if(start == null)
        {
            return start;
        }

        // Ok inorder to rotate it we first need to make our linkedlists as circular inorder to make the rotation possible

        dlnode curr = start;
        int count = 1;

        while(curr.next!=null && count!=x)
        {
            curr = curr.next;
            count++;
        }

        // First we need to check if curr is null because if it is then our
        // x is greater than the length of the linkedlist
        if(curr == null)
        {
            return start;
        }

        /*
        1 - 2 - 3 - 4 - 5 - 6  
        our rotation happen by two positions in the counter clockwise direction
        so we get 3 4 5 6 1 2
        
        rn after the above while loop our curr points at nthnode meaning 2
        */

        // Let us store our nth node for now
        dlnode nthNode = curr;

        // Now first we traverse till the end and make our linkedlist as circular
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        // We now make the linkedlist as circular
        curr.next = start;
        // Now this is either extremely smart or I am just dumb
        
        // we put the address for out start node as the next node from where we need the rotation to take place
        start = nthNode.next;
        // We then break the prev link that we have with the nthNode from nthNode.next meaning
        start.prev = null;
        // What this basically does is imagine that we are operating on the example
        // 1 2 3 4 5 => Now after making the list circular ofc we know it will be an infinite loop -> Now we also know that for n=2, our nthNode is at node with value 2
        // and we set the address of the start node at the nthnode.next position meaning the node with value 3
        // next when we set start.prev = null we break the node with value 3's link with the node(2) thus the link is no longer circular anymore without a prev link between two of
        // the nodes and so we make the list non circular and link the node(1) and node(2) at the back of the list making it move in the anticlockwise direction by 2 times
        // We finally set the nthnode.next = null to break the link with node(2) and node(3) as well
        nthNode.next = null;
        return start;
    }
}
