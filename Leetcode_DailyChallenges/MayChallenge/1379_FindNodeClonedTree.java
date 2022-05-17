package Leetcode_DailyChallenges.MayChallenge;
// THIS WAS USELESS
class FindNodeClonedTree {
    TreeNode ans, target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target)      {
        
        this.target = target;
        inOrder(cloned, original);
        return ans;
    }
    
    public void inOrder(final TreeNode cloned, final TreeNode original)
    {
        if(original == null)
        {
            return;
        }
        
        inOrder(cloned.left, original.left);
        
        if(original == target)
        {
            ans = cloned;
        }
        
        inOrder(cloned.right, original.right);
        
    }
}
