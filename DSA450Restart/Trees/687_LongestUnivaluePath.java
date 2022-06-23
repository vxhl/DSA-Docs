class LongestUnivaluePath {
    int maxPath=0;
    public int longestUnivaluePath(TreeNode root) {
        // So each node in the path needs to have the same value. And we may or may not pass from the root
        // root.left.val == root.val and root.right.val == root.val
        if(root==null) return 0;
        helper(root, root.val);
        return maxPath;
    }
    
    private int helper(TreeNode root, int prev_val)
    {
        // If our root is null we simply return 0 
        if(root == null) return 0;
        // Now we pass the previous nodes value with the left and right subtrees to find the path
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        
        // We calculate the maximum between our previous and currentPath
        // we take left+right because left+right holds three cases
        maxPath = Math.max(maxPath, left+right);
        
        // Our prime condition where we compare our previous value with the current value
        // We get 1 + the max of our left and right for the current node. 
        if (prev_val == root.val) return 1+Math.max(left, right);
        return 0;
        
    }    
}
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
