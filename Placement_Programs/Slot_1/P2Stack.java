import java.util.Scanner;

class MinStack{
    int TOP;   
    int arr[]; 
    int min;
    MinStack(){

    }

    MinStack(int size){
        this.TOP = -1;
        this.arr = new int[size];
        this.min= Integer.MAX_VALUE;
    }
   
    void push(int data){
       if(TOP >= arr.length-1){
        System.out.println("Stack Overflow");
        return;
       }
       else{
        if(data <= min){
            TOP++;
            arr[TOP] = min;
            min = data;
        }
        arr[TOP] = data;
        return;
       }
    }

    int pop(){
        if(TOP<=0){
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = arr[TOP--];
        if(popped == min){
            min = arr[TOP--];
        }
        return TOP;    
    }

    int TOP(){
        if(TOP <= 0){
            return -1;
        }
        return arr[TOP];
    }

    int getMin(){
        if(arr.length == 0 || TOP == -1){
            System.out.println("Array Empty");
            return -1;
        }     
        return min;
    }


    void display(){
        if(arr.length <= 0){
            //System.out.println("Stack Empty");
        }
        else{       
            for(int i = 0; i <= TOP ; i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}

public class P2Stack {
    public static void main(String[] args) {
        MinStack stk = new MinStack(10);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of functions : ");
        int numFunctions = sc.nextInt();
        String[] functions = new String[numFunctions];
        int[][] values = new int[numFunctions][1];
        int[] result = new int[numFunctions];
        System.out.println("Enter the functions and their values (if any):");
        for (int i = 0; i < numFunctions; i++) {
            functions[i] = sc.next();
            if ("push".equals(functions[i])) {
                values[i][0] = sc.nextInt();
            }
        }
        for (int i = 0; i < functions.length; i++) {
            if ("minstack".equals(functions[i])) {
                stk = new MinStack(10);
                result[i] = -1;
            } else if ("push".equals(functions[i])) {
                stk.push(values[i][0]);
                result[i] = -1;
            } else if ("pop".equals(functions[i])) {
                result[i] = stk.pop();
            } else if ("top".equals(functions[i])) {
                result[i] = stk.TOP();
            } else if ("getMin".equals(functions[i])) {
                result[i] = stk.getMin();
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }   

}
