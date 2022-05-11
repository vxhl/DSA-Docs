package DSA450Restart.LinkedLists;

class AddTwoNumbersLinkedLists
{
    public static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    
    static int length(Node head)
    {
        int count = 0;
        Node current = head;
        while(current!=null)
        {
            count++;
            current = current.next;
        }
        return count;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        if(length(first)<length(second))
        {
            Node temp = first;
            first = second;
            second = temp;
        }
        Node newFirst = reverse(first);
        Node newSecond = reverse(second);

        Node curr1 = newFirst;
        Node curr2 = newSecond;
        Node prev = null;
        // Node sumList = new Node(0);
        int carry = 0;

        while(curr1!=null || curr2!=null)
        {
            int sum1 = 0;
            int sum2 = 0;
            if(curr1 == null)
            {
                sum1 = 0;
            }
            else
            {
                sum1 = curr1.data;
            }
            
            if(curr2 == null)
            {
                sum2 = 0;
            }
            else
            {
                sum2 = curr2.data;
            }
            
            int sum = sum1 + sum2 + carry;
            carry = sum/10;
            // We do this since curr1 is of the bigger list
            curr1.data = sum%10;
            // Node newNode = new Node(sum%10);
            prev = curr1;
            curr1 = curr1.next;
            if(curr2!=null)
            {
                curr2 = curr2.next;
            }
            
        }
        if(carry == 1)
        {
            Node newNode1 = new Node(1);
            prev.next = newNode1;
        }
        
        return reverse(newFirst);
    }
}