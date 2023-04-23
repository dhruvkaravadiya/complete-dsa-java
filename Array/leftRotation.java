package Array;

import java.util.Scanner;
public class leftRotation{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the time to rotate Left : ");
        int k = sc.nextInt();
        int[] temp = new int[k];
        int n = arr.length;
        for(int i = 0 ; i < k ; i++){
            temp[i] = arr[i];
        }

        for(int i = k ; i < n ; i++){
            arr[i-k] = arr[i];
        }
        int x = k;
        for(int i = n-k ; i < n ; i++){
            arr[i] = temp[k-x];
            x--;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}