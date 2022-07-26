
// Implement Simple Queue using array that performs following operations: INSERT, DELETE, DISPLAY

import java.util.Scanner;

public class Queue {
    int[] arr;
    int front = -1;
    int rear = -1;

    public void setSize(int n) {
        arr = new int[n];
    }

    public void enqueue(int n) {
        if (rear >= arr.length - 1) {
            System.out.println("Queue Overflow");
        } else {
            rear++;
            if (rear == 0) {
                front = 0;
            }
            arr[rear] = n;
        }
    }

    public int dequeue() {
        if (front <= -1 || front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            System.out.println("Dequeued element");
            return arr[front++];
        }
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int n = sc.nextInt();

        SimpleQueue queue = new SimpleQueue();
        queue.setSize(n);

        System.out.println("Enter Your Choice ");
        System.out.println(" 1 to enqueue ");
        System.out.println(" 2 to dequeue ");
        System.out.println(" 3 to display  ");
        System.out.println(" 4 to exit  ");
        int choice = sc.nextInt();
        while (true) {
            if (choice == 1) {
                System.out.println("Enter Element");
                queue.enqueue(sc.nextInt());
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 2) {
                System.out.println("[" + queue.dequeue() + "]");
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 3) {
                queue.display();
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else {
                break;
            }
        }
        sc.close();
    }
}