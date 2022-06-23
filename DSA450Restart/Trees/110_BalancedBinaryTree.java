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
    // For the current node root, calling depth() for its left and 
    // right children actually has to access all of its children, thus the complexity is O(N). We do this for each node in the tree, so the overall complexity of isBalanced will be O(N^2). This is a top down approach.
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = heightTree(root.left);
        int right = heightTree(root.right);
        
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right); 
        
    }
    
    private int heightTree(TreeNode root)
    {
        if(root == null) return 0;
        return Math.max(heightTree(root.left),heightTree(root.right))+1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
    
    private int dfs(TreeNode root)
    {
        if(root==null) return 0;
        int left = dfs(root.left);
        // We check for our left to be -1 initially because we want all our subtrees to follow the conditon
        // And we also do the same for our right subtree.
        if(left == -1) return -1;
        int right = dfs(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;
        
        return Math.max(left,right)+1;
    }





}