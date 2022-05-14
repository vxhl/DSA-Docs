package DSA450Restart.LinkedLists;
import java.util.*;
class Pair
{
    int first;
    int second;
    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class findPairsGivenSum
{


    static class dlnode
    {
        int data;
        dlnode next, prev;
    }

    public static void twoSumDLL(dlnode head, int x)
    {
        // We are going to do the same approach as we do in any sorted array so it is pretty simple
        // but this helps us understand dll a bit better
        // ArrayList<Pair> ans = new ArrayList<>();
        dlnode left = head;
        dlnode right = head;
        // First we move the right node to the end of the linkedlist

        while(right.next!=null)
        {
            right = right.next;
        }
        int flag = 0;
        while(left!=right)
        {
            if(left.data + right.data == x)
            {
                flag = 1;
                // ans.add(new Pair(left.data, right.data));
                System.out.print(left.data + " " + right.data);
                left = left.next;
                right = right.prev;
            }
            else if(left.data + right.data > x)
            {
                right = right.prev;
            }
            else
            {
                left = left.next;
            }
            System.out.println();
        }
        if(flag == 0)
        {
            System.out.print("Didn't find shit");
        }
    }

    static dlnode insert(dlnode head, int data)
    {
        dlnode temp = new dlnode();
        temp.data = data;
        temp.next = temp.prev = null;
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
        return temp;
    }
    
    
    public static void main(String[] args) {
        dlnode head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
        int x = 7;

        twoSumDLL(head, x);

    }
}