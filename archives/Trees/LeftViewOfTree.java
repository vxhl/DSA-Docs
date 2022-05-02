/*Problem Statement 
Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.

Input : 
                 1
               /   \
              2     3
             / \     \
                      6             
Output : 1 2 6

Input :
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output :1 2 4 5 6
*/

package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode5
{
  int key;
  TreeNode5 left, right;
  TreeNode5(int data)
  {
    key = data;
    left = right = null;
  }
}
class LeftViewBinaryTree
{
  TreeNode5 root;
  static int max_level = 0;
  void QueueLeftView()
    {
      if(root==null)
      {
        return;
      } 
      Queue<TreeNode5> queue = new LinkedList<>();
      queue.add(root);

      while(!queue.isEmpty())
      {
        // Our queue takes in the values for the nodes at the current level
        int n = queue.size();

        // So we now traverse for all the nodes in the current level
        for( int i = 1; i<=n; i++)
        {
          TreeNode5 temp = queue.poll(); // This gets the first element in the queue

          // THen we print the leftmost element of the present lebel
          // We are printing the leftmost element for getting the left view of the tree
          if(i==1)
          {
            System.out.println(temp.key + " ");
          }
          if(temp.left!=null)
          {
            queue.add(temp.left);
          }
          if(temp.right!=null)
          {
            queue.add(temp.right);
          }

        }

      }
    }
       
    public static void main(String args[])
    {
       LeftViewBinaryTree tree = new LeftViewBinaryTree();
       tree.root= new TreeNode5(10);
       tree.root.left= new TreeNode5(2);
       tree.root.right= new TreeNode5(3);
       tree.root.left.left= new TreeNode5(7);
       tree.root.left.right= new TreeNode5(8);
       tree.root.right.right= new TreeNode5(15);
       tree.root.right.left= new TreeNode5(12);
       tree.root.right.right.left= new TreeNode5(14);
       tree.QueueLeftView();
    
      } 
}   
