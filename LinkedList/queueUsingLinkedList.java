package LinkedList;
import java.util.Scanner;
class QueueUsingLinkedListImplementation {
    // declaring REAR and FRONT pointers
    Node REAR;
    Node FRONT;
    class Node {
        // 'next' contains address/link to the next node
        Node next;
        // 'data' is the data storage part
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }
    QueueUsingLinkedListImplementation() {
        this.REAR = null;
        this.FRONT = null;
    }
    boolean isEmpty() {
        // if head null , queue is empty
        return FRONT == null;
    }
    void enqueue(int element) {
        // make a new node
        Node newNode = new Node(element);
        // check if the queue is empty
        if (isEmpty()) {
            // then set the FRONT and REAR to newNode
            FRONT = newNode;
            REAR = newNode;
        }
        // else the current element (last) 's link part to the newNode ,
        REAR.next = newNode;
        // and set the rear to the new element
        REAR = newNode;
    }
    Node dequeue() {
        // check if queue is empty
        if (isEmpty()) {
            System.out.println("Queue Underflow, can't dequeue");
            return null;
        } else {
            //store the FRONT element
            Node frontElement = FRONT;
            // remove the head element
            FRONT = FRONT.next;
            //is queue becomes empty  , then rest the REAR to FRONT to null
            if (isEmpty()) {
                REAR = null;
            }
            //return the dequeued element  
            return frontElement;
        }
    }
    int front(){
        //if queue empty
        if(isEmpty()){
            System.out.println("No front element , QUEUE is Empty");
            return -1;
        }
        //else return front data
        return FRONT.data;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to display.");
            return;
        }
        System.out.print("Queue elements: ");
        Node temp = FRONT;
        while(temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class queueUsingLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingLinkedListImplementation queue = new QueueUsingLinkedListImplementation();
        while (true) {
            System.out.println("Enter Your Choice-[ 1-enqueue ],[ 2-dequeue ],[ 3-FRONT ] ,[ 4-Display ],[ 5-exit ]");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Element");
                queue.enqueue(sc.nextInt());
            } else if (choice == 2) {
                System.out.println(queue.dequeue().data + " dequed");
            } else if (choice == 4) {
                queue.display();
            } else if (choice == 3) {
                System.out.println("Front : " + queue.front());
            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }
}