// Problem Statement : 
// Construct the following Binary Tree 
/*
     tree
      ----
       1    <-- root
     /   \
    2     3  
   /   
  4

*/
package Trees;
public class BinaryTrees 
{
    // Representing a tree node in java
    class Node 
    {
        int key;
        Node left, right;
        public Node(int data)
        {
            key = data;
            left = right = null;
        }
    }
    class BinaryTree 
    {
        Node root; // We initialise root as a node
        
        // Constructors
        BinaryTree(int key)
        {
            root = new Node(key);
        }
        BinaryTree()
        {
            root = null;
        }
    }   
    public void main(String[] args) {
        BinaryTree tree =  new BinaryTree();
        tree.root = new Node(1); // We assign the root value as 1
        tree.root.left = new Node(2); // We get the left child for 1
        tree.root.right = new Node(3); // We get the right child for 1
        tree.root.left.left = new Node(4); // We get the left child for 2 
    }
}