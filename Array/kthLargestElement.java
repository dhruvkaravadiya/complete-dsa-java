package Array;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class kthLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k th largest index for element : ");
        int k = sc.nextInt();
        int arr[] = {21,13,6,51,48,91,2,39};
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0 ; i < arr.length ; i++){
            queue.add(arr[i]);
            if(queue.size() > k){
                queue.remove(queue.peek());
            }
        }
        System.out.println(k+"th largest element is : "+queue.peek());  
        sc.close();
    }
}
