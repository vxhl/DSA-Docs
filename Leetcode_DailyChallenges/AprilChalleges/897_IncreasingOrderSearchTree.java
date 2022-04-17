package Leetcode_DailyChallenges.AprilChalleges;

class Solution_IOST
{
    /*
    There are two ways to solve this, one being using extra space where we 
    do an inorder traveral of the nodes that yields us the values of the nodes
    in increasing order
    */

    // Approach 1: Using extra space and inorder traveral
    public TreeNode increasingBST(TreeNode root) {
        // In the list we store the values from our inorder traversal
        List<Integer> vals = new ArrayList<>();
        // We perform our inorder traveral using our vals array
        inorder(root,vals);
        // We make a new TreeNode making our new answer 
        TreeNode ans = new TreeNode(0);
        // We send a reference to our current head
        TreeNode curr = ans;
        // For every value in the created inorder list
        for(int v: vals)
        {
            // We set every element in the right as the new element from our list
            curr.right = new TreeNode(v);
            // And then we traverse our tree to the right since we need all our values in the right subtree
            curr = curr.right;
        }
        // We finally just retunr our ans.right
        return ans.right;
    }
    
    public void inorder(TreeNode node, List<Integer> vals)
    {
        if(node==null) return;
        // Our inorder traveral is pretty much the same just this time instead of printing we add the values into a arraylist
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    // Approach 2: Without using our extra arraylist and constructing our answer on the fly
    public TreeNode increasingBST2(TreeNode root)
    {
        // We once again create our node that we created earlier as well 
        TreeNode ans = new TreeNode(0);
        TreeNode curr = ans;
        inorder2(root);
        return ans.right; 
    }

    public void inorder2(TreeNode node)
    {
        if(node== null) return;
        inorder(node.left);
        node.left = null; // This somehow ensures that we have no cycles in our tree? How does that happen??? 
        curr.right = node; // This part i get, we take our dummy node and assign the current node that we are at to the right of it, since this is an inorder traveral
        curr = node; // Then we move our dummy node forward and set it as our node and check for the right of the node, and if we find something, we repeat the same process in that
        // substree, otherwise, we just return and search for the previous leftmost node.
        inorder(node.right); 
        

    }



}