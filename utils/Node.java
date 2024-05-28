package utils;

public class Node {
      // 'next' contains address/link to the next node
      public Node next;
      // 'data' is the data storage part
      public int data;

      public Node(int data) {
            this.next = null;
            this.data = data;
      }

      public void display(Node node) {
            while (node != null) {
                  System.out.print(node.data + " ");
                  node = node.next;
            }
      }
}