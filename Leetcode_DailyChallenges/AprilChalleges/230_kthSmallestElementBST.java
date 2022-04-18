package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class kthSmallestBST
{
    // Approach 1: O(N) time complexity for keeping our inorder traveral and O(N) to build it
    public static int kthSmallest(TreeNode root, int k)
    {
        ArrayList<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return vals.get(k-1);
    }
    public static void inorder(TreeNode root, ArrayList<Integer> vals) {
        if(root==null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
    
    // Approach 2: Iterative Inorder Traversal 
    // Here we use a stack. This is a more optimised approach since we do not need to build the entire
    // inorder traversal and we can stop after the kth element thus the time complexity becomes -> O(H+K) since
    // we have to reach the end of the left subtree and then do k pops to find our kth element
    // for balanced tree we get a O(logN+k) for an unbalanced one we get O(N+k)
    // Space complexity here we see is O(H), it can be O(logN) for the balanced tree and O(N) for completely unbalanced tree
    public int kthSmallest2(TreeNode root, int k)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        while(true)
        {
            while(root!=null)
            {
                // We traverse and reach the end of our tree's height
                stack.push(root);
                root = root.left;
            }
            // We then pop our stack as long as our k does not become 0
            root = stack.pop();
            if(--k == 0) return root.val;
            // We the check for our roots right element
            root = root.right;
        }
    }
}