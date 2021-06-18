// Problem Statement : 
package CodeWithScaler.Week3;

public class PathSum {
    
    class TreeNode
    {
        int key;
        TreeNode left,right;
        public int data;
        TreeNode(int data)
        {
            key = data;
            left = right = null;
        }
    }
    public int hasPathSum(TreeNode A, int B) {
        if(A==null)
        {
            return 0;
        }
        if(A.left==null && A.right==null)
        {
            if(B-A.key == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        B -= A.key;
        return Math.max(hasPathSum(A.left,B), hasPathSum(A.right,B));
    }
}
