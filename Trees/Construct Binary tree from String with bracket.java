package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class BinaryTreeConstructionStringBracket
{
    TreeNode root;

    static TreeNode newNode(int data)
    {
        TreeNode node = new TreeNode();
        node.key = data;
        node.left = node.right = null;
        return(node);

    }

    void preOrderTraversal(TreeNode root)
    {
        if(root==null) return;
        System.out.println(root.key+ " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    void constructTreeFromString(String expr)
    {
        
        
        for(int i = 0; i<expr.length(); i++)
        {
            if(expr.charAt(i)=='(')
            {
                
            }
        }

    }
}