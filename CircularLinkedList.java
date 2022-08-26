// Linked list operations in Java

class Main {
    static Node head;
    static  Node rev;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public void insert(int new_data) {
        Node node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = node;
        node.prev = last;
        rev = node;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            
            tnode = tnode.next;
        }
        System.out.println();
    }
    public void revPrint(){
        Node tempNode = rev;
        while(tempNode.prev!=null){
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.prev;
        }
    }

    public static void main(String[] args) {
        Main listObj = new Main();
        listObj.insert(1);
        listObj.insert(2);
        listObj.insert(3);
        listObj.insert(4);
        listObj.insert(5);
        listObj.insert(6);
        listObj.insert(7);
        listObj.insert(8);
        listObj.insert(9);
        listObj.insert(10);
        
        listObj.printList();
        listObj.revPrint();
    }
}
