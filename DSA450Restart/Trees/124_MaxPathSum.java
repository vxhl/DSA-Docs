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
   public int maxPathSum(TreeNode root) {
       if(root == null) return 0;
       // We can either use an integer array for the value or we can use a non static global variable to get the answer
       int[] maxPath = new int[1];
       maxPath[0] = Integer.MIN_VALUE;
       max_gain(root, maxPath);
       return maxPath[0];   
   }
   
   private int max_gain(TreeNode root, int[] maxPath)
   {
       // When we find our root to be null we can just return the gain to be 0
       if(root == null) return 0;
        
       /* 
        * For our current node if we look at our left and right subtrees, we get the sum of the nodes that we have on our left and right
        subtrees, and if that sum is smaller than 0, then we just get 0 as the gain, and if it is greater than 0 then we just take that
        */
       int gainLeft = Math.max(max_gain(root.left, maxPath),0);
       int gainRight = Math.max(max_gain(root.right, maxPath),0);
       
       // So our total current path we get is the following
       int currentMaxPath = root.val+gainLeft+gainRight;

       // We finally get the maxPath between the two paths
       maxPath[0] = Math.max(maxPath[0], currentMaxPath);
       
       // We return our current root's value and the max gain we can get from our left and right subtrees.
       return root.val+Math.max(gainLeft, gainRight);
   }
}

