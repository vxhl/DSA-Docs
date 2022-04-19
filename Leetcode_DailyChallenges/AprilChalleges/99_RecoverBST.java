package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class Recover_BST
{
    /*
        Brute Force? How do your brute force on trees.
        I thought of this but didn't feel possible, basically ->
        I take the incorrect tree and apply inorder traveral on it, we will
        find that inorder traversal to be incorrect so we sort the traversal and then
        return a new tree that is derived from that sorted/corrected inorder
        traversal

        T.C -> O(2*N) + O(NLogN)
        S.C -> O(N)

        Optimal Solution
        Like since we know that in an inorder traversal all the elements are sorted
        and we only need to swap two elements, we can do a binary search and
        that reduce our time complexity to O(2N) + O(logN) But the problem is this only works if there is a adjacent violation
        Otherwise it doesn't like a binary search won't work. We can find the unbalanced elements in the two halves using two binary searches for both halves as we
        did in findkinRotatedSortedArray, but that won't work here right? Actually it will, like if we have let's say
        p1 and p2 are the two elements we get from the two sorted arrays 
        
        Now if p1<0 || p2<0 then we do only one of the two elements and swap let's say p1+1 and p1 or p2+1 and p2
        otherwise if both are greater than 0 we swap p1 and p2 positions in the array, so that sounds like it will work atleast.
        
        We basically find the peak and we find the dip and we swap them. 

        More ways to optimise this? Idk, let's think

        OK couldn't find one but here's a solution from the net

        We have two cases ->
        1 3 2 4 5 where our violating nodes are adjacent
        1 2 5 4 3 where our violating nodes are non adjacent
        
        For case 1: 
        We traverse through our nodes and check whether our current node is smaller than the previous node, if it is then we set our 
        first as our previous node since it violates the property and we set our curr node as the middle, we then swap them and get the correct substree

        FOr case 2:
        We do the same procedure for finding the first and the middle, but this time, we have another violating node at the end of teh tree, so 
        we traverse till the end and keep checking our property and set our last as the current element same way as we did for the middle element. Basically we set a new middle element
        We then swap those

        We ofc do this by runing an inorder traversal since we need to look thrught a sorted tree for this algorithm to work.

        

    */

    TreeNode prev;
    TreeNode last;
    TreeNode middle;
    TreeNode first;
    
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        // We set out prev as the minimum value since it is at the end of the subtree and is the smallest value in the subtree
        prev = new TreeNode(Integer.MIN_VALUE);
        // We run our preprocessed inorder traversal throughout our root
        inorder(root);
        // If we find non adjacent violating nodes then we swap those but if these don't exist
        if(first!=null && last !=null)
        {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        // Then we simply swap our adjacent violating nodes
        else if(first!=null && middle !=null)
        {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
        
        
    }
    
    
    public void inorder(TreeNode root) {
        if(root==null)
        {
            return;
        }
        
        inorder(root.left);
        
        // If our current value is smaller than the previous value, then we have found our violating pairs
        if(prev!=null && root.val < prev.val)
        {
            // If we have not already set our first pair then we set them as
            if(first==null)
            {
                // Our first one as prev amd the middle as root. 
                // If we do not find any more violating pairs, we will swap these
                first = prev;
                middle = root;
            }
            else
            {
                last = root;
            }
        }
        // Before we do our right subtree, we set our prev as the current root
        prev = root;
        inorder(root.right);
        
    }

}

class TreeNode
{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}
