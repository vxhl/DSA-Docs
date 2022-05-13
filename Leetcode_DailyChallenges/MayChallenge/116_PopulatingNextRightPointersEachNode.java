package Leetcode_DailyChallenges.MayChallenge;

class Node
{
    int val;
    Node left;
    Node right;
    Node next;
    public Node() {}


    public Node(int _val)
    {
        this.val = _val;
    }
    
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}


class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        if(root == null)
        {
            return null;
        }
        
        Node curr = root;
        while(curr.left !=null)
        {
            // We store our temp for traversing towards the next levels
            Node temp = curr;
            while(curr!=null)
            {
                // We first connect the left and right pointers of our current node
                curr.left.next = curr.right;
                // Then for our right node, if the node to the next of curr is null then we assign null,
                // otherwise we just assign whatever is on the left of it
                curr.right.next = curr.next == null ? null : curr.next.left;
                // We move our curr node forward to the next node in the level
                curr = curr.next;
            }    
            curr = temp.left;
        }
        
        return root;
    }
}
