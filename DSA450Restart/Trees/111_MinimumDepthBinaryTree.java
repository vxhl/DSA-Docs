class Solution
{
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return left==0 || right == 0 ? Math.max(left,right)+1: Math.min(left,right)+1;
    
    }   

    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        Deque<TreeNode> q = new ArrayDeque<>();
        int minDepth = 1;
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode currNode = q.poll();
                
                if(currNode.left ==null && currNode.right==null)
                {
                    return minDepth;
                }
                if(currNode.left!=null)
                {
                    q.add(currNode.left);
                }
                
                if(currNode.right!=null)
                {
                    q.add(currNode.right);
                }
            }
            minDepth++;
        }
        
        return minDepth;
    
    }
}