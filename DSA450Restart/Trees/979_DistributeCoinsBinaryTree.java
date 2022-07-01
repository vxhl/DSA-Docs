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
 }
class Solution2 {
    
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root)
    {
        // If we reach a null we simply return 0
        if(root == null) return 0;
        
        // We calculate our values for the left and right subtrees
        int left = helper(root.left);
        int right = helper(root.right);
        
        // Everytime we calculate the requirement of the left and right subtrees of a node
        // We absolute it and add it to the answer inorder to get the number of moves required to balance both the left and the right subtrees
        // There are two types of moves, one can be taking from the parent and one can be giving to the parent
        // So we absolute the moves and add them up since we need to distribute 1 coin to each node anyway
        
        ans += Math.abs(left)+Math.abs(right);
        
        // What we return is basically our current root value adding onto it
        // the requirements of our left and right subtrees and as well as the requirement of our current node which
        // will be 1. 
        return root.val + left + right - 1;
        
    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
        left = right = null;
    }
}