package DSA450Restart.LinkedLists;

 class MultiplyTwoNumbers {



    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    public long multiplyTwoLists(Node l1,Node l2){
        //add code here.
        long N = 1000000007;
        long num1 = 0;
        long num2 = 0;
        
        // We apply the formula for just simple tens place multiplication to 
        // extract our actual numbers from the linkedlist
        Node first = l1;
        Node second = l2;
        while(first!= null || second!=null)
        {
            if(first!=null)
            {
                num1 = (num1*10)%N + first.data;
                first = first.next;
            }
            
            if(second!=null)
            {
                num2 = (num2*10)%N + second.data;
                second = second.next;
            }
            
        }
        
        return (num1*num2)%N;
 }

}
