import java.util.ArrayDeque;
import java.util.Deque;

public class Dfs_traversals {
    class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val)
        {
            data = val;
            left = right = null;
        }
    }


    // Depth First Traversals
    void preOrderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void postOrderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    void inOrderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }


    // iterative preOrder traversal
    // For this approach which is faster, we can use a stack insead. 

    void iterativePreOrder(TreeNode root)
    {
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode popped = st.peek();
            st.pop();
            System.out.print(popped.data + " ");
            if(popped.right!=null)
                st.push(popped.right);
            if(popped.left!=null)
                st.push(popped.left);
        }
    }
    void iterativeInorder(TreeNode root)
    {
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        TreeNode curr = root;
        while(true)
        {
            // Now we need to first print the left most nodes so
            // As long as our node is not null we traverse till the end of
            // left subtree and add them into the stack
            if(curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                // When we have finally reached the last left element of
                // the tree
                // If we find our stack to be empty we break
                if(st.isEmpty())
                {
                    break;
                }
                // We print out all the left element from the subtree
                curr = st.pop();
                System.out.println(curr.data);
                // And we check whether there are node present in the right subtree
                // If there are then we again start iterating till we reach the last left node
                // of the right subtree and do the same operations until our stack becomes empty and
                // we break out of the loop.
                curr = curr.right;
            }

        }
    }

    void IterativePostOrder2Stack(TreeNode root)
    {
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();

        st1.push(root);
        while(!st1.isEmpty())
        {
            // We first pop from our stack and store it in root
            root = st1.pop();
            // We then add the left element into our second stack
            st2.add(root);
            // If we have a left child we push it into the first stack
            if(root.left!=null) st1.push(root.left);
            // If we have a right child we push it again
            if(root.right!=null)st1.push(root.right);
        }
        // Now on the second iteration of the stack we pop out the right element of root
        // and push it into the second stack so it'll be -> root -> right -> left
        // So when we finally pop it all out, it'll be left->right->root

        while(!st2.isEmpty())
        {
            System.out.print(st2.pop().data);
        }
    }


    // HARD 
    // Now this is very tricky. The trick all lies within curr, temp and ofc the one stack
    void IterativePostOrder1Stack(TreeNode root)
    {
        // We start from the root as usual
        TreeNode curr = root;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(curr!=null || !st.isEmpty())
        {
            // Now we traverse all the way till the left end of the tree till our curr becomes null
            if(curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                // Once our curr becomes null, we then set a new variable temp that checks on the right child of the subtree on the top of the stack
                // meaning we are checking whether we are still truly at the leftmost end of the tree
                TreeNode temp = st.peek().right;

                // If we find that we are indeed at the end of the tree, we do the following
                if(temp==null)
                {
                    temp = st.peek();
                    st.pop();
                    System.out.print(temp.data); 
                    while(!st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.peek();
                        st.pop();
                        System.out.println(temp.data);
                    }   
                }
                else
                {
                    curr = temp;
                }
            }
        }
    }


}
