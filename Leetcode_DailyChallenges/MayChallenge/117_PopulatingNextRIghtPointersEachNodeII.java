package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;

class PopulatingNextRIghtPointersEachNodeII {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            Node nextRight = null; // This will get reset on level change, after the first iteration
            // we had nextRight as head but since that was the only node on the level we start over with a new reference
            while(size-->0)
            {
                Node head = q.poll();
                // We set the polled nodes next to whatever we have in our reference node in the first iteration
                // ofc it will be null for the root
                head.next = nextRight;
                // We then set the reference as the element that was just set
                nextRight = head; // We update it
                if(head.right!=null)
                {
                    q.offer(head.right);
                }
                if(head.left!=null)
                {
                    q.offer(head.left);
                }
            }
        }
        
        return root;
        
        
        
    }
}
