package LinkedList;

class SinglyLinkedListImplemented {
      // Node head = null is also same as Node head ,
      // as not assigning value to head makes it null
      Node head;

      // Each node has two parts - data part , link part
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

      public Node insertNodeAtStart(int data) {
            Node newNode = new Node(data);
            // if linked list empty , then start from the newNode as the first element
            if (head == null) {
                  head = newNode;
            } else {
                  // let the link part of newNode store link to where head was pointing
                  newNode.next = head;
                  // and then move the head to point the newNode
                  head = newNode;

            }
            return head;
      }

      public void deleteNthNodeFromEnd(int deleteIndex) {
            // Check if the linked list is empty
            if (head == null) {
                  System.out.println("Linked List Empty, no deletion possible");
            } else {
                  Node dummyhead = new Node(0);
                  dummyhead.next = head;
                  Node slow = dummyhead;
                  Node fast = dummyhead;

                  // we will first move deleteIndex + 1 steps ahead
                  for (int i = 0; i <= deleteIndex; i++) {
                        fast = fast.next;
                  }

                  // now move both fast and slow until fast reaches the end
                  // so slow will be at the node just before the node to be deleted
                  while (fast != null) {
                        slow = slow.next;
                        fast = fast.next;
                  }
                  // now delete the node
                  slow.next = slow.next.next;
                  head = dummyhead.next;
                  // if return the return dummyhead.next
            }
      }

      public void display() {
            Node temp = head;
            System.out.print("\nList : ");
            // Traverse the linked list and print the data values of each node
            while (temp != null) {
                  System.out.print(temp.data + " ");
                  temp = temp.next;
            }
      }
}

public class RemoveNthFromLast {
      public static void main(String[] args) {
            SinglyLinkedListImplemented list = new SinglyLinkedListImplemented();
            list.insertNodeAtStart(5);
            list.insertNodeAtStart(4);
            list.insertNodeAtStart(3);
            list.insertNodeAtStart(2);
            list.insertNodeAtStart(1);
            list.display();
            list.deleteNthNodeFromEnd(2);
            list.display();
      }
}
