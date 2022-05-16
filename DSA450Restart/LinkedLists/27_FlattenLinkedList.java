package DSA450Restart.LinkedLists;



class flattenList
{
    static class node
    {
        int data;
        node next;
        node bottom;

        node(int data)
        {
            this.data = data;
        }
    }    

    public static node mergeTwoList(node headA, node headB)
    {
        node res = new node(0);
        node temp = res; // We use this to traverse and see where we need to break and join the links

        while(headA!=null && headB!=null)
        {
            if(headA.data<headB.data)
            {
                // We assign that element into our new node
                temp.bottom = headA;
                // We then move our temp forward
                temp = temp.bottom;
                // And we also move our headA forward
                headA = headA.bottom;
            }
            else
            {
                temp.bottom = headB;
                temp = temp.bottom;
                headB = headB.bottom;
            }    
        }
        if(headA!= null)
        {
            temp.bottom = headA;
        }
        else
        {
            temp.bottom = headB;
        }

        return res.bottom;
    }

    public static node flatten(node root)
    {
        // Now for the recursion for the lists
        if(root == null || root.next == null)
        {
            return root;
        }
        // We first recur for the list on the right and flatten it, this will recur till the end of the linkedlist
        // and will finally start returning mergedLists from the end of the linkedlist and finally merging altogether with the root in the next step.
        // Draw the recursion tree for better understanding. 
        root.next = flatten(root.next);
        // We then merge the two lists, root and root.next

        root = mergeTwoList(root, root.next);
        return root;
        
        
    } 

}
