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
class Solution {
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val)
        {
            this.left=left;
            this.right =
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<preorder.length; i++)
        {
            mp.put(preorder[i], i);
        }
        return helper(0, preorder.length-1, preorder, mp);
    
    }
    
    public TreeNode helper(int start, int end, int[] preorder, Map<Integer, Integer> mp)
    {
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int rootIndex = mp.get(root.val);
        int split=rootIndex+1;
        while(split<preorder.length && preorder[split]<root.val)
        {
            split++;
        }
        
        root.left = helper(rootIndex+1, split-1, preorder, mp);
        root.right = helper(split, end, preorder,mp);
        return root;
    }
}