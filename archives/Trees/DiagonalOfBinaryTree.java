/*
Problem Statement: Find the diagonal of a binary tree
Example:
          20
        /    \
      8      22
    /   \      \
    5    3      25
        / \      
      10    14
The Diagonal Traversal is: 
20 22 25
8 3 14
5 10

*/
package Trees;
import java.util.LinkedList;
import java.util.Queue;

class DiagonalTree
{
    TreeNode root;
    
    void DiagonalTraversal()
    {
        if(root==null) return;
        
        // We define a queue to keep track of the diagonals
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            
            // For keeping track of the diagonals in the queue
            if(temp==null) 
            {
                q.add(null); 
                temp = q.poll();
                // When tracked all the diagonals we break
                if(temp==null) break; 
            }
            while(temp!=null)
            {
                System.out.print(temp.key + " ");
                // We add the queue when we have a left child and later we pop from the queue and traverse it's right child if any, otherwise we print. 
                if(temp.left!=null) q.add(temp.left); 
                temp = temp.right; 
            }
        }
    }
    public static void main(String[] args) {
        DiagonalTree tree = new DiagonalTree();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(6);
        tree.root.right.right = new TreeNode(14);
        tree.root.right.right.left = new TreeNode(13);
        tree.root.left.right.left = new TreeNode(4);
        tree.root.left.right.right = new TreeNode(7);
        System.out.println("The diagonal traversal for the tree is: ");
        tree.DiagonalTraversal();
    } 
}
/*
The diagonal traversal for the tree is:       
8 10 14 3 6 7 13 1 4
*/