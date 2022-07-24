/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
import java.util.*;

class Solution {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    private class Pair{
        int hd;
        TreeNode node;
        public Pair(TreeNode node, int hd)
        {
            this.hd = hd;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        // The keys will hold the current vertical order and the List<Integer> will hold all the node in that vertical order
        if(root == null) return new LinkedList<>();
        Map<Integer, List<Integer>> mp = new TreeMap<>();
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        List<Integer> ls = new LinkedList<>();
        ls.add(root.val);
        // We put the current node into the map
        mp.put(0, ls);
        // Now how to keep track of what our current hd is? Let's create structure that holds the node and the hd
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                
                if(curr.node.left!=null){
                    int newHd = curr.hd-1;
                    Pair left = new Pair(curr.node.left, newHd );
                    if(mp.containsKey(newHd))
                    {
                       mp.get(newHd).add(curr.node.left.val);
                    }
                    else
                    {
                        List<Integer> ls1 = new LinkedList<>();
                        ls1.add(curr.node.left.val);
                        mp.put(newHd, ls1);
                    }
                    q.add(left);
                }
                
                if(curr.node.right!=null){
                    int newHd2 = curr.hd+1;
                    Pair right = new Pair(curr.node.right, newHd2);
                    if(mp.containsKey(newHd2))
                    {
                        mp.get(newHd2).add(curr.node.right.val);
                    }
                    else
                    {
                        List<Integer> ls2 = new LinkedList<>();
                        ls2.add(curr.node.right.val);
                        mp.put(newHd2, ls2);
                    }
                    q.add(right);
                }
            }
        }
        
        List<List<Integer>> ans = new LinkedList<>();
        for(int i:mp.keySet())
        {
            ans.add(mp.get(i));
        }

        return ans;

    }
}