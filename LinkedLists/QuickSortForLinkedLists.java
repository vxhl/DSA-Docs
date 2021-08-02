package LinkedLists;

public class QuickSortForLinkedLists 
{
    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static Node head;

    void addNode(int data)
    {
        if (head == null) {
            head = new Node(data);
            return;
        }
 
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
 
        Node newNode = new Node(data);
        curr.next = newNode;
    }
 
    void printList(Node n)
    {
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }
    }

    // Let us now define our partition function for linked lists
    Node partitionLast(Node low, Node high)
    {
        if(low==high || low == null || high == null)
        {
            return low;
        }
        Node pivot_start = low; // We keep track of the prev with i
        Node curr = low; // We keep track of the current node with j
        int pivot = high.data; 

        // We then iterate till before the pivot element
        while(low != high)
        {
            if(low.data < pivot) // We swap the  
            {
                // We keep track of the last swapped item
                pivot_start = curr;
                int temp = curr.data;
                curr.data = low.data;
                low.data = temp;
                curr = curr.next;
            }
            low = low.next;
        }
        // We then swap the position of j and pivot
        int temp = curr.data;
        curr.data = pivot;
        high.data = temp;

        return pivot_start;
    }
    void QuickSort(Node start, Node end)
    {
        if(start == null || start == end|| start == end.next )
            return;
 
        // split list and partion recurse
        Node j = partitionLast(start, end);
        QuickSort(start, j);
 
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (j != null && j == start)
            QuickSort(j.next, end);
 
        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (j != null
                 && j.next != null)
            QuickSort(j.next.next, end);
    }
    public static void main(String[] args)
    {
        QuickSortForLinkedLists list
            = new QuickSortForLinkedLists();
        list.addNode(30);
        list.addNode(3);
        list.addNode(4);
        list.addNode(20);
        list.addNode(5);
 
        Node n = list.head;
        while (n.next != null)
            n = n.next;
 
        System.out.println("Linked List before sorting");
        list.printList(list.head);
 
        list.QuickSort(list.head, n);
 
        System.out.println("\nLinked List after sorting");
        list.printList(list.head);

    }
}

