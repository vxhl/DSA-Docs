// Problem Statement : Implement the circular queue concept
// logic : This concept tackles the problem of garbage memory on dequeue by
// setting the rear pointer to point to the first index
// Time Complexity : O(1)
package Queues;


public class CircularQueue {
    
    int front;
    int rear;
    int n;
    int CQueue[];
    
    public CircularQueue(int n)
    {
        this.n = n;
        front= -1;
        rear =  -1;
        CQueue = new int[this.n];
    }

    void enqueue(int data) 
    {
        if (front == -1 && rear == -1)
        {
            CQueue[rear] = data;
            System.out.println(data + " HAs been enqueued");
        } 
        else if(front == (rear + 1)%n) 
        {
            System.out.println("Queue is full");
        }
        else 
        {
            rear = (rear + 1)%n;
            CQueue[rear] = data;
        }
    
    }
    int dequeue()
    {
        if(front == -1 && rear == -1)
        {
            return 0;
        }
        else if(front == rear ) 
        {
            front = rear = -1;
            return CQueue[front];

        }
        else 
        {
            front = (front+1)%n;
            return CQueue[front];
        }
    }
    int peek() 
    {
        if(front == -1&& rear== -1 )
        {
            return 0;
        }
        else 
        {
            return CQueue[front];
        }

    }

    void display() 
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is empty");
        }
        else 
        {
            System.out.println(" The Queue is : ");
            int i = 0;
            while (i!=rear) 
            {
                System.out.println(CQueue[i]);
                i = (i+1)%n;
            }
        }    
    }
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();
        
    }

}
