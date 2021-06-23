// Problem Statement: 
/*
Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
Example : 
Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4 -> So we return the longest path that can be formed from one subtree to another
*/
package Trees;

class TreeNode3
{
    int data;
    TreeNode3 left, right;
    TreeNode3(int key)
    {
        data = key;
        left = right = null;
    }
}
class Height
{
    int h;
}

class DiameterBinaryTree
{   
    static TreeNode3 root;

    // Approach 1: Dynamic Programmming for trees ->> BASE CASE > HYPOTHESIS > INDUCTION
    // Time complexity -> O(N)
    public static int DiameterOfBinaryTree(TreeNode3 root, Height height)
    {
        // Let us first define the height of our left and right subtree
        Height lheight = new Height();
        Height rheight = new Height();
        // WE DEFINE OUR BASE CASE
        if(root==null)
        {
            height.h = 0;
            return 0;
        }
        // WE DEFINE OUR HYPOTHESIS
        // We get the left and right subtree diameter in lheight and rheight
        int ldiameter = DiameterOfBinaryTree(root.left, lheight);
        int rdiameter = DiameterOfBinaryTree(root.right, rheight);
        // Height of current node is max of heights of left 
        // and right subtree + 1
        // WE DEFINE OUR INDUCTION
        height.h = Math.max(lheight.h, rheight.h) + 1;
        /*
        In the below statement we have defined two expressions to get the max out of
        The first statement `lheight.h + rheight.h + 1` gives us the diameter when the diameter passes
        through the root. But when it does not pass through the root, meaning the maximum diameter is either on
        the left or right subtrees. So we take the max of diameter of left subtree and diameter of right subtree
        */ 



        return Math.max(lheight.h + rheight.h + 1, Math.max(ldiameter,rdiameter));

    }
    int diameter()
    {
        Height height = new Height();
        return DiameterOfBinaryTree(root, height);
    }
    public static void main(String[] args) {
        DiameterBinaryTree tree = new DiameterBinaryTree();
        tree.root = new TreeNode3(1);
        tree.root.left = new TreeNode3(2);
        tree.root.right = new TreeNode3(3);
        tree.root.left.left = new TreeNode3(4);
        tree.root.left.right = new TreeNode3(5);
        System.out.println("The Diameter of the binary tree is: "+ tree.diameter());
    }
}
//The Diameter of the binary tree is: 4