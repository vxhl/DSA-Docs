    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Lowest Common Ancestor
        // Defined between two nodes p and q as the lowest node in the tree that has 
        // both q and q as descendants
        isLCA(root, p,q);
        return ans;
    }
    TreeNode ans = null;
    private boolean isLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        if(root==p || root == q){
            ans = root;
            return true;
        }
        boolean left = isLCA(root.left, p, q);
        boolean right = isLCA(root.right, p, q);
        // How should we use the BST property here is the question
        if(left && right){
            ans = root;
            return true;
        }
        if(left || right){
            return true;
        }
        return false;
        
    }
}