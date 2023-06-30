//Swap nodes of a linked list of given k from Start and end
package LinkedList.Implementations;
public class swappingNodesOfALinkedList{
    static class Node{
        //'next' contains address/link to the next node
        Node next;
        //'data' is the data storage part
        int data;
        Node(int data){
            this.next = null;
            this.data = data;  
        }
    }
    public static void display(Node head){
        Node temp = head;
       
        // Traverse the linked list and print the data values of each node
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        } 
        System.out.println("");
    }
    public static void swapNodes(Node head , int k){
        //initialize head pointer
        Node slow = head;
        Node fast = head;
        //take the slow pointer to the kth node from start
        for(int i = 1 ; i < k ; i++){
           slow = slow.next; 
        }
        //store address of slow in temp keeping the slow pointer at the kth 
        Node temp = slow;
        //and then take the fast pointer to kth from end 
        //by making a pointer temp moving k steps before it 
        //so that when temp pointer reaches the end
        //fast pointer will be at the k th node from the end 
        while(temp.next!=null){
            temp = temp.next;
            fast = fast.next;
        }
        //now simply swap the data values of the kth nodes 
        int x = fast.data;
        fast.data = slow.data;
        slow.data = x; 
    }
    public static void main(String[] args) {
        int k = 2;
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(18);
        node.next.next.next = new Node(23);
        node.next.next.next.next = new Node(15);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next.next = new Node(11);
        node.next.next.next.next.next.next.next.next = new Node(3);
        System.out.println("Before Swapping : ");
        display(node);
        System.out.println("After Swapping : ");
        swapNodes(node, k);
        display(node);
    }
}