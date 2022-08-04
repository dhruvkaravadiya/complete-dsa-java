import java.util.Scanner;
class Quene_Methods{
    int front = 0;
    int rear = -1;
    int [] que = new int[5];
    void anque(int n){
        if(rear>5){
            System.out.println("Quene Overflow");   
        }
        else if(rear == 4){
            rear = (rear+1)%5;
            que[rear] = n;
        }
        else{
            rear++; 
            que[rear] = n; 
        }
    }
    void deque(){
        if(front<0){
            System.out.println("Quene UnderFlow");
            
        }
        else{
            front++;
            System.out.println(que[front-1]);
            System.out.println(rear);

        }
    }
    void display(){
        for(int i=0;i<que.length;i++){
            System.out.print(que[i]+" , ");
        }
    }
}
public class CircularQueue{
    public static void main(String[] args) {
        Quene_Methods obj = new Quene_Methods();
        Scanner sc = new Scanner(System.in);      
        while(true){
            System.out.println("Enter operation 1-Anque , 2 - Deque ,3 - Display ,4 - Terminate");
            int operation = sc.nextInt();

                if(operation == 1){
                    System.out.println("Enter number : ");
                    obj.anque(sc.nextInt());
                    
                }
                else if(operation == 2){
                    obj.deque();
                   
                }
                else if(operation == 4){
                    break;
                }  
                else if(operation ==3){
                    obj.display();
                }  
        }
    }
}
