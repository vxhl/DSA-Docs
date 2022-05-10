package DSA450Restart.LinkedLists;

class ReverseLinkedListKGroups {

    public static Node reverseK(Node node, int k) {
        // Your code here
        if (node == null)
            return null;
        Node curr = node;
        Node prev = null;
        Node next = null;

        int count = 0;

        while (curr != null && count != k) {

            count++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        if (next != null) {
            node.next = reverseK(next, k);
        }

        return prev;

    }
}