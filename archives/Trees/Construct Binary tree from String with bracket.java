package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class BinaryTreeConstructionStringBracket
{
    TreeNode root;

    static TreeNode newNode(int data)
    {
        TreeNode node = new TreeNode(data);
        node.key = data;
        node.left = node.right = null;
        return(node);

    }
    // Approach 1: For this first find the starting index and end index of
    // each substrng
    // To find the index of the closing parethesis of left subtree substring, use a 
    // stack. Let the found index be stored in index variable
    
    // First let us define the preorder traversal for the converted string
    static void preOrderTraversal(TreeNode root)
    {
        if(root==null) return;
        System.out.print(root.key+ "->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    // Now we define the conversion function
    static int findIndex(String expr, int si, int ei)
    {  
        if(si>ei) return -1;

        // Let us define a stack to find index of closing parenthesis
        Stack<Character> s = new Stack<>();
        // Here ei is simply the length of our expression and si is the start index
        for(int i=si; i<=ei; i++)
        {
            if(expr.charAt(i)=='(') s.add(expr.charAt(i));
            else if(expr.charAt(i)==')')
            {
                if(s.peek()=='(')
                {
                    s.pop();
                    if(s.isEmpty()) return i;
                }
            } 
        }

    return -1;
    }

    static TreeNode treeFromString(String expr, int si, int ei)
    {
        //Base Case
        if(si>ei) return null; // If our start index is greater than the length of the expr

        // We first get the node for the starting element
        // Example: '1(2)(3)' -> Here we define our 1 as root
        TreeNode root = newNode(expr.charAt(si)-'0');
        int index = -1;

        // If our next character after the root is'(' find the index of
        // its complement ')' ,i.e, we get the first subtree si and ei

        if(si+1<=ei && expr.charAt(si+1)=='(')
        {   
            // We call our findIndex function to get the ei for our subtree
            index = findIndex(expr, si+1, ei);
        }
        if(index!=-1) // That is our index is found
        {
            // We first call for left subtree recursively
            // We do si+2 and index-1 since at si+1 and index we have the parenthesis indices
            // And we do not want to make them part of our subtree
            root.left = treeFromString(expr, si+2, index-1);
            // Similarly we start our right subtree
            // We do index+2 since at index+1 we have the starting open parenthesis
            root.right = treeFromString(expr, index+2, ei-1);
        }
        
        return root;
    }
    public static void main(String[] args) {
        String expr = "4(2(3)(1))(6(5))";
        System.out.print("The required binary tree from the given expression " + expr + " is: " );
        TreeNode root = treeFromString(expr, 0, expr.length()-1);
        preOrderTraversal(root);

    }
}