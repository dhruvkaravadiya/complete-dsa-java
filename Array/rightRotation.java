import java.util.Scanner;
public class rightRotation{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the time to rotate Right : ");
        int k = sc.nextInt();
        int[] temp = new int[k];
        int n = arr.length;
        int x = 0;
        for(int i = n-k ; i <= n-1 ; i++){
            temp[x] = arr[i];
            x++;
        }
        for(int i = n-1 ; i > k-1 ; i--){
            arr[i] = arr[i-k];
        }
        for(int i = 0 ; i < k ; i++){
            arr[i] = temp[i];
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}