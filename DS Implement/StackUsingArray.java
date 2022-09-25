//Implement Stack Using Array
import java.util.Scanner;

class StackImplement {
    int Top = -1; //Initialize Top Pointer
    
    int N = 0;//Initialize N size of array
   
     //Method to set the size of array into N variable
     public void setSize(int N) {
         this.N = N;
     }
    
    //Initialize Stack of N size
    int[] stack = new int[N];

    
    public int PUSH(int pustElement) {
        //Check stack overflow
        if (Top >= N) { 
            System.out.print("Stack Overflow / Full");
            return 0;
        } else {
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
        while (x > -1) {
            System.out.print(stack[x]);
            x--;
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Scanner scObj = new Scanner(System.in);
        StackImplement stkObj = new StackImplement();
        System.out.println("Enter Size of Stack");
        stkObj.setSize(scObj.nextInt());
        boolean flag = true;
        while (flag) {
            System.out.println("Choose Operation : 1 - PUSH , 2 - POP , 3 - PEEK , 4 - DISPLAY , 5 - EXIT");
            int choice = scObj.nextInt();
            switch (choice) {
                case 1:
                    stkObj.PUSH(scObj.nextInt());
                    break;
                case 2:
                    stkObj.POP();
                    break;
                case 3:
                    stkObj.PEEK();
                    break;
                case 4:
                    stkObj.DISPLAY();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        
        }
    }
}
