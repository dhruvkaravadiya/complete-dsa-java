

//Implement Stack Using Array
import java.util.Scanner;

class StackImplement {
    private int Top = -1; // Initialize Top Pointer

    private int N = 10;// Initialize N size of array

    // Method to set the size of array into N variable
    // void setSize(int n) {
    //     this.N = n;
    //     System.out.println("size  : " + N);
    // }

    int[] stack = new int[N];

    public void PUSH(int pustElement) {
        // Check stack overflow
        if (Top >= N) {
            System.out.print("Stack Overflow / Full");
        } else {
            Top++;
            stack[Top] = pustElement;

        }
    }

    public int POP() {
        if (Top == -1) {
            System.out.print("Stack Underflow / Empty");
            return 0;
        } else {
            return stack[Top--];
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

public class testrun {
    public static void main(String[] args) {
        Scanner scObj = new Scanner(System.in);

        StackImplement stkObj = new StackImplement();
        //stkObj.setSize(Integer.parseInt(args[0]));
        boolean flag = true;
        while (flag == true) {
            System.out.println("Choose Operation : 1 - PUSH , 2 - POP , 3 - PEEK , 4 - DISPLAY , 5 - EXIT");
            String choice = scObj.next();
            switch (choice) {
                case "1":
                    stkObj.PUSH(scObj.nextInt());
                    break;
                case "2":
                    stkObj.POP();
                    break;
                case "3":
                    stkObj.PEEK();
                    break;
                case "4":
                    stkObj.DISPLAY();
                    break;
                case "5":
                    flag = false;
                    break;
            }

        }
    }
}
