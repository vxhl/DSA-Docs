public class Solution {
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