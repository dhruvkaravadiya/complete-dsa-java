package LinkedList;

import java.util.Stack;

public class palindromeLinkedListOrNot {
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
    static void display(Node head) {
        Node temp = head;
        // Traverse the linked list and print the data values of each node
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
         System.out.println("");
    }
    static boolean isPalindrome(Node head){
        if(head == null){
            return false;
        }
        Node temp = head;
        Stack<Integer> stk = new Stack<Integer>();
        while(temp != null){
            stk.push(temp.data);
            temp = temp.next;
        }
        boolean flag = true;
        while(head!=null){
            int i = stk.pop();
            if(i == head.data){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
            head = head.next;
        }
        return flag;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(1);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);
        if(isPalindrome(node)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
