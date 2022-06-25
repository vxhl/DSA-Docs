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


    public int rob_recursive(TreeNode root) {
        if(root == null) return 0;
        
        int include = root.val;
        if(root.left!=null)
        {
            include+=rob(root.left.left)+rob(root.left.right);
        }
        
        if(root.right!=null)
        {
            include+=rob(root.right.left)+rob(root.right.right);
        }
        
        int exclude = rob(root.left)+rob(root.right);
        return Math.max(include, exclude);
    }

    // Memoised solution with Maps
    public int rob(TreeNode root) {
        Map<TreeNode, Integer>mp = new HashMap<>();
        return helper(root, mp);
    }
    
    public int helper(TreeNode root, Map<TreeNode, Integer> mp)
    {
        if(root == null) return 0;
        
        int include = root.val;
        
        if(mp.containsKey(root))
        {
            return mp.get(root);
        }
        
        if(root.left!=null)
        {
            include+=helper(root.left.left, mp)+helper(root.left.right, mp);
        }
        
        if(root.right!=null)
        {
            include+=helper(root.right.left,mp)+helper(root.right.right,mp);
        }
        
        int exclude = helper(root.left,mp)+helper(root.right,mp);
        
        mp.put(root,Math.max(include, exclude));
        
        return Math.max(include, exclude);
        
        
    }
}