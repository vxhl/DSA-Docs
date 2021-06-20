// Problem Statement : Implement the Iteratieve DFS approach for Preorder, Postorder and Inorder traversals for binary tree.
//Time complexity : O(N)

package Trees;
import java.util.Stack;

class TreeNode 
    {
        int key;
        TreeNode left,right;
        TreeNode(int data)
        {
            key = data;
            left = right = null;
        }
    }

class IterativeBinaryTree
    {   
        TreeNode root;

        // Implementing Iterative inorder 
        void IterativeInorder()
        {
            if (root==null) // First we check for the corner cases
            {
                return;
            }

            Stack<TreeNode> s = new Stack<TreeNode>(); // Then let us define a new stack
            TreeNode curr = root; // And initialise curr as root
            while(curr != null || s.size() >0 ) // As long as current is not null and the stack is not empty
            {
                while(curr!=null) 
                {
                    s.push(curr); // We push the current node into the stack
                    curr = curr.left; // And then we traverse the left subtree
                }
                curr = s.pop(); // After we have traversed all of the left subtree we pop each element ( which will always be a left subtree element and print them 
                System.out.print(curr.key + " ");
                curr = curr.right; // After printing the said left subtree element we check if that node had anything in it's right. If it does, in the next iteration we print 
                // THe right element and push it into the stack otherwise we return null.
            }
        }

        void postOrderIterative(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            while(true) {
                while(root != null) {
                    stack.push(root);
                    stack.push(root);
                    root = root.left;
                }
                 
                // Check for empty stack
                if(stack.empty()) return;
                root = stack.pop();
                 
                if(!stack.empty() && stack.peek() == root) root = root.right;
                 
                else {
                     
                    System.out.print(root.key + " "); root = null;
                }
            }
        }
        void IterativePreOrder(TreeNode root)
        {
            // We first create a node stack and push the root into the stack
            Stack<TreeNode> nodeStack = new Stack<TreeNode>();
            nodeStack.push(root);
            while(!nodeStack.isEmpty())
            {
                TreeNode myNode = nodeStack.pop();
                System.out.print(myNode.key + " ");
                if(myNode.right!=null)
                {
                    nodeStack.push(myNode.right);
                }
                if(myNode.left!=null)
                {
                    nodeStack.push(myNode.left);
                }
            }
        }
         
        public static void main(String[] args) {
            IterativeBinaryTree tree = new IterativeBinaryTree();
            tree.root = new TreeNode(1);
            tree.root.left = new TreeNode(2);
            tree.root.right = new TreeNode(3);
            tree.root.left.left = new TreeNode(4);
            tree.root.left.right = new TreeNode(5);
            System.out.print(" The Iterative Inorder traversal is : ");
            tree.IterativeInorder(); 
            
            System.out.print(" The Iterative postOrder traversal is : ");
            tree.postOrderIterative(tree.root);
            
            System.out.print(" The Iterative preOrder traversal is : ");

            tree.IterativePreOrder(tree.root);
        }
    }

