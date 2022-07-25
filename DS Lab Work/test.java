// Linked list operations in Java

class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insertAtBeginning(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    void deleteNode(int position) {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {

                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }

    }

    public static void main(String[] args) {
        LinkedList listObj = new LinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while(true){
            System.out.println("Enter operation : \n1 - Enter at Beginning \n2 - Enter after \n3 - Enter at end \n4 - Delete\n5 - Print\n6 - Search  ");
            
            int choice = sc.nextInt();
                if(choice == 1){
                    System.out.println("Enter 1st element: ");
                    listObj.insertAtBeginning(sc.nextInt());   
                }
                else if(choice == 2){
                    System.out.println("Enter next element: ");
                    listObj.insertAfter(listObj.head.next,sc.nextInt()); 
                }
                else if(choice == 3){
                    System.out.println("Enter last element");
                    listObj.insertAtEnd(sc.nextInt());
                }
                else if(choice == 4){
                    listObj.deleteNode(sc.nextInt());
                }
                 
                    
                else if(choice == 5){   
                    listObj.printList();
                }
                else if(choice == 7){
                    System.exit(0);
                }
            
         }
        


   
       

        // listObj.sortLinkedList(listObj.head);
        // System.out.println("\nSorted List: ");
        // listObj.printList();
        
    }
}
