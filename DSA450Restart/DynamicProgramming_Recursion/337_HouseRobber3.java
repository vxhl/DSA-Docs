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

class TreeNode
{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val)
    {
        this.val = val;
    }
}
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


    public int rob_dp(TreeNode root) {
        int[] ans = helper_dp(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] helper_dp(TreeNode root)
    {
        if(root == null) return new int[2];
        int[] left = helper_dp(root.left);
        int[] right = helper_dp(root.right);
        int[] res = new int[2];
        // Our first element of the 2 element array holds the cases when we are not picking the root value and hence
        // We are adding up the maximum value that we garner from the left and right subtrees
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        
        // Our second element holds the case where we are picking our root value, and since we are picking the root value we 
        // add it up with the cases when we are not picking our directly left and right nodes
        res[1] = root.val + left[0] + right[0];
        // Here left[0] signifies all the cases where we do not pick the adjacent root to our left subtree
        // right[0] represents all the cases where we do not pick the root value or the adjacent root to our right subtree
        
        return res;
        
        
    }
}