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


/**
 * This can be difficult to understand, as maxDepth is a bit
 * of a cheeky function. MaxDepth is basically a simple height()
 * function, finding the height of a tree rooted at the given node.
 *
 * What makes it clever is as it is doing this, it is also
 * adding taking the computed heights of it's subtrees to find the
 * maximum diameter that passes through the given node as a root.
 * If this is the global maximum diameter, it updates the class member.
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
    int maxPath = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxPath;
    }
    
    // Our helper method is pretty simple, all it return is the maximum height for the current node between the left and right subtrees
    public int helper(TreeNode root)
    {
        
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        // The clever part is when we get our maxPath, we basically get left+right, meaning the total of all the edges that
        // pass through the current node that we passed, and we keep updating it
        maxPath = Math.max(maxPath, left+right);
        
        // maxPath has no influence on what we return using the helper method, but it does influence our actual result
        // We do 1+Math.max(left,right) because we are getting the maximumDepth for the current node between the left and right subtrees.
        return 1+Math.max(left,right);
    }
    

}