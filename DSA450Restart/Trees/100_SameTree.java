import java.util.*;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    boolean check(TreeNode p, TreeNode q)
    {
        if(p==null && q==null)
        {
            return true;
        }
        if(p==null || q==null)
        {
            return false;
        }
        if(p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(!check(p,q)) return false;
        // We take two queues for each tree
        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();
        pStack.add(p);
        qStack.add(q);
        
        while(!pStack.isEmpty())
        {
            p = pStack.poll();
            q = qStack.poll();
            // We poll and check for each node 
            if(!check(p,q)) return false;
            // And then we add the following into our queue if our curr node is not null
            if(p!=null)
            {
                if(!check(p.left, q.left)) return false;
                // Similarly we do for our left and right subtrees for both nodes and we're donef
                if(p.left!=null){
                    pStack.add(p.left);
                    qStack.add(q.left);
                }
                
                if(!check(p.right, q.right)) return false;
                if(p.right!=null)
                {
                    pStack.add(p.right);
                    qStack.add(q.right);
                }
            }
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
    }
}