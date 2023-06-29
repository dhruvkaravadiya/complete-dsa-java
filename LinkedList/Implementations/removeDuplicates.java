//Remove duplicates in Unsorted linked list using HASHING
// Time Complexity = O( n )
// Auxiliary Space = O( n )
package LinkedList.Implementations;

import java.util.HashSet;

public class removeDuplicates {
    static class Node {
        // 'next' contains address/link to the next node
        Node next;
        // 'data' is the data storage part
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    static void removeDuplicatesFromList(Node head) {
        // Inilialize a hashset
        HashSet<Integer> set = new HashSet<Integer>();
        Node current = head;
        Node previous = null;
        while (current != null) {
            int temp = current.data;
            if (set.contains(temp)) {
                previous.next = current.next;
            } else {
                set.add(temp);
                previous = current;
            }
            current = current.next;
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
    public static void main(String[] args) {
        
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(19);
        node.next.next.next = new Node(22);
        node.next.next.next.next = new Node(22);
        node.next.next.next.next.next = new Node(3);
        System.out.println("Before Removing Duplicates : ");
        display(node);
        System.out.println("After Removing Duplicates : ");
        removeDuplicatesFromList(node);
        display(node);
    }
}
