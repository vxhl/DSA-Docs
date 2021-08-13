/*
Problem Statement: 
Merge two sorted linked lists
For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, 
then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
*/
package LinkedLists;

public class MergeTwoSortedLinkedLists
{    
class node
{
    int data;
    node next;
    node(int d)
    {
        data = d;
        next = null;
    }

}
node Merge(node p, node q, node sorting)
{
    node new_head = null;
    if(p==null) return q;
    if(q==null) return p;

    if(p && q)
    {
        if(p.data <= q.data)
        {
            
        }
    }
}

}
