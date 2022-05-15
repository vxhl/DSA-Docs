package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
    }
}
class DeepestLeavesSum {

    int maxDepth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        findSum(root, 1);
        return sum;
    }
    
    public void findSum(TreeNode root, int curr)
    {
        if(root!=null)
        {
            if(curr>maxDepth)
            {
                sum = 0;
                maxDepth = curr;
            }
            if(curr == maxDepth)
            {
                sum += root.val;
            }
            
            findSum(root.left, curr+1);
            findSum(root.right, curr+1);
        }
    }
}
