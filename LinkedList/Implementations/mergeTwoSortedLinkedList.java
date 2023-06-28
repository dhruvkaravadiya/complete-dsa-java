//Merge Two Linked List using Single Pointer 
// TIME COMPLEXITY - O(n+m) - n,m are the size of
//                            the lists 1 and 2 respectively
// AUXILIARY SPACE - O(1)
package LinkedList.Implementations;

class ImplementationClass {
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

    Node head;

    void addAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else{
            Node temp = head;
        while (temp.next != null) {
            temp = temp.next;;
        }
        temp.next = newNode;
        System.out.println(data + " inserted");
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void mergeLists(Node h1, Node h2) {
        // initialize a dummy head to put result
        Node dummyHead = new Node(0);
        // initialize tail that will point to the last node of the merged list
        Node tail = dummyHead;
        while (true) {
            // if one of the list runs out
            // then attach the other list to the
            // merged list
            if (h1 == null) {
                tail.next = h2;
                break;
            }
            if (h2 == null) {
                tail.next = h1;
                break;
            }
            
            //now compare corresponding elements from each list
            //attach the smaller element to merged list and 
            //move the head pointer of that list to its next node
            if(h1.data <= h2.data){
                //append its head to the tail 
                tail.next = h1;
                //and then advance the heada pointer
                h1 = h1.next;
            }
            else{
                //append its head to the tail
                tail.next = h2;
                //and then advance the heada pointer
                h2 = h2.next;
            }
            //at last advance tail pointer
            tail = tail.next;     
        }
    }
}

public class mergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ImplementationClass l1 = new ImplementationClass();
        ImplementationClass l2 = new ImplementationClass();
        l1.addAtLast(0);
        l1.addAtLast(2);
        l1.addAtLast(4);
        l2.addAtLast(1);
        l2.addAtLast(3);
        l2.addAtLast(5);
        l1.display();
        l2.display();
        l1.mergeLists(l1.head, l2.head);
        l1.display();
    }
}