class Solution1 {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) return ans;
        ans.add(root.val);
        if(root.left == null && root.right==null) return ans;

        dfsLeft(root.left);
        dfsLeaf(root);
        dfsRight(root.right);
        return ans;

            
    }
    private void dfsLeaf(TreeNode root)
    {
        if(root == null) return;

        if(root.left == null && root.right == null)
        {
            ans.add(root.val);
            return;
        }
        dfsLeaf(root.left);
        dfsLeaf(root.right);
    }
    private void dfsLeft(TreeNode root)
    {
        if(root == null || (root.left == null && root.right == null)) return;
        
        ans.add(root.val);
        if(root.left!=null)
        {
            dfsLeft(root.left);
        }
        else
        {
            dfsLeft(root.right);
        }
    }

    private void dfsRight(TreeNode root)
    {
        
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right!=null)
        {
            dfsRight(root.right);
        }
        else
        {
            dfsRight(root.left);
        }
        ans.add(root.val);
    }
}



class Solution2 {
    /**
     * @param root: a TreeNode
     * @return: return a list of integer
     */
    List<Integer> ans = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return ans;
        ans.add(root.val);
        dfs(root.left, true, false);
        dfs(root.right, false, true);
        return ans;
    }

    public void dfs(TreeNode root, boolean lft, boolean rgt) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }
        if (lft)
            ans.add(root.val);// 左边界
        dfs(root.left, lft, rgt && root.right == null);
        dfs(root.right, lft && root.left == null, rgt);
        if (rgt)
            ans.add(root.val);// 右边界
    }
}