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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Here we are to return the path itself
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs_backtracking(root, new ArrayList<>(), ans, targetSum);
        return ans;
        
    }
    
    
    void dfs_backtracking(TreeNode root, List<Integer> path, List<List<Integer>> ans, int targetSum)
    {
        if(root == null){ 
            return;
        }
        
        path.add(root.val);   
        
        if(root.left==null && root.right==null && targetSum-root.val == 0)
        {
            // If we are at the leaf node and find that we satisfy our conditions
            ans.add(new ArrayList<Integer>(path));
        }
        else
        {
            dfs_backtracking(root.left, path, ans, targetSum-root.val);
            dfs_backtracking(root.right, path, ans, targetSum-root.val);
        }
        // We remove our last node that we entered and check for the rest of the paths;
        path.remove(path.size()-1);
        
    }
    
    
}