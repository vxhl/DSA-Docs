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
        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();
        pStack.add(p);
        qStack.add(q);
        
        while(!pStack.isEmpty())
        {
            p = pStack.poll();
            q = qStack.poll();
            
            if(!check(p,q)) return false;
            if(p!=null)
            {
                if(!check(p.left, q.left)) return false;
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