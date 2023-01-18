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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long left, long right){
        if(root==null) return true;
        if(root.val<=left || root.val>=right) return false;
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
    
    // While this works for some cases, it does not work for when
    // we want to check the root agains the deeper key values of the left and right subtrees
    // so we need to somehow make a storage for the current max and min values for the left
    // and right subtrees so that when we go deeper down the trees we still have something
    // to compare with. 
    public boolean isValidBST_trial(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right); 
    }

    /*
        case 1:
            all left nodes are smaller than the current node
        case 2:
            all right nodes are greater than the current node
        case 3:
            all the left and right subtrees are also bsts

        how do we determine that the current tree is valid then? 
        This is ofc a recurssion heavy problem. 
        let's think of the base case first

        base case:
            if(node==null) return;
        if(node.left.val>node.val){
            return false;
        }
        if(node.right.val<node.val){
            return false;
        }
        function(root.left);
        function(root.right);

        return true;

    */
}