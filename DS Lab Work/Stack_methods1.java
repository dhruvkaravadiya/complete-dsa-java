//Write program to implement PUSH, POP ,PEEK , PEEP , CHANGE , D 
import java.util.Scanner;
class Stack_implement_methods {
    int[] a;
    int top = -1;

    void setSize(int n){
        a=new int[n];
    }

    void push(int n) {
        if (top >= a.length) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            a[top] = n;
        }
    }

    int peep(int i) {
        if (top - i + 1 <= -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return a[i];
        }
    }

    int pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }

    int peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return a[top];
        }

    }

    void change(int i, int n) {

        if (top - i + 1 <= -0) {
            System.out.println("Stack Underflow");
        } else {
            a[i] = n;
        }
    }

    void display() {
        if(top<=-1){
            System.out.println("Stack is underflow");
        }
        else{
            for(int i=0;i<=top;i++){
                System.out.print(a[i]+"  ");
            }
            System.out.println();
        }
    }
}

public class Stack_methods1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack_implement_methods S = new Stack_implement_methods();
        System.out.println("Enter Stack size");
        int n = sc.nextInt();
        S.setSize(n);
        while(true){
            System.out.println("\n1. for push\n2.for pop \n3. for Display \n4.exit");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter a value for Push: ");
                S.push(sc.nextInt());
            }
            else if(m==2){
                System.out.println("Element Popped: "+S.pop());
            }
            else if(m==3){
                S.display();
            }
            else if(m==4){
                break;
            }
        }
        sc.close();
    }

}