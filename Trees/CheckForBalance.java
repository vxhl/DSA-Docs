/*
Problem Statement: Find if the tree is balanced or not
*/
package Trees;

class BalancedorNotTree
{   
    TreeNode root;
    int Height(TreeNode root)
    {
        if(root==null) return 0;
        int lheight = Height(root.left);
        int rheight = Height(root.right);
        if(lheight>rheight)
        {
            return (lheight+1);
        } 
        else return rheight+1;
    }
    boolean BalancedorNot()
    {
        if(root==null) 
            return false;
        if(Height(root.left)==Height(root.right))
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        BalancedorNotTree tree = new BalancedorNotTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(6);
        
        if (tree.BalancedorNot())
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

