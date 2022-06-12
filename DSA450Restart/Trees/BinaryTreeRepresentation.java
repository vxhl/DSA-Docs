public class BinaryTreeRepresentation {
    
    class Node
    {
        // Holds the data for our node
        int data;
        // For pointing to the left subtree
        Node left;
        // FOr pointing to the right subtree
        Node right;
        
        public Node(int val)
        {
            data = val;
            left = right = null;
        }

    }

    public static void main(String[] args) {
        BinaryTreeRepresentation btree = new BinaryTreeRepresentation();
        Node root = btree.new Node(1);
        root.left = btree.new Node(2);
        root.right = btree.new Node(3);
        root.left.right = btree.new Node(5);
    }
}
