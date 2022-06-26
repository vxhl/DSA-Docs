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
    public TreeNode invertTreeBFS(TreeNode root) {    
        if(root == null) return null;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            // So the very rookie mistake i was doing was just assigning root.left = root.right and then again
            // root.right = root.left which doesn't work cause we have lost the reference for our root.left after doing the previous step
            // so we store root.left/root.right either of them in a temporary TreeNode
            TreeNode curr = q.poll();
            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;
            
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
        return root;
    }
    public TreeNode invertTreeDFS(TreeNode root) { 
        if(root == null) return null;
        
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        
        return root;
    }
    
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null) return null;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.add(root);
        
        while(!st.isEmpty())
        {
            // So the very rookie mistake i was doing was just assigning root.left = root.right and then again
            // root.right = root.left which doesn't work cause we have lost the reference for our root.left after doing the previous step
            // so we store root.left/root.right either of them in a temporary TreeNode
            TreeNode curr = st.pop();
            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;
            
            if(curr.left!=null) st.add(curr.left);
            if(curr.right!=null) st.add(curr.right);
        }
        return root;
    }
    
    
}