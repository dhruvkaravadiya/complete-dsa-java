// Singly Linked List Implementation using Single Head Pointer
package LinkedList.Implementations;

// import java.util.ArrayList;
// import java.util.List;

class SinglyLinkedListImplemented{
    //Node head = null is also same as Node head , 
    //as not assigning value to head makes it null
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
    public Node insertNodeAtStart(int data){
        Node newNode = new Node(data);
        //if linked list empty  , then start from the newNode as the first element
        if(head == null){
            head = newNode; 
        }
        else{
            //let the link part of newNode store link to where head was pointing 
            newNode.next = head;
            //and then move the head to point the newNode
            head = newNode;
            System.out.println(data+" inserted");
        }  
        size++;
        return head;
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
        size++;
        return head;
    }
    public Node insertAtNthPosition(int data,int insertIndex){
        Node newNode = new Node(data);
        int currIndex=0;
        if(head == null){
            head = newNode;
        }
        else{
            //create a temp node to traverse to the insert position
            Node prev = head;
            //traverse to the index and keep track of the currIndex
            while(currIndex != insertIndex-1){
                prev = prev.next;
                currIndex++;
            }
            //after reaching the insert index , 
            //first store the link part of temp in another node,
            //which is pointing to its next node
            Node temp = prev.next;
            //change the link part of the temp node to the link part of the newNode
            prev.next = newNode;
            // then store the link part of next node in the newNode's link part
            newNode.next = temp;
            System.out.println(data+" inserted");
        }
        //increament size of linkedlist
        size++;
        return head;
    }
   
    public void deleteFirstNode(){
        //if head null , linkedlist empty
        if(head == null){
            System.out.println("Linked List Empty, no deletion possible");
        }
        //else print which element deleted 
        else{
            System.out.print(head.data+" deleted");
            //to delete , simply move the head pointer to the next node,
            //so current node is lost(deleted)
            head = head.next;
        }
        size--;
    }
    public void deleteLastNode(){
        if(head == null){   
            System.out.println("Linked List Empty , no deletion possible");
        }
        else{
            //simply removing the link part of last second node , 
            //so that the link to the last node is lost
            //for that we will traverse to the second last node
            Node temp = head;
            while(temp.next.next != null){
                //change the link part of second last node to null , 
                //so now the last node is temp
                temp = temp.next;
            }
            //at the end change the link part of the second last node to null
            temp.next = null;
            System.out.println(temp.data+" deleted");
        }
        size--;
    }
    public void deleteNthNode(int deleteIndex){
        // Check if the linked list is empty
        if(head == null){
            System.out.println("Linked List Empty, no deletion possible");
        }
        else{
            Node temp = head;
            int x=0;
            // Traverse the linked list to find the node just before the one to be deleted
            while(x != deleteIndex-1){
                temp = temp.next;
                x++;
            }
            // Remove the link to the node to be deleted by connecting the previous node to the one after
            temp.next = temp.next.next;
            System.out.println(temp.data+" deleted");
        }
    }
    
    public Node searchByValue(int data){
        // Check if the linked list is empty
        if(head == null){
            System.out.println("No element found, as LinkedList is empty");
            return null;
        }
        else{
            int index=0;
            Node temp = head;
            // Traverse the linked list to find the node with the given data value
            while(temp.data != data){
                temp = temp.next;
                index++;
                // If we reach the end of the linked list without finding the data value, print a message and return null
                if(temp == null){
                    System.out.println("Element not found in the list");
                    return null;
                }
            }
            // Print the index where the data value was found and return the node
            System.out.println("\nElement found at index : "+index);
            return temp;
        }
    }
    public void reverse(){
        Node temp = head;
    }
    public void display(){
        Node temp = head;
        System.out.print("\nList : ");
        // Traverse the linked list and print the data values of each node
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
       
    }
    
    
}
public class singlyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListImplemented list = new SinglyLinkedListImplemented();
        list.insertNodeAtStart(1);
        list.insertNodeAtStart(2);
        list.insertNodeAtStart(3);
        list.insertNodeAtStart(4);
        list.insertNodeAtStart(5);
        list.insertNodeAtEnd(-1);
        list.insertNodeAtEnd(-2);
        list.insertNodeAtEnd(-3);
        list.insertNodeAtEnd(-4);
        list.insertNodeAtEnd(-5);
        list.insertAtNthPosition(0, 5);
        list.deleteNthNode(3);
        list.display();
        list.searchByValue(0);
    }
}
