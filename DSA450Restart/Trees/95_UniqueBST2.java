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
import java.util.*;
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
    public List<TreeNode> generateTrees(int n) {
        return generatingTreesHelper(1, n);
    }
    
    List<TreeNode> generatingTreesHelper(int start, int end)
    {
        List<TreeNode> ans = new ArrayList<>();
        if(start>end)
        {
            // So what we need to remember here is that as we reach our base conditions
            // we return whatever we have from our base conditions
            // in this case we got null so ofc it is just logical that our answer will contain null right.
            ans.add(null);
            return ans;
        }
        if(start==end)
        {
            // Same goes for when we have a node.
            // when we have it, we add it. and we return
            ans.add(new TreeNode(start));
            return ans;
        }
        
        for(int i=start; i<=end; i++)
        {
            // We then call the two sides recursively
            List<TreeNode> leftList = generatingTreesHelper(start, i-1);
            List<TreeNode> rightList = generatingTreesHelper(i+1, end);
            
            for(TreeNode leftSubTree: leftList)
            {
                for(TreeNode rightSubTree: rightList)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}