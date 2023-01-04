

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
            System.out.println("Stack Under flow");
            return;
        }
        top = (top).link;
    }
    public int peep(int x , Node index){
        Node peepNode = new Node();
        if(top == null){
            System.out.println("Stack under flow");
            return -1;
        }
        else{
            return top.    
        }
    }

    public void display() {

        if (top == null) {
            System.out.printfln("Stack Underflow");
            exit(1);
        } else {
            Node temp = top;
            while (temp != null) {

                System.out.printf("%d->", temp.data);

                temp = temp.link;
            }
        }
    }
    public void change(){
        if(top = null){

        }
    }
}


public class StackUsingLinkedList {
    public static void main(String[] args) {

       Stack_Using_Linkedlist_Implement obj = new Stack_Using_Linkedlist_Implement();
        System.out.println("Enter choice 1 - PUSH , 2 - POP , 3 - PEEK, 4 - Display ");
        int choice = sc.nextInt();
        while(true){
            if(choice == 1){
                obj.push(sc.nextInt());
            }
            else if(choice == 2){
                obj.pop();
            }
            else if(choice == 3){
                obj.peek();
            }
            else if(choice == 4){
                obj.display();
            }
            else if(choice == 5){
                obj.peep((obj.head.link) , sc.next());
            }
            else if(choice == 6){
                System.exit(0);
            }
        }


    }
}
