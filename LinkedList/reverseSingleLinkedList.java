package LinkedList;

import utils.Node;

public class reverseSingleLinkedList {
      public static void main(String[] args) {
            Node node = new Node(1);
            node.next = new Node(2);
            node.next.next = new Node(3);
            node.next.next.next = new Node(4);
            node.next.next.next.next = new Node(5);
            System.out.print("\nBefore List : ");
            Node temp = node;
            while (temp != null) {
                  System.out.print(temp.data + " ");
                  temp = temp.next;
            }

            System.out.print("\nAfter List  : ");
            Node temp2 = reverse(node);

            while (temp2 != null) {
                  System.out.print(temp2.data + " ");
                  temp2 = temp2.next;
            }
      }

      public static Node reverse(Node node) {
            if (node == null) {
                  System.out.println("Null Linked List");
            }

            Node prev = null;
            Node nextNode = null;
            while (node != null) {
                  nextNode = node.next;
                  node.next = prev;
                  prev = node;
                  node = nextNode;
            }

            return prev;

      }
}