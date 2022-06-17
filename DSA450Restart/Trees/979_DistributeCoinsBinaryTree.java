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
    int count = 0;
    void helper(TreeNode par, TreeNode curr)
    {
        // We need to do a postorder traversal right, so let's look at the conditions
        if(curr==null) return;
        // We apply the postorder traversal for the child node
        helper(curr, curr.left);
        helper(curr, curr.right);
        
        if(curr.val>1)
        {
            // We first get the extra coins, so we subtract 1 from the curr coins
            int extra = curr.val-1;
            curr.val = 1;
            par.val+=extra;
            count+=extra;
        }
        else if(curr.val<1)
        {
            int needed = 1+Math.abs(curr.val);
            curr.val = 1;
            par.val-=needed;
            count+=needed;
        }
    }
    
    
    public int distributeCoins(TreeNode root) {
        helper(root, root);
        return count;
    }
}