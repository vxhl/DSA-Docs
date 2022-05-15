package DSA450Restart.LinkedLists;

class ThreeSumLL
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

    public static int ThreeSumLL(dlnode head, int x)
    {
        dlnode curr = head;
        int ans = 0;
        while(curr.next.next!=null)
        {
            // First we define our left and right node 
            dlnode left = curr.next;
            dlnode right = curr;

            // Then we first move our right node to the end
            while(right.next!=null)
            {
                right = right.next;
            }

            // As long as our left node is not equal to our right node
            while(left!=right)
            {
                
                // If we find our result we just increment and skip the duplicate
                // values
                if(left.data + right.data == -(curr.data) + x )
                {
                    ans+=1;
                    while(left!=right && left.data == left.next.data) 
                    {
                        left = left.next;
                    }
                    
                    while(left!=right && right.data == right.prev.data) 
                    {
                        right = right.prev;
                    }

                    left = left.next;
                    right = right.prev;
                }

                else if(left.data + right.data < -(curr.data)+x)
                {
                    left = left.next;
                }
                else
                {
                    right = right.prev;
                }
        }
        curr = curr.next;
        }


        return ans;
    }

    static dlnode insert(dlnode head, int val)
    {
        dlnode temp = new dlnode(val);
        if(head == null)
        {
            head = temp;
        }
        else
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        return head;
    }


    public static void main(String[] args) {
        dlnode head = null;
    
        // insert values in sorted order
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
        int x = 17;
        System.out.print("Count = " + ThreeSumLL(head, x));
    }

}