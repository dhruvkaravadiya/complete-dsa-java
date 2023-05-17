import java.util.Arrays;

public class PythagoreanTriplets{
    // public static void main(String[] args) {
    //     int arr[] = {3,1,2,4,5};
    //     int n = arr.length;
    //     int count=0;
    //     for(int i = 0 ;i < n ; i++){
    //         for(int j = i+1 ; j < n ; j++){
    //             for(int k = j + 1 ; k< n ; k++){
    //                 int a = arr[i] * arr[i];
    //                 int b = arr[j] * arr[j];
    //                 int c = arr[k] * arr[k];
    //                 if(a == b + c  || b == a + c || c == b + a){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4,5};
        int n = arr.length;
        int count = 0;
        for(int i = 0  ; i< n ;i++){
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        for(int i = n-1 ; i >= 2 ; i--){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(arr[l] + arr[r] == arr[i]){
                    count++;
                }
                if(arr[l] + arr[r] < arr[i]){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        System.out.println(count);
    }
}