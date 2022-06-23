class PathSum1
{
    public boolean PathSumI(TreeNode root, int targetSum)
    {
        // As for our root we return false if it is null
        if(root == null) return false;

        // For our leaf nodes we set the base condition
        if(root.left==null && root.right == null) return targetSum==root.val;

        return PathSumI(root.left, targetSum-root.val) || PathSumI(root.right, targetSum-root.val);
    }


}

class TreeNode
{
    TreeNode left;
    TreeNode right;1
    int val;
    TreeNode() {};
    TreeNode(int val) { this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}