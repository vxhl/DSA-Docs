// Problem statement : Implement Level Order Traversal for a binary tree
package Trees;

import java.util.LinkedList;
import java.util.Queue;

// First we define the node for our tree
class TreeNode1
{
    int data;
    TreeNode1 left,right;
    TreeNode1(int key)
    {
        data = key;
        left = right = null;
    }
}
// Now let us define our binary tree
class LevelOrderBinaryTree
{
    TreeNode1 root; // We define the root node
    // Constructor for the root node
    public LevelOrderBinaryTree()
    {
        root = null;
    }
    /*
    
    -------------------------------------------------------------------------------------------------------------------------------
    -------------------------------------------------------------------------------------------------------------------------------
    Approach 1: In this approach we use two functions to print our traversal --> levelOrder(root) and printCurrentLevel(root,level) 
    Time Complexity -- O(N^2)
    */
    void LevelOrderTraversal()
    {
        int h = heightOfTree(root); // We first get the height of our tree
        int i;
        for(i=1; i<=h; i++)
        {
            printCurrentLevel(root, i); // Then we print the nodes in each level for the height of the given tree/ 
        }
        
    }
    void printCurrentLevel(TreeNode1 root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(level==1) // When we have only the root then we print the same
        {
            System.out.print(root.data + " ");
        }
        else if(level>1)
        {
            printCurrentLevel(root.left, level-1); // We traverse the left subtree, print the root.left.data and then decrement one level
            
            printCurrentLevel(root.right, level-1); // Similarly we do the same for right subtree and print it. This ends the printing of one level of our tree
        }
    }
    // We need to get the height of our binary tree to traverse the levels
    int heightOfTree(TreeNode1 root)
    {
        if(root==null)
        {
            return 0; 
        }
        // We set two integers for left and right subtrees ad in the end we print the result with the highest value as the height of the tree
        int left = heightOfTree(root.left); 
        int right = heightOfTree(root.right);
        if(left>right)
        {
            return(left+1); // We increment as we move down the tree
        }
        else
        {
            return(right+1);
        }
    }

    /*
    -------------------------------------------------------------------------------------------------------------------------------
    -------------------------------------------------------------------------------------------------------------------------------
    Approach 2: In the second approach we use a queue.
    For each node, first the node is visited then we put it's child nodes in a FIFO queue
    Time Complexity -> O(N)
    */
    
    void QueueLevelOrder()
    {
       Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
       queue.add(root);
       while(!queue.isEmpty())
       {
           // The poll method gives us the current head
           TreeNode1 temp = queue.poll();
           System.out.print(temp.data + " ");
           if(temp.left!=null)
           {
                queue.add(temp.left);
           }
           if(temp.right!=null)
           {
                queue.add(temp.right);
           }
       } 
    }
    public static void main(String args[])
    {
       LevelOrderBinaryTree tree = new LevelOrderBinaryTree();
       tree.root= new TreeNode1(1);
       tree.root.left= new TreeNode1(2);
       tree.root.right= new TreeNode1(3);
       tree.root.left.left= new TreeNode1(4);
       tree.root.left.right= new TreeNode1(5);
        
       System.out.print("Approach 1 : Level order traversal of binary tree is ");
       tree.LevelOrderTraversal();
       System.out.println("");
       System.out.print("Approach 2 : Level order traversal of binary tree is ");
       tree.QueueLevelOrder();
    }
}   
/*
Output : 12345
*/