package DSA450Restart.LinkedLists;

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class ReverseLinkedList {

    public static Node ReverseLinkedListNode(Node head) {
        // So inorder to reverse a linked list ->
        // null->1->2->3->4
        // curr = head; -> We use this to keep track of the curretn node
        // prev = null; -> We use this to keep track of the node to which our current
        // nodes reference is to be reversed to
        // next = null; -> We store our next reference here so we do not lose it when we
        // change our pointers?
        Node curr = head;
        Node next = null;
        Node prev = null;
        while (curr != null) {
            // We first store our next pointer
            next = curr.next;
            // Then we change our current nodes reference to the previous
            // pointer
            curr.next = prev;
            // Then we move our pointers ahead
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

}