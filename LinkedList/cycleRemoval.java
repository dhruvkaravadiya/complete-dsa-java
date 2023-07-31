//remove the loop without losing any node
package LinkedList;

public class cycleRemoval {
    static class Node {
        // 'next' contains address/link to the next node
        Node next = null;
        // 'data' is the data storage part
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    static void display(Node head) {
        Node temp = head;
        // Traverse the linked list and print the data values of each node
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        // first detect loop and break at the looping starting node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }
        // if the whole linked list is loop ,i.e. circular linked list
        if (slow == head) {
            // then reach the last node and change its link to null
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        // else if the loop is not from the head
        else if (slow == fast) {
            // start the slow from the head
            slow = head;
            // and move fast and slow pointer until the meet again
            // when they meet , fast will be at node before the looping node
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        // finally reset the fast pointer's link part to null
        // to break the loop
        fast.next = null;
        System.out.println("Cycle Removal Successful");
    }

    public static void main(String[] args) {
        Node list = new Node(0);
        list.next = new Node(1);
        Node temp = list.next.next = new Node(2);
        list.next.next.next = new Node(3);
        list.next.next.next.next = new Node(4);
        list.next.next.next.next.next = new Node(5); // Make the last node point back to the second node
        list.next.next.next.next.next.next = temp;
        removeLoop(list);
        display(list);

    }
}
