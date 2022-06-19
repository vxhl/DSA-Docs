import java.util.*;
class Solution {
    public boolean isSymmetric2(TreeNode root) {
        
        if(root == null || (root.left==null && root.right==null)) return true;
        if(root.left!=null && root.right!=null)
        {
        if(root.left.val == root.right.val)
        {
            return check(root.left, root.right);
        }
        }
        return false;
    }
    
    public boolean check(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val!=root2.val) return false;    
        return check(root1.left, root2.right) && check(root1.right, root2.left);
        
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
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
        left = right = null;
    }
}