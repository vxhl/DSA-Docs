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
    private int cameras = 0;
    int postorder(TreeNode root)
    {
        if(root==null) return 1;
        
        int left = postorder(root.left);
        int right = postorder(root.right);
        
        // Our first condition checks for if we have any non monitored nodes,
        // if we do we increment
        if(left == 0 || right == 0)
        {
            cameras++;
            return 2;
        }
        else if(left == 2 || right == 2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    
    public int minCameraCover(TreeNode root) {
         // So we do another postorder traversal for this as well
        // The similarily between this and the other problem with Distribute coins is the postorder pattern
        // we are to go from bottom to top to get the answer for all our subproblems and keep on storing them for the smallest ones and return once we reach the root
        if(root==null) return 0;
        int res = postorder(root);
        // if(sum == 0) count++;
        return cameras+(res==0 ? 1: 0);
        
        
    }
}