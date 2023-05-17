//Naive Approach

// public class countTriplets {
//     public static void main(String[] args) {
//         int arr[]={2, 5, 1, 3, 0};
//         int n = arr.length;
//         int count=0;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i+1 ; j < n ; j++){
//                 for(int k = j+1 ; k < n ; k++){
//                     if(arr[k] < arr[i] && arr[i] < arr[j]){
//                         count++;
//                     }
//                 }
//             }
//         }
//         System.out.println(count);
//     }   
// }

//Optimized Approach
public class countTriplets{
    public static void main(String[] args) {
        int arr[]={2, 5, 1, 3, 0};
        int n = arr.length;
        int ans=0;
        for(int i = 0 ; i < n ; i++){
            int count=0;
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] > arr[i]){
                    count++;
                }
                else{
                    ans+=count;
                }
            }
        }
        System.out.println(ans);
    }
}