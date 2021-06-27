// Problem Statement: Print the Vertical Order Traversal for the given tree
/* Example: 
          1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
              
The output of print this tree vertically will be:
4 -> -2
2 -> -1
1 5 6 -> 0
3 8 -> 1
7 -> 2
9 -> 3
*/
package Trees;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

class Values
{
    int max, min;
}
class VerticalOrderTree
{
    TreeNode root;
    Values val = new Values();
    // ===========================================================================================================================================================
    // Approach 1: Using Recurssion and Divide and conquer
    // T(N) -> O(N^2) 
    // We first define a utility function to find the min and max distances from the root
    void findMinMax(TreeNode temp, Values min, Values max, int hd)
    {
        // Base Case
        if(temp==null) return;

        // With respect to root we find the min and max values
        if(hd<min.min) 
        {
            min.min = hd;  // We asign the lowest value of hd we get from left subtree as min
        }
        else if(hd>max.max)
        {
            max.max = hd; // Similarly for the right subtree
        }
        // We recur the left and right subtrees
        findMinMax(temp.left, min, max, hd-1);
        findMinMax(temp.right, min, max, hd+1);
    }

    // Utility Function for printing the nodes on a given level
    void printVerticalOrder(TreeNode temp, int vline, int hd)
    {
        if(temp==null) return;  

        // If node is on the given line number
        if(hd==vline)
        {
            System.out.print(temp.key + " ");
        }
        printVerticalOrder(temp.left, vline, hd-1);
        printVerticalOrder(temp.right, vline, hd+1);    
    }

    // We make the main function that prints a given binary tree in
    // vertical order
    void verticalOrderTraversal()
    {
        // First we find the min max with respect to our root node
        findMinMax(root, val, val, 0);

        // We iterate through all possible vertical lines starting
        // from leftmost and print the nodes 
        for(int line_no = val.min; line_no <= val.max; line_no++)
        {
            printVerticalOrder(root, line_no, 0);
            System.out.print("");
        } 
    }
    // ===========================================================================================================================================================
    // Approach 2: Map Based Method | Time Complexity: O(N)
    // Utility function to store the line number and the corresponding nodes
    // In a tree
    void MapVerticalOrder(TreeNode root, int hd, TreeMap<Integer, Vector<Integer>> m)
    {
        if(root==null) return;

        // We get the vector list at hd
        Vector get = m.get(hd);

        // Store the current node in the map
        if(get==null)
        {
            get = new Vector<>();
            get.add(root.key);
        }
        else
        {
            get.add(root.key);
        }
        m.put(hd, get);
        // Now we recur to add the nodes for left and right subtrees
        MapVerticalOrder(root.left, hd-1, m);
        MapVerticalOrder(root.right, hd+1, m);
    }
    void printMapVerticalOrder()
    {
        // We create a map and store vertical order in map using the MapVerticalOrder() function
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0; // Since we are initially at root node
        MapVerticalOrder(root, hd, m);

        // For printing the node at every horizontal distance
        for(Entry<Integer, Vector<Integer>> entry: m.entrySet())
        {
            System.out.print(entry.getValue());
        }
    }


    // Driver program to test the above functions
    public static void main(String args[]) 
    {
        VerticalOrderTree tree = new VerticalOrderTree();
   
        /* Let us construct the tree shown in above diagram */
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);
        tree.root.right.right.right = new TreeNode(9);
   
        System.out.print("Vertical order traversal without Map : ");
        tree.verticalOrderTraversal();
        System.out.println();
        System.out.print("Vertical order traversal without Map : ");
        tree.printMapVerticalOrder();

    }

}

