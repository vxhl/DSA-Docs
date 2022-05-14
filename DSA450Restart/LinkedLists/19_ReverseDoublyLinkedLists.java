package DSA450Restart.LinkedLists;

class dllnode
{
    int data;
    dllnode next;
    dllnode prev;
    public dllnode(int data)
    {
        this.data = data;
    }
}
class rdll
{
    public static dllnode reverseDLL(dllnode  head)
{
    //Your code here
    dllnode prev = null;
    dllnode curr = head;
    dllnode next = null;
    while(curr!=null)
    {
        next = curr.next;
        curr.prev = curr.next;
        curr.next = prev;
        
        prev = curr;
        curr = next;
    }
    
    return prev;
}
}