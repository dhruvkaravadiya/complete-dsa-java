package LinkedList;

import java.util.LinkedList;
//import java.util.List;

public class mergeTwoSortedLinkedList {

    // Linked List approach
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        int a1[] = { 1, 2, 4 };
        int a2[] = { 1, 3, 4 };

        for (int i = 0; i < a1.length; i++) {
            list1.add(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            list2.add(a2[i]);
        }
        int x = list1.size();
        int y = list2.size();
        int result[] = new int[x + y];
        int i = 0, j = 0, k = 0;
        while (i < x && j < y) {
            if (list1.get(i) < list2.get(j)) {
                result[k] = list1.get(i);
                i++;
                k++;
            } else {
                result[k] = list2.get(j);
                k++;
                j++;
            }
        }
        while (i < x) {
            result[k] = list1.get(i);
            k++;
            i++;
        }
        while (j < y) {
            result[k] = list2.get(i);
            k++;
            j++;
        }
        for (int z = 0; z < x + y; z++) {
            System.out.print(result[z] + " ");
        }
    }

    // Listnode Appraoch
    // //make a class ListNode
    // public static void main(String[] args) {
    // ListNode tempHead = new ListNode(-1);
    // ListNode currNode = tempHead;
    // while(){

    // }
    // }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}