package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class TreeNode
{
    int val; 
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BSTIterator {

    // We first have a stack that holds at any time all the nodes in our left subtree of a given node
    Deque<TreeNode> st = new LinkedList<>();
    public BSTIterator(TreeNode root)
    {
        /*
        This initialises an object of the BSTIterator class, let's say it is 
        curr in this case
        */
        // We push all the left nodes from the root into our stack;
        pushLeftNodes(root);
    }

    public int next()
    {
        // Now we pop the given node and then push it's right nodes into our stack so we process there left nodes
        TreeNode curr = st.pop();
        pushLeftNodes(curr.right);
        // We simply return curr.val for inorder traversal
        return curr.val;

    }
    public boolean hasNext()
    {
        // For checking whether there are any next elements we use this
        return !st.isEmpty();
    }
    
    private void pushLeftNodes(TreeNode root)
    {
        // Additional method for pushing all the left nodes into our stack
        while(root!=null)
        {
            st.push(root);
            root = root.left;
        }
    }
}