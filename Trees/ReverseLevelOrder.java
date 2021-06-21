/*
Problem Statement : Implementing reverse level order traversal on a given binary tree
*/
package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode2
{
    int data;
    TreeNode2 left,right;
    TreeNode2(int item) 
    {
        data = item;
        left = right = null;
    }
}

class ReverseOrderBinaryTree
{
    TreeNode2 root;

    /*-------------------------------------------------------------------------------------------------------------------------------
    Approach 1: In this approach we use two functions to print our traversal --> levelOrder(root) and printCurrentLevel(root,level) 
    Time Complexity -- O(N^2)
    */
    void reverseLevelOrder()
    {
        int h = heightOfTree(root);
        int i;
        for(i=h; i>0; i--)
        {
            printCurrentLevel(root, i);
        }
    }
        
    void printCurrentLevel(TreeNode2 root, int level)
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
    int heightOfTree(TreeNode2 root)
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
    // -------------------------------------------------------------------------------------------------------------------------------
    // Approach 2 :: Using Stack and Queue 
    // Time Complexity :: O(N)
    void QueueStackReverseLevelOrder()
    {
        Stack<TreeNode2> S = new Stack<TreeNode2>(); 
        Queue<TreeNode2> Q = new LinkedList<TreeNode2>();
        Q.add(root); // We first push our root to the queue
   
        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false) 
        {
            /* Dequeue node and make it root */
            TreeNode2 temp = root;
            temp = Q.peek(); // We set temp as the root
            Q.remove(); // Then we dequeue from the Queue
            S.push(temp); // And we push the root into the stack
   
            // We then enqueue the left and right child
            if (temp.right != null)
                Q.add(temp.right);  
                  
 
            if (temp.left != null)
                Q.add(temp.left);
        }
        // At the end of the while loop we will have all the elements in the stack
        // In the order of Level Order Traversal
        // Now let us pop from the stack in the LIFO order to get the reverse level order traversal
        while (S.empty() == false) 
        {
            root = S.peek(); 
            System.out.print(root.data + " ");
            S.pop();
        }
    }
    public static void main(String[] args) {
        ReverseOrderBinaryTree tree = new ReverseOrderBinaryTree();
        // Let us create trees shown in above diagram
        tree.root = new TreeNode2(1);
        tree.root.left = new TreeNode2(2);
        tree.root.right = new TreeNode2(3);
        tree.root.left.left = new TreeNode2(4);
        tree.root.left.right = new TreeNode2(5);
        tree.root.right.left = new TreeNode2(6);
        tree.root.right.right = new TreeNode2(7);
   
        System.out.println("Approach 1: Level Order traversal of binary tree is ");
        tree.reverseLevelOrder();
        System.out.println(" ");
        System.out.println("Approach 2: Level Order traversal of binary tree using Queue and stack is ");
        tree.QueueStackReverseLevelOrder();
        
    }       
}
/*
Approach 1: Level Order traversal of binary tree is
4 5 6 7 2 3 1
Approach 2: Level Order traversal of binary tree using Queue and stack is
4 5 6 7 2 3 1
*/