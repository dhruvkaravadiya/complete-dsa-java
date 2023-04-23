package Array;
public class arrayReverse{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int last = arr.length-1;
        int front = 0;
        while(front < last){
            int temp = arr[front];
            arr[front] = arr[last];
            arr[last] = temp;
            front++;
            last--;
        }  
        for(int j = 0 ; j < arr.length ; j++){
            System.out.print(arr[j]+" ");
        }
    }
}