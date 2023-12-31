package Hashing;
import java.util.HashMap;

public class numberOfPairs{
    // public static void main(String[] args) {
    //     int  arr[] = {1,2,3,1,1,3};
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i+1 ; j < n ; j++){
    //             if(i < j && arr[i] == arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     System.out.println(count);
    // }

    public static void main(String[] args){
        int arr[]  = {1,2,3,1,1,3};
        int n = arr.length; 
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                count+=map.get(arr[i]);
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        System.out.println(count);
    }
}