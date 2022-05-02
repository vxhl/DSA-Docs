package Trees;

import javax.swing.plaf.synth.SynthSplitPaneUI;

class ConstructPostOrderTree
{
    /*
    inorder[] = {3 1 4 0 5 2}
    preorder[] = {0 1 3 4 2 5}
    Output: 3 4 1 5 2 0
    */
    TreeNode root;
    static TreeNode newNode(int data)
    {
        TreeNode node = new TreeNode(data);
        node.key = data;
        node.left = node.right = null;
        return(node);
    }
    void PostOrderTraversal(TreeNode root)
    {
        if(root==null) return;

        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.key+" ");
    }
    void ConstructPostorder(int[] inorder, int[] preorder, int N)
    {
        N = inorder.length;
        TreeNode root = newNode(preorder[0]);
            
        for(int i: preorder)
        {
            
        }
    }
}