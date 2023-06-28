//Sort Linked list using Merge Sort (Best for sorting linked list)
//Time Complexity -> o(n log n)
//Auxiliary Spacae -> o(1)
package LinkedList.Implementations;
class LinkedListImplemented{
    Node head;
    int size = 0;
    //Each node has two parts - data part , link part
    class Node{
        //'next' contains address/link to the next node
        Node next;
        //'data' is the data storage part
        int data;
        Node(int data){
            this.next = null;
            this.data = data;  
        }
    }
    public void display(){
        Node temp = head;
        // Traverse the linked list and print the data values of each node
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        } 
        System.out.println();
    }
    public Node insertNodeAtEnd(int data){
        Node newNode = new Node(data);
        //if linkedlist empty ,the start the linked list from newNode
        if(head == null){
            head = newNode; 
        }
        else{
            Node temp = head;
            //traverse till end of the linked list
            while(temp.next != null){
                temp = temp.next;
            }
            // assigning the current last node's next to this newNode
            // thus newNode becomes the last node in Linked List
            temp.next = newNode;
            System.out.println(data+" inserted");
        }
        return head;
    }
    public Node mergeSort(Node head){
        //if head null or next element null return head
        if(head == null || head.next == null){
            return head;
        }
        else{
            //else get upto the middle element of the list 
            //and divide the list in left and right and 
            //apply mergesort on both and then merge both recursively
            Node middleNode = middle(head);
            Node middleRight = middleNode.next;
            //set the middle node to null
            middleNode.next = null;
            //recursively return the merged left and right and merge both
            return mergeSortedNodes(mergeSort(head),mergeSort(middleRight));
        }
    }
    public  Node middle(Node head){
        if(head == null){
            return head;
        }
        else{
            Node slow = head;
            Node fast = head;
            while(fast.next!=null && fast.next.next!=null){
                slow  = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
    public  Node mergeSortedNodes(Node n1 , Node n2){
       
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        Node answer=null;
        if(n1.data <= n2.data){
            answer = n1;
            answer.next = mergeSortedNodes(n1.next , n2);
        }
        else{
            answer = n2;
            answer.next = mergeSortedNodes(n1, n2.next);
        }
        return answer;
    }
}
public class sortLinkedList{
    

    public static void main(String[] args) {
        LinkedListImplemented list = new LinkedListImplemented();
        list.insertNodeAtEnd(9);
        list.insertNodeAtEnd(3);
        list.insertNodeAtEnd(7);
        list.insertNodeAtEnd(11);
        list.insertNodeAtEnd(6);
        list.insertNodeAtEnd(2);
        System.out.println("Unsorted List : ");
        list.display();
        System.out.println("Sorted List : ");
        list.head = list.mergeSort(list.head);
        list.display();
    }
}