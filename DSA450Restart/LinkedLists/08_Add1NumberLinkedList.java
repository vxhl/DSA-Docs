package DSA450Restart.LinkedLists;

class addOneSol
{
    public static Node addOne(Node head)
    {
        // We just need to add 1 to the last element of the linked list
        // if it is smaller than 9 otherwise we have a problem

        // Let's say we first take all the elements of the linkedlists into a
        // string and then convert it into a number and then again add 1 and convert
        // it back to linkedlist, well that is a solution but I doubt that's what 
        // the interviewer will be looking for

        // Other methods can be, just traversing till the last element, then
        // checking if it is 9, if it is then we need to add 1 to the previous
        // node, and if add the elements are 9 in that case we need to insert a new node
        // at the start that is 1 and 0's in all the other places 

        // But in that case we need to reverse iterate a linkedlist, is that possible? 
        // First we simply reverse our entire linkedlist

        Node new_head = reverse(head);
        // Now let us have two pointers to keep track of our current and prev
        Node curr = new_head;
        Node prev = null;
        int carry = 0;

        while(curr!=null)
        {
            // Sum is for calculating our current value and carry of the node
            int sum = 0;
            if(prev == null)
            {
                // When at the first node we simply add 1 to our sum
                sum = curr.data + 1;
            }
            else
            {
                sum = curr.data + carry; // Otherwise we add whatever our current carry is
            }
            // Now we compute our carry and value
            // Our carry is what we get when we divide the current element with 10. For example, if we had 8 in the 
            // node and we add +1 we get 9 and 9/10 = 0 so we don't have any carry, but instead if we did 9+1/10 = 1 as a carry.
            // 10%10 == 0 and 9%10 = 9
            carry = sum/10;
            // If sum is smaller than 10 we get the sum value itself
            curr.data = sum%10;
            // we now move our pointers
            prev = curr;
            curr = curr.next;

        }

        if(carry == 1)
        {
            Node new_node = new Node(1);
            prev.next = new_node;
        }
        return reverse(new_head);

    }
    public static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr.next!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

}