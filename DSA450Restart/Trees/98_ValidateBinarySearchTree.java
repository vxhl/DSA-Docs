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
 */
import java.util.*;
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        // We will be using the stack interface from the Deque class
        TreeNode pre = null;
        Deque<TreeNode> st = new ArrayDeque<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }    
            root = st.pop();
            if(pre!=null && pre.val>=root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // Recursive Code.
    public boolean isValidBST2(TreeNode root)
    {
        // We are passing in Long because of our constraints
        return isValidBST_util(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST_util(TreeNode root, long minVal, long maxVal) {
        
        if (root == null) return true;
        // Now if we ever exceed our maxVal or our minVal we can return false
        if (root.val >= maxVal || root.val <= minVal) return false;
        // When we pass in the recursive calls for our left and right subtrees we reset our max and min values respectively for our
        // left and right subtrees. 
        // like for our left subtree now the maxVal we can go to is the roots value
        // and for our right subtree the minVal we can go to is now the roots value
        return isValidBST_util(root.left, minVal, root.val) && isValidBST_util(root.right, root.val, maxVal);
    }


}