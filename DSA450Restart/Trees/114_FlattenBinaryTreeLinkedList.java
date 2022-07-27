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
    public void flatten(TreeNode root) {
        f(root);
    }
    
    private TreeNode f(TreeNode root){
        if(root == null) return null;
        // We first traverse the left subtree till the leftmost node
        TreeNode leftTraversal = f(root.left);
        // We then set a reference for the right subtree of the current root
        TreeNode temp = root.right;
        // If we find the current left subtree to not be null
        if(leftTraversal!=null){
            // We can simply set the right reference for the current root as the left subtree
            root.right = leftTraversal;
            while(leftTraversal.right!=null){
                leftTraversal = leftTraversal.right;
            }
            leftTraversal.right = temp;
        }
        
        root.left = null;
        TreeNode rightTraversal = f(root.right);
        if(rightTraversal!=null){
            root.right = rightTraversal;
            while(rightTraversal.right!=null){
                rightTraversal = rightTraversal.right;
            }
        }
        
        return root;
    }
}