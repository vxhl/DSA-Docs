package DSA450Restart.LinkedLists;

class ReverseKGroups
{
    static class dlnode
    {
        int data;
        dlnode next;
        dlnode prev;
        dlnode(int data)
        {
            this.data = data;
        }
    }

    public static dlnode reverseKGroups(dlnode head, int k)
    {
        dlnode curr = head;
        dlnode prev = null;
        dlnode next = null;
        int count = 0;
        while(curr!=null && count!=k)
        {
            next = curr.next;
            curr.next = prev;
            curr.prev = curr.next;
            prev = curr;
            curr = next;
        }

        if(next!=null)
        {
            reverseKGroups(next, k);
        }


        return prev;
    }

    static dlnode push(dlnode newHead, dlnode curr)
    {
        // First we set our current elements previous as null
        curr.prev = null;
 
        // And set it's next as the newHead
        curr.next = newHead;
 
        // If our newHead was not null then we set it's previous to our current thus reversing their links
        // Example -> newHead = null and curr = node(1) -> in this case our newHead = node(1)
        // Example -> newHead = node(1) and curr = node(2) -> Since our newHead is not null we set it's previous as curr so it becomes node(2)<->node(1)
        if (newHead != null)
            newHead.prev = curr;
 
        // move the head to point to the new node
        newHead = curr;
        return newHead;
    }
 
    // function to reverse a doubly linked list
    // in groups of given size
    static dlnode revListInGroupOfGivenSize(dlnode head, int k)
    {
        dlnode current = head;
        dlnode next = null;
        dlnode newHead = null;
        int count = 0;
 
        // reversing the current group of k
        // or less than k nodes by adding
        // them at the beginning of list
        // 'newHead'
        while (current != null && count < k)
        {
            // Firstly as usual we store our next referece
            next = current.next;
            // Then we have our newHead right, so what do we do here exactly?
            // we reverse the two nodes using push. For example in the first iteration we have 1 as the newHead and in the
            // second iteration it becomes 2<->1 
            newHead = push(newHead, current);

            // We then as usual move our current ahead
            current = next;
            count++;
        }
 
        // if next group exists then making the desired
        // adjustments in the link
        if (next != null)
        {
            // We then assign the new reversenode to head.next
            head.next = revListInGroupOfGivenSize(next, k);
            // Since it is a dll we also need to make sure to make the prev link as well
            head.next.prev = head;
        }
 
        // pointer to the new head of the
        // reversed group
        return newHead;
    }
}