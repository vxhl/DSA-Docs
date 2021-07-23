/*
Problem Statement:
Given a linkedlist of N nodes. Check if it has a loop
Input:
N = 3
value[] = {1,3,4}
x = 2
Output: True
Explanation: In above test case N = 3.
The linked list with nodes N = 3 is
given. Then value of x=2 is given which
means last node is connected with xth
node of linked list. Therefore, there
exists a loop.
*/

package LinkedLists;

import java.util.HashSet;

public class DetectLoopInLinkedList 
{
    static NODE head;
    static class NODE
    {
        int data;
        NODE next;
        NODE(int key)
        {
            key = data;
            next = null;
        }
    }
    static boolean detectloop(NODE head)
    {
        HashSet<NODE>s = new HashSet<NODE>();
        while(head!=null)
        {
            if(s.contains(head))
            {
                return true;
            }
            s.add(head);
        }
        return false;
    }
    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        NODE new_node = new NODE(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    public static void main(String[] args) {
        DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
 
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        if (detectloop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}
