/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {

    Map<TreeNode, TreeNode> parentMap;  
    Set<TreeNode> vis;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        if(target == null) return ans;
        parentMap = new HashMap<>();
        Deque<TreeNode> q = new LinkedList<>();
        // We first need to do a DFS and mark the parent nodes for each node that we have
        
        // Our key will be the current node and the value will be it's parent
        q.add(root);
        parentMap.put(root, null);        
        // 1. We first do a BFS and store all the parents for each node in the parentMap 
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                TreeNode curr = q.poll();

                if(curr.left!=null)
                {
                    q.offer(curr.left);
                   parentMap.put(curr.left, curr); 
                    
                }
                if(curr.right!=null)
                {
                    q.offer(curr.right);
                    parentMap.put(curr.right, curr);
                }
            }
        }
        vis = new HashSet<>();
        Deque<TreeNode> q1 = new LinkedList<>();
        vis.add(target);
        q1.add(target);
        
        BFS(q1,target,k);
        
        while(!q1.isEmpty())
        {
            ans.add(q1.poll().val);
        }
    
        return ans;
    }
    private void BFS(Deque<TreeNode> q,TreeNode target, int k)
    {
        int dis = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            if(dis == k) break;
            dis++;
            while(size-->0)
            {
            TreeNode curr = q.poll();
            
            if(curr.left!=null && !vis.contains(curr.left))
            {
                q.add(curr.left);
                vis.add(curr.left);
            }
            
            if(curr.right!=null && !vis.contains(curr.right))
            {
                q.add(curr.right);
                vis.add(curr.right);
            }
            
            if(parentMap.get(curr)!=null && !vis.contains(parentMap.get(curr))){
                q.add(parentMap.get(curr));
                vis.add(parentMap.get(curr));
            }
        }
        }        
    }

}
    