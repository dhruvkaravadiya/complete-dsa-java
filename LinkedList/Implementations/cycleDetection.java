package LinkedList.Implementations;
//Cycle Detection Using Floyd' Cycle Detection Algorithm

//Time Complexity : O(n)
//Auxiliary Spcae : O(1)

public class cycleDetection {
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
    static boolean detectCycle(Node head){
        if(head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        boolean flag = false;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                flag = true;
                break;
            } 
        }
        return flag;
    }
    public static void main(String[] args) {
        Node list = new Node(0);
        list.next = new Node(1);
        Node temp = list.next.next = new Node(2);
        list.next.next.next = new Node(3);
        list.next.next.next.next = new Node(4);
        list.next.next.next.next.next = new Node(5); // Make the last node point back to the second node
        list.next.next.next.next.next.next = temp;   
        System.out.println(detectCycle(list));
    }
}
