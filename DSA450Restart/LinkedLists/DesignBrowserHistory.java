class BrowserHistory1 {
    int currentIndex = 0;
    List<String> history = new ArrayList<>();
    
    public BrowserHistory(String homepage) {
        history.add(homepage);    
    }
    
    public void visit(String url) {
        // When we visit we are first deleting the sublist using the .clear method for
        // the length of history from the next index to the end for discarding the forward
        // history
        history.subList(currentIndex + 1, history.size()).clear();
        history.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(currentIndex-steps, 0);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(currentIndex+steps, history.size()-1);
        return history.get(currentIndex);
    }
}

class BrowserHistory2 {
    // Using a Doubly Linked Lists
    public class Node
    {
        String url;
        Node next, prev;
        
        public Node(String url)
        {
            this.url = url;
            next = prev = null;
        }
    }
    
    Node head, curr;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        // Move the current forward
        curr = node;
    }
    
    public String back(int steps) {
        // We are gonna step backwards so 
        while(curr.prev!=null && steps-->0)
        {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        
        while(curr.next!=null && steps-->0)
        {
            curr = curr.next;
        }
        return curr.url;
    }
}

class BrowserHistory3 {
    Deque<String> history;
    Deque<String> forward;
    public BrowserHistory(String homepage) {
        history = new ArrayDeque<>();
        history.push(homepage);
        forward = new ArrayDeque<>();
    }
    
    public void visit(String url) {
        history.push(url);
        forward = new ArrayDeque<>();
    }
    
    public String back(int steps) {
        while(steps-->0 && history.size()>1)
        {
            forward.push(history.peek());
            history.pop();    
        }
        
        return history.peek();
    }
    
    public String forward(int steps) {
        while(steps-->0 && forward.size()>0)
        {
            history.push(forward.peek());
            forward.pop();
        }
        
        return history.peek();
    }
}
