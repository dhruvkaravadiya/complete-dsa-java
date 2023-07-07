package Queue;

class CircularQueueImplementation {
    Node front, rear;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    void enqueue(int data) {
        Node newNode = new Node(data);
        // if linked list empty
        if (front == null && rear == null) {
            //then set the front and rear to newNode
            front = newNode;
            rear = newNode;
            //point the newNode to front making it circular
            newNode.next = front;
        }
        else{
            //first update the link part of the rear to the new Node
            rear.next = newNode;
            //then point the rear to the newNode
            rear = newNode;
            //point newNode to front making it circular
            newNode.next = front;
        }
    }
    void dequeue() throws Exception{
        //if queue empty
        if (front == null && rear == null) {
            throw new Exception("Queue Empty, can't dequeue");
        }
        //if queue has 1 element
        else if(front == rear){
            front = null;
            rear = null;
        }
        //else queue has more then 1 element
        else{
            front = front.next; 
            rear.next = front;
        }
    }    
    void display(){
        Node temp = front;
        do{
            System.out.print(temp.data+" ");
            temp =temp.next;
        }while(temp != front);
        System.out.println();
    }
}

public class circularQueueUsingLinkedList {
    public static void main(String[] args) throws Exception {
        CircularQueueImplementation queue = new CircularQueueImplementation();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        queue.display();
        
        queue.dequeue();
        
        queue.display();
        
        queue.dequeue();
        
        queue.display();
    }
}