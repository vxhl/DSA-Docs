/*
Problem Statement:
Print the bottom view of a binary tree.
Example:
      20
    /    \
    8       22
  /   \      \
 5      3      25
      / \      
    10   14

Output: For the above tree the output should be 5, 10, 3, 14, 25.
*/
package Trees;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

// Let us define a Node that takes into account it's horizontal distance as well
class TreeNodehd
{
    int key;
    int hd; 
    TreeNodehd left, right;
    TreeNodehd(int data)
    {
        key = data;
        hd = Integer.MAX_VALUE; 
        left=right=null;
    }
}


class BottomViewTree
{
    TreeNodehd root;

    void bottomViewTraversal()
    {   
        if (root==null)
        {
            return;
        }
        // Horizontal distance 
        int hd = 0; 
        
        // We define a queue for our level order traversal
        Queue<TreeNodehd> q = new LinkedList<TreeNodehd>();
        // We define a Map to store our hd and value pairs 
        Map<Integer, Integer> map = new TreeMap<>();
        // Let us add our horizontal distance to the root
        root.hd = hd;
        // And push it into our queue
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNodehd temp = q.poll(); // We get the headmost element
            hd = temp.hd; // We extract the horizontal distance for the node
            // Now we add hd and the element into out map
            // Note that everytime we encounter an element having the same hd
            // We swap the previous element with the present element
            // Amd thus we reach the bottom most element of the hd
            map.put(hd, temp.key); 

            if(temp.left!=null)
            {
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            
            if(temp.right!=null)
            {
                temp.right.hd = hd+1;
                q.add(temp.right);
            }

        }
        // Now we define the iterator for our map inorder to get the values
        Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        
        while(iterator.hasNext())
        {
            Map.Entry<Integer, Integer> m = iterator.next();
            System.out.print(m.getValue() + " ");
        }
    }
    public static void main(String[] args) 
    {
        BottomViewTree tree = new BottomViewTree();
        tree.root = new TreeNodehd(20);
        tree.root.left = new TreeNodehd(8);
        tree.root.right = new TreeNodehd(22);
        tree.root.left.left = new TreeNodehd(5);
        tree.root.left.right = new TreeNodehd(3);
        tree.root.right.left = new TreeNodehd(4);
        tree.root.right.right = new TreeNodehd(25);
        tree.root.left.right.left = new TreeNodehd(10);
        tree.root.left.right.right = new TreeNodehd(14);
        System.out.println(" The Bottom viw of tree is: ");
        tree.bottomViewTraversal();
    }

}

/*
The Bottom viw of tree is:
5 10 4 14 25
*/