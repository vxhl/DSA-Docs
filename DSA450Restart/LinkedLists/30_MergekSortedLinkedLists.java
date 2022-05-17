package DSA450Restart.LinkedLists;
import java.util.*;

 class MergekSortedLinkedLists {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    
    }
    
    Node mergeTwoLists(Node headA, Node headB)
    {
        
        if(headA.data>headB.data)
        {
            Node tmp = headA;
            headA = headB;
            headB = tmp;
        }
        Node res = new Node(0);
        Node temp = res;
        while(headA!=null && headB!=null)
        {
            if(headA.data<headB.data)
            {
                temp.next = headA;
                headA = headA.next;
            }
            else
            {
                temp.next = headB;
                headB = headB.next;
            }
            temp = temp.next;
        }
        
        if(headA!=null)
        {
            temp.next = headA;
        }
        else
        {
            temp.next = headB;
        }
        
        return res.next;
        
    }
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int k)
    {
        //Add your code here.
        // We need to somehow recursively solves this
        // Let the base condition consider k
        Node curr = arr[0];
        // Node temp = curr;
        for(int i=1; i<arr.length; i++)
        {
            // System.out.print("executed");
            curr = mergeTwoLists(curr, arr[i]);
        }
        
        return curr;
    }


    Queue<Node> q = new PriorityQueue<Node>((a,b)->a.val-b.val);
        // We push only the heads of the linked
        // lists into our priority queue first of all 
        for(Node l: lists)
        {
            if(l!=null)
            {
                q.add(l);
            }
        }
        
        // we make a new dummy node 
        Node newHead = new Node(-1);
        Node point = newHead;
        
        while(!q.isEmpty())
        {
            // We assign the popped smallest node into our newHead
            point.next = q.poll();
            // Move our pointer ahead
            point = point.next;
            // And add the next element into our heap
            if(point.next!=null)
            {
                q.add(point.next);
            }
        }
        
        return newHead.next;
    
}

