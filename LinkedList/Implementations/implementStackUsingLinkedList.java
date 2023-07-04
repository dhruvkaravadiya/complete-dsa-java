package LinkedList.Implementations;

class StackUsingArrayImplementation{
    Node TOP;
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
   StackUsingArrayImplementation() { this.TOP = null; }
    //PUSH : 
    //simply create a new Node and insert it
    void PUSH(int data){
        Node newNode = new Node(data);
        if(TOP == null){
            TOP = newNode;
            return;
        }
        newNode.next = TOP;
        TOP = newNode;
    }
    //POP :
    void POP(){
        //check if the list if empty
        if(TOP == null){
            System.out.println("Stack Underflow , can't delete");
            return;
        }
        //TOP = null;
        TOP = TOP.next;
    }
    //PEEK : 
    void peek(){
        //check if the list is empty
        if(TOP == null){
            System.out.println("Stack Underflow , can't peek");
            return;
        }
        System.out.println(TOP.data);
    }
    public void display(){
        Node temp = TOP;
        // Traverse the linked list and print the data values of each node
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        } 
    }
}
public class implementStackUsingLinkedList{
    public static void main(String[] args) {        
        StackUsingArrayImplementation node = new StackUsingArrayImplementation();
        node.PUSH(1);
        node.PUSH(2);
        node.PUSH(3);
        node.PUSH(4);
        node.PUSH(5);
        System.out.print("Stack before : ");
        node.display();
        node.POP();
        System.out.print("Stack After : ");
        node.display();
    }
}