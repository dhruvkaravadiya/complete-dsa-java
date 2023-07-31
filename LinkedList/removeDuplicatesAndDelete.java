//Remove duplicates in Unsorted linked list using HASHING
// Time Complexity = O( n )
// Auxiliary Space = O( 1 )
package LinkedList;
import java.util.TreeMap;

public class removeDuplicatesAndDelete {
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
        // Inilialize a treemap
        TreeMap<Integer,Integer> map = new TreeMap<>(); 
        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = head;
        //first lets create a tree-map containing the number as key 
        //and times it gets repeated as value
        while(curr!=null){
            map.put(curr.data , map.getOrDefault(curr.data,0)+ 1);
            curr = curr.next;
        }
        //then take each element from the map
        //and make a new linked list of non-repeating nodes
        for(int i : map.keySet()){
            if(map.get(i) != 1){
                Node newNode = new Node(i);
                //move the prev pointer to the newNode
                prev.next = newNode;
                prev = newNode;
            }
        }
        display(dummy.next);
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
       
    }
}
