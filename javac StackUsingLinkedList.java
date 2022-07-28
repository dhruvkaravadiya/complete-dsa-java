
import static java.lang.System.exit;

class Stack_Using_Linkedlist_Implement {
    private class Node {
        int data;
        Node link;
    }

    Node top;

    Stack_Using_Linkedlist_Implement() {
        this.top = null;
    }

    public void push(int x) {
        Node temp = new Node();
        if (temp == null) {
            System.out.print("\nStack Overflow");
            return;
        }
        temp.data = x;
        temp.link = top;
        top = temp;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void pop() {

        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
        top = (top).link;
    }

    public void display() {

        if (top == null) {
            System.out.printf("\nStack Underflow");
            exit(1);
        } else {
            Node temp = top;
            while (temp != null) {

                System.out.printf("%d->", temp.data);

                temp = temp.link;
            }
        }
    }
}


public class StackUsingLinkedList {
    public static void main(String[] args) {

       Stack_Using_Linkedlist_Implement obj = new Stack_Using_Linkedlist_Implement();
        System.out.println("Enter choice 1-PUSH , 2-POP , 3-PEEK,4-Display , ");
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
        obj.display();
        System.out.printf("\nTop :\n"+ obj.peek());
        obj.pop();
        obj.pop();
        obj.display();
        System.out.printf("\nTop :\n"+ obj.peek());
    }
}
