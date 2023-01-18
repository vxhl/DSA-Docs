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
        if(root == null) return null;
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val>p.val & root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // If one node is small and the other is larger that means the root itself is
        // the lowest common ancestor. 
        else{
            return root;
        }
    }
}