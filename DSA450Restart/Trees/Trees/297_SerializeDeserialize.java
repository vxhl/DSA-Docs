/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    static String nulls = "X";
    static String splitter = ",";
    // Encodes a tree to a single string.
    
    // Our serialisation happens with the help of DFS where everytime we encounter a null
    // we add the null string and the splitter
    
    // And we do a preorder traversal where we first add the value for the node and then move on with the left
    // and the right subtrees
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) 
    {
        if(root == null)
        {
            sb.append(nulls).append(splitter);
        }
        else{
        sb.append(root.val).append(splitter);
        buildString(root.left, sb);
        buildString(root.right, sb);
        }
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>(); 
        q.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(q);
    }
    
    private TreeNode buildTree(Deque<String> q)
    {
        // We use the queue to store the preorder traversal that we got from data, and we keep polling it
        // every time we find null values we return null, otherwise we form the tree in preorder traversal fashion.
        String val = q.poll();
        if(val.equals(nulls))
        {
            return null;
        }
        else
        {
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
        }
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));