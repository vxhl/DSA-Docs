import java.util.*;

public class Bfs_traversals {

    public class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode(int val)
        {
            data = val;
            left = right = null;
        }
    }


    // Level Order Traversal
    /*
     * We will be needing a queue to store the nodes level wise
     * First we put the root in the queue
     * Now if on the left on the node, if we have left or right childs, we take them
     * out and put them into our queue data structures. 
     * In the next iteration we take the poll from the queue and put them into our
     * queue and then after our iteration is done we put them into our arraylist
     * as our current level order traversal
     * 
     */

     public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> levelOrderTraversals = new ArrayList<>();
        if(root == null) return levelOrderTraversals;
        q.add(root);
        while(!q.isEmpty())
        {
            int levelNum = q.size();  
            List<Integer> level = new ArrayList<>();         
            for(int i=0; i<levelNum; i++)
            {
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                level.add(q.poll().data);
            }
            levelOrderTraversals.add(level);
        }
        return levelOrderTraversals;
     }



     public static void main(String[] args) {
        Bfs_traversals bf = new Bfs_traversals();
        TreeNode root = bf.new TreeNode(1);
        root.left = bf.new TreeNode(2);
        root.right = bf.new TreeNode(3);
        root.left.left = bf.new TreeNode(4);
        root.left.right = bf.new TreeNode(5);
        root.right.left = bf.new TreeNode(6);
        root.right.right = bf.new TreeNode(7);

        for(int i=0; i<levelOrderTraversal(root).size(); i++)
        {
            for(int j=0; j<levelOrderTraversal(root).get(i).size(); j++)
            {
                System.out.print(levelOrderTraversal(root).get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
