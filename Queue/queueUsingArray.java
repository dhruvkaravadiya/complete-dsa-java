package Queue;

import java.util.Scanner;

class QueueUsingArrayImplementation {
    // declaring variables
    int REAR, FRONT, size;
    int queue[];

    // constructor
    QueueUsingArrayImplementation(int capacity) {
        // set FRONT and size to zero
        this.size = 0;
        this.FRONT = 0;
        // set the REAR to the last index
        this.REAR = -1;
        // set queue size
        queue = new int[capacity];
    }

    void enqueue(int element) {
        // first check if queue is full
        if (isFull()) {
            System.out.println("Queue Overflow , can't Enqueue");
            return;
        }
        // increment rear pointer
        REAR++;
        // insert element
        queue[REAR] = element;
        // at last imcrement size
        size++;
    }

    int dequeue() {
        // check is queue already empty
        if (isEmpty()) {
            System.out.println("Queue Underflow ,can't Dequeue");
            return -1;
        }
        // get the first element
        int frontElement = queue[FRONT];
        // shift all elements to right to delete the front element
        for (int i = 0; i < REAR; i++) {
            queue[i] = queue[i + 1];
        }
        // decrement the rear pointer
        REAR--;
        // decrement the size of queue
        size--;
        return frontElement;
    }

    // returns the front element of the queue
    int front() {
        // check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[FRONT];
    }

    // returns the rear element of the queue
    int rear() {
        // check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[REAR];
    }

    boolean isFull() {
        return queue.length == size;
    }

    boolean isEmpty() {
        return queue.length == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to display.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = FRONT; i <= REAR; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class queueUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int n = sc.nextInt();
        QueueUsingArrayImplementation queue = new QueueUsingArrayImplementation(n);
        while (true) {
            System.out.println("Enter Your Choice-[ 1-enqueue ],[ 2-dequeue ],[ 3-FRONT ],[ 4-REAR ],[ 5-Display ],[ 6-exit ]");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Element");
                queue.enqueue(sc.nextInt());
            } else if (choice == 2) {
                System.out.println("[" + queue.dequeue() + "]");
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 5) {
                queue.display();
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 3) {
                System.out.println("Rear : " + queue.front());
            } else if (choice == 4) {
                System.out.println("Rear : " + queue.rear());
            } else if (choice == 6) {
                break;
            }
        }
    }
}
