/* Problem Statemement:
Get the mirror traversal for a given binary tree
Example:
Input:
        5
       / \
      3   6
     / \
    2   4
Output:
Inorder of original tree: 2 3 4 5 6 
Inorder of mirror tree: 6 5 4 3 2
Mirror tree will be:
  5
 / \
6   3
   / \
  4   2

As we can see mirror of a binary tree is reverse of the inorder traversal
*/
package Trees;
import java.util.*;

class TreeNode4
{
    int key;
    TreeNode4 left, right;
    TreeNode4(int data)
    {
        key = data;
        left = right = null;
    }
}
class MirroredBinaryTree
{
    TreeNode4 root;

    // Approach 1: We use a 2nd node and pop from it in the end to get the reverse of inorder
    void MirrorOfBinaryTree()
    {
        // Let us first define our stack
        Stack<TreeNode4> s = new Stack<TreeNode4>();
        // We then define a second stack into which we push our stack elements
        Stack<Integer> s1 = new Stack<Integer>();
        TreeNode4 curr = root;
        while(curr!=null || s.size()>0)
        {
            while(curr!=null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            s1.push(curr.key);
            curr = curr.right;
        }
        System.out.print("|-> The Mirror of the binary tree using two stacks is: ");
        while(!s1.isEmpty())
        {
            System.out.print(s1.pop() + " ");
        }
    }

    // Approach - 2
    // Using Swapping
    void MirrorOfBinaryTreeSwappingQueue()
    {
        Queue<TreeNode4> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode4 curr = q.poll(); // To get the headmost element from the tree
            TreeNode4 temp = curr.left;
            curr.left = curr.right; // We swap the trees
            curr.right = temp;
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        MirroredBinaryTree tree = new MirroredBinaryTree();
        tree.root = new TreeNode4(1);
            tree.root.left = new TreeNode4(2);
            tree.root.right = new TreeNode4(3);
            tree.root.left.left = new TreeNode4(4);
            tree.root.left.right = new TreeNode4(5);
            
            System.out.print(" The Iterative Inorder traversal is : ");
            tree.MirrorOfBinaryTree();
            //tree.MirrorOfBinaryTreeSwappingQueue();
            tree.MirrorOfBinaryTreeSwappingQueue();
            System.out.println("|-> The Mirror of the already mirrored binary tree using swapping and queue" );
            tree.MirrorOfBinaryTree();
    }
}
/*
The Iterative Inorder traversal is : 4 2 5 1 3 |-> The Mirror of the binary tree using two stacks is: 3 1 5 2 4 |-> The Mirror of the already mirrored binary tree using swapping and queue
3 1 5 2 4 |-> The Mirror of the binary tree using two stacks is: 4 2 5 1 3
*/