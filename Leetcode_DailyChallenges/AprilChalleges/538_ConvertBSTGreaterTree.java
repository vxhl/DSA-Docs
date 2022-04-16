package Leetcode_DailyChallenges.AprilChalleges;

class Solution_BSTGTree
{

    /*
    Now this one has a LOT going on. Actually all tree problems do but this
    looks deceptively simple. 
    
    Ok so first we check for our root is not null, as it's not, we start a recursion for our 
    1. right subtree
    We keep traversing our right subtree and after we reach our null, we return for the root.right.right node which here is 7
    we add the value of root.r.r to our sum and assign it to our root.r.r.val = 7; which ofc has no change as of now

    Now we move on to our root.r.r.l substree which ofc does not exist so we return 
    Now we are at the root.right so we calculate the sum+=root.r.val and since our previous value was 7 now we get 12 as our sum
    and assign it to our root.r.val = 12

    similarly we move forward and look at root.r.l and find another node 4 in it so we add 12+4=16 and assing the value to root.r.l node and then we return and 
    come back finally to our root, as we are at the root, our current sum value is 16, so our new roots value becomes 16+3  -> 19

    and then do the same process that we have done for the right substree for the next 2. Left Substree

    Below we can see the output of the process we have carried out 

        3                         19
    1       5        =>     20        12                         
         4     7                  16     7
    */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null)
        {
            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);
        }
        
        return root;
    }
}