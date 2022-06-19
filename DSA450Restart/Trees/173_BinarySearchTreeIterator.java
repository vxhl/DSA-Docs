/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 
 */
import java.util.*;
class TreeNode
{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val)
    {
        this.val = val;
        left = right = null;
    }
}
class BSTIterator {
    Deque<TreeNode> st = new ArrayDeque<>();
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        this.curr = root;
        pushAllLeftNodes(curr);
    }
    
    public int next() {
        // On the next method, we first store our value that is to be returned
        // Since that is the leftmost element
        TreeNode temp = st.pop();
        pushAllLeftNodes(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void pushAllLeftNodes(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */