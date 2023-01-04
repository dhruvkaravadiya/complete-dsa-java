//Implement Stack Using Array
import java.util.Scanner;

class StackImplement {
    int Top = -1; // Initialize Top Pointer
    public int N = 0;// Initialize N size of array
    // Method to set the size of array into N variable
    int [] stack;
    public void setSize(int size) {
        this.N = size;
        stack = new int[N];
    }

    // Initialize Stack of N size
    
    public int PUSH(int pustElement) {
        // Check stack overflow
        if(Top >= N){
            System.out.println("Stack Overflow / Full");
            return 0;
        }
        else{
            Top++;
            stack[Top] = pustElement;
            return Top;
        }
    }

    public int POP() {
        if (Top == -1) {
            System.out.print("Stack Underflow / Empty");
            return 0;
        } else {
            Top--;
            return stack[Top];
        }
    }

    public int PEEK() {
        if (Top == -1) {
            System.out.print("Stack Underflow / Empty");
            return 0;
        } else {
            return stack[Top];
        }
    }

    public void DISPLAY() {
        int x = Top;
        System.out.println("Stack : ");
        while (x > -1) {
            System.out.print(stack[x]+" ");
            x--;
        }
        System.out.println();
    }
    public void CHANGE(int x , int index){
        if(Top == -1){
            System.out.println("Stack Underflow");
        }
        else{
            stack[Top-index+1] = x;
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Scanner scObj = new Scanner(System.in);
        StackImplement stkObj = new StackImplement();
        System.out.println("Enter Size of Stack");
        int size = scObj.nextInt();
        stkObj.setSize(size);
        boolean flag = true;
        while (flag) {
            System.out.println("Choose Operation : 1 - PUSH , 2 - POP , 3 - PEEK , 4 - DISPLAY , 5 - CHANGE, 6 - EXIT");
            int choice = scObj.nextInt();
                if(choice== 1)
                    stkObj.PUSH(scObj.nextInt());
                else if(choice == 2)
                    stkObj.POP();
                else if(choice == 3)
                    stkObj.PEEK();
                else if(choice == 4)
                    stkObj.DISPLAY();
                else if(choice == 5)
                    stkObj.CHANGE(3,1);
                else
                    flag = false;
        }
    }
}
