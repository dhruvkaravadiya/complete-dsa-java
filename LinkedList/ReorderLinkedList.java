// 1->2->3->4->5->6
// 1->6->2->5->3->4

// first reach the middle of linked list
// then reverse the second half of the linked list
// then merge the two linked list in following fashion
// => 1st node of 1st linked list , then 1st node of 2nd linked list
// if any one of the linked list runs out , 
// the attach the other left list to the merged list

package LinkedList;

class SinglyLinkedListImplemented {
      // Node head = null is also same as Node head ,
      // as not assigning value to head makes it null
      Node head;
      int size = 0;

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

      public Node divideList() {
            Node slow = head;
            Node fast = head;
            // take a prev node to store the previous node of the slow pointer
            Node prev = null;
            while (fast != null && fast.next != null) {
                  prev = slow;
                  slow = slow.next;
                  fast = fast.next.next;
            }
            // now the slow is pointing
            // to the middle of the linked list
            // so we can divide the linked list into two parts
            // prev is pointing to the left of the middle element
            if (prev != null) {
                  prev.next = null;
            }
            return slow;
      }

      public void reverse() {

            // return if head null (list empty)
            if (head == null) {
                  System.out.println("Reverse Not Possible");
                  return;
            }
            // Initialize 3 pointers like this
            Node currNode = head;
            Node prevNode = null;
            Node nextNode = null;
            // till the last node which will be null
            while (currNode != null) {
                  // first point the nextNode to element stored in the currNode
                  nextNode = currNode.next;
                  // update the link part of curr node to its prevNode
                  currNode.next = prevNode;
                  // point the prevNode so that we can update the nextNode's link part in next
                  // iteration
                  prevNode = currNode;
                  // now we can move the currNode to the nextNode
                  currNode = nextNode;
            }
            // at last point the head to the last node , that is the prevNode
            head = prevNode;
      }

      public Node mergeLists(Node h1, Node h2) {
            if (h1 == null && h2 == null) {
                  return null;
            }
            if (h1 == null && h2 != null) {
                  return h2;
            }
            if (h2 == null && h1 != null) {
                  return h1;
            }
            Node dummyHead = new Node(0);
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
                  // now we need to take one node from
                  // 1st and 2nd linked list alternatively
                  tail.next = h1;
                  tail = tail.next;
                  h1 = h1.next;
                  tail.next = h2;
                  h2 = h2.next;
                  tail = tail.next;
            }
            return dummyHead.next;
      }

      public void display(Node node) {
            Node temp = node;
            // Traverse the linked list and print the data values of each node
            while (temp != null) {
                  System.out.print(temp.data + " ");
                  temp = temp.next;
            }
      }
}

public class ReorderLinkedList {
      public static void main(String[] args) {
            SinglyLinkedListImplemented list = new SinglyLinkedListImplemented();
            list.head = list.new Node(1);
            list.head.next = list.new Node(2);
            list.head.next.next = list.new Node(3);
            list.head.next.next.next = list.new Node(4);
            list.head.next.next.next.next = list.new Node(5);
            list.head.next.next.next.next.next = list.new Node(6);
            System.out.println("Original List : ");
            list.display(list.head);
            SinglyLinkedListImplemented secondList = new SinglyLinkedListImplemented();
            secondList.head = list.divideList();
            System.out.println("\nDivided 1nd part of List : ");
            list.display(list.head);
            System.out.println("\nDivided 2nd part of List : ");
            list.display(secondList.head);
            secondList.reverse();
            System.out.println("\nReversed 2nd part of List : ");
            list.display(secondList.head);
            SinglyLinkedListImplemented mergedList = new SinglyLinkedListImplemented();
            mergedList.head = list.mergeLists(list.head, secondList.head);
            System.out.println("\nMerged List : ");
            list.display(mergedList.head);
      }
}
