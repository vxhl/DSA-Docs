import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
    static class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val)
        {
            left=  right = null;
            this.val = val;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        // It seems as though the last child of every level order traversal holds the right view of the tree? 
        // Well we can find the current level and then reverse it to find the answer
        // That will take a time complexity of BFS so O(V+E)
        
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null) return rightSideView;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size-->0)
            {
             
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left!=null) 
                {
                    // level.add(curr.left.val);
                    q.add(curr.left); 
                }
                if(curr.right!=null)
                {
                    // level.add(curr.right.val);
                    q.add(curr.right);
                }
            }
            rightSideView.add(level.get(level.size()-1));
        }
        
        return rightSideView;
    }
}
