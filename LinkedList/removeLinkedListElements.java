package LinkedList;

import utils.Node;

public class removeLinkedListElements {
      public static void main(String[] args) {
            Node node = new Node(0);
            node.next = new Node(2);
            node.next.next = new Node(3);
            node.next.next.next = new Node(4);
            node.next.next.next.next = new Node(7);
            node.next.next.next.next.next = new Node(9);
            node.next.next.next.next.next.next = new Node(4);
            node.display(removeNode(node, 4));
      }

      public static Node removeNode(Node head, int val) {
            if (head == null) {
                  return null;
            }
            Node dummy = new Node(0);
            dummy.next = head;
            Node prev = dummy;
            Node temp = head;

            while (temp != null) {
                  if (temp.data == val) {
                        prev.next = temp.next;
                  } else {
                        prev = temp;
                  }
                  temp = temp.next;
            }
            return dummy.next;
      }

}
