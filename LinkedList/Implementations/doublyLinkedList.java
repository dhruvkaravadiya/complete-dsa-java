//Doubly Linked List implementation using two pointers : head , next
package LinkedList.Implementations;

class DoublyLinkedListImplemented {
    // lets define the node first which looks like this :
    // ---------------------
    // Node : | prev | data | next |
    // ---------------------
    class Node {
        // 'next' contains address/link to the next node
        Node next = null;
        // 'prev' contains address/link to previous node
        Node prev = null;
        // 'data' is the data storage part
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    int data;
    // Pointer which will point to the start of linkedlist
    Node head;
    // Pointer which will point to the end of linkedlist
    Node tail;
    // Node head = null is same as Node head; same for tail
    // both null values
    int size = 0;

    // Insertion at Start
    public void insertAtStart(int data) {
        // create a new node
        Node newNode = new Node(data);
        // if list empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
        } else {
            // set head's prev link to the newNode
            head.prev = newNode;
            // set newNode's next part to head
            newNode.next = head;
            // set head to new node
            head = newNode;
        }
        size++;
        System.out.println(data + " inserted");
    }

    // Insertion At End
    public void insertAtEnd(int data) {
        // create new node
        Node newNode = new Node(data);
        // check is linkedlist is empty
        if (head == null) {
            // then assign head and tail to the new Node
            head = newNode;
            tail = newNode;
        } else {
            // after we reach the end of linked list
            // 1. set tail node's next part to point to newNode
            tail.next = newNode;
            // 2. set newNode's prev pointer to the tail node as doubly linked list can me
            // traversed both ways
            newNode.prev = tail;
            // 3. set tail pointer to point to the nerwNode
            tail = newNode;
        }
        size++;
        System.out.println(data + " inserted");

    }

    public void insertAtMid(int data) {
        // create new Node
        Node newNode = new Node(data);
        // check is head is null , i.e. linked list empty
        if (head == null) {
            // then set both head and tail too the newNode
            head = newNode;
            tail = newNode;
        }
        // if head is pointing to last element
        else if (head.next == null) {
            // set head's next link to newNode
            head.next = newNode;
            // set newNode's prev part to head
            newNode.prev = head;
            // set tail to newNode
            tail = newNode;
        } else {
            // traverse to the middle of the list
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // store the next element's address in temp2
            Node temp2 = slow.next;
            // now set slow's next link to newNode
            slow.next = newNode;
            // set newNode's prev link to slow
            newNode.prev = slow;
            // set newNode's next part to temp2
            newNode.next = temp2;
            // set temp2's prev part to newNode
            if (temp2 != null) {
                temp2.prev = newNode;
            }
        }
        size++;
        System.out.println(data + " inserted");

    }

    public void insertAtNth(int data, int pos) {
        // create a new node
        Node newNode = new Node(data);
        // check if head null
        if (head == null) {
            // then set head , tail
            head = newNode;
            tail = newNode;
        }
        // create a temp node uptil which we will iterate instead of head
        Node left = head;
        int flag = 0;
        // move the temp pointer uptil the index
        while (flag < pos - 1) {
            left = left.next;
            flag++;
        }
        // then store the next element of the node , so we insert a node in middle of
        // them
        Node right = left.next;
        // first set the newNode's prev link to left
        newNode.prev = left;
        // set left's next link to newNode
        left.next = newNode;

        // then set right's prev link to newNode
        right.prev = newNode;
        // set newNode's next link to right
        newNode.next = right;
        // incremenent size on insert
        size++;
        System.out.println(data + " inserted");

    }

    // insertatmid is still not correct
    public void deleteAtFirst() {
        // check is list empty
        if (head == null) {
            System.out.println("Cannot delete , Linked List is Empty");
        } else {
            int x = head.data;
            // move the head to the next element of the element it was pointing before
            head = head.next;
            // then set the head's prev link to null , so , in actual list,
            // the element's prev part will be set to null
            head.prev = null;
            System.out.println(x + " deleted");
        }
        size--;
    }

    public void deleteAtEnd() {
        // check is tail is null
        if (tail == null) {
            System.out.println("List empty , cannot delete");
        } else {
            int x = tail.data;
            // move the tail pointer to its previous node
            tail = tail.prev;
            // then set the tail's prev link to null
            // as it will update the last element's next link to null,making it the last
            // element
            tail.next = null;
            System.out.println(x + " deleted");
        }
        size--;
    }

    public void deleteAtNth(int n) {
        // check is list is empty
        if (head == null) {
            System.out.println("List empty ,cannot delete");
        } else {
            // traverse to the nth element
            Node temp = head;
            int x = 0;
            while (x < n) {
                temp = temp.next;
                x++;
            }
            int d = temp.data;
            Node left = temp.prev;
            Node right = temp.next;
            temp.next = null;
            temp.prev = null;

            left.next = right;
            right.prev = left;
            System.out.println(d + " deleted");

        }
        size--;
    }

    public void reverse() {
        // return if list empty
        if (head == null) {
            System.out.println("Doubly Linked List Empty, can't reverse");
            return;
        }
        Node curr = head;
        Node temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        }
        Node tempHead = head;
        head = tail;
        tail = tempHead;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}

public class doublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListImplemented list = new DoublyLinkedListImplemented();
        list.insertAtStart(-1);
        list.insertAtStart(-2);
        list.insertAtStart(-3);
        list.insertAtStart(-4);

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        // list.insertAtMid(0);

        list.insertAtNth(0, 3);

        list.deleteAtFirst();

        list.deleteAtEnd();

        list.deleteAtNth(1);

        list.display();

        list.reverse();

        list.display();
    }
}