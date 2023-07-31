package LinkedList;

class CircularLinkedListImplemented {
    // two pointers - head and tail pointing to the start and ending node
    // respectively
    Node head = null;
    Node tail = null;

    // lets define the node
    class Node {
        // data part of the node
        int data;
        // link part of the node which will contain the address to the next node
        Node next;

        // initialize the node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // insert at first
    public Node insertAtEnd(int data) {
        // create the new Node
        Node newNode = new Node(data);
        // check if linked list empty
        // => then set the linked list head to newNode
        if (head == null) {
            head = newNode;
            tail = newNode;
            return head;
        }
        // if head not null , i.e. linked list not empty ,then
        // update the tail's link part to new node
        tail.next = newNode;

        // point tail to new Node to enter the newNode
        tail = newNode;
        // update the link part of tail to make it circular
        tail.next = head;
        return head;
    }

    public Node insertAtFirst(int data) {
        Node newNode = new Node(data);
        // if linked list empty , set the head and tail pointer to the new Node
        if (head == null) {
            head = newNode;
            tail = newNode;
            return head;
        }
        // if linked list not null
        // first store the address of the current first element of the list
        // in the newNode's link part making it the first element
        newNode.next = head;
        // store the address of the newNode in the tail's link part making it circular
        tail.next = newNode;
        // lastly reset the head pointer to the new First node
        head = newNode;
        return tail;
    }
    public Node insertAtMiddle(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return head;
        }
        //reach the middle element using slow , fast pointers
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow is pointing to the middle element
        //first the next part of newNode should have link to its next element
        newNode.next = slow.next;
        //then update the middle element's link part to point to the newNode's
        slow.next = newNode;
        return head;
    }
    public void deleteAtFirst() {
        // if linked list is empty , not further deletion possible
        if (head == null) {
            System.out.println("List empty , deletion not possible");
            return;
        }
        // reset the head pointer first
        head = head.next;
        // first point the tail.next to the next node of the first node
        tail.next = head;
    }

    public void deleteAtLast() {
        // if linked list empty then no further deletion is possible
        if (head == null) {
            System.out.println("List Empty ,deletion onot possible");
        }
        // If there is only one node in the list, delete it
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        // Iterate to the second last element of the list
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        // change the link part of the second last element (temp) to null
        temp.next = null;
        // and finally reset the tail pointer to the new last element
        tail = temp;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List empty");
            return;
        }
        // else print the list
        Node temp = head;
        do {
            System.out.print(" " + temp.data);
            temp = temp.next;
        } while (temp != head && temp!=null);
        System.out.println();
    }
}

public class circularLinkedList {
    public static void main(String[] args) {
        CircularLinkedListImplemented l = new CircularLinkedListImplemented();
        l.insertAtFirst(0);
        l.insertAtFirst(1);
        l.insertAtFirst(2);
        l.insertAtFirst(3);
        l.insertAtFirst(4);
        l.insertAtEnd(-1);
        l.display();
         l.deleteAtFirst();
        l.deleteAtLast();
        l.display();
    }
}