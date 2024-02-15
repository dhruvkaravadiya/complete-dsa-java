package LinkedList;

public class AddTwoNumbers {
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

      static Node addTwo(Node h1, Node h2) {
            Node dummyHead = new Node(0);
            Node current = dummyHead;
            int carry = 0;
            while (h1 != null || h2 != null || carry != 0) {
                  int sum = 0;
                  if (h1 != null) {
                        sum += h1.data;
                        h1 = h1.next;
                  }
                  if (h2 != null) {
                        sum += h2.data;
                        h2 = h2.next;
                  }
                  sum += carry;
                  carry = sum / 10;
                  Node newNode = new Node(sum % 10);
                  current.next = newNode;
                  current = current.next;

            }
            return dummyHead.next;
      }

      public static void main(String[] args) {
            Node h1 = new Node(0);
            h1.next = new Node(1);
            h1.next.next = new Node(2);
            h1.next.next.next = new Node(3);
            Node h2 = new Node(0);
            h2.next = new Node(1);
            h2.next.next = new Node(2);
            h2.next.next.next = new Node(3);
            Node h3 = addTwo(h1, h2);
            display(h1);
            display(h2);
            display(h3);
      }
}
