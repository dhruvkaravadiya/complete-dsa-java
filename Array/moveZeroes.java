public class moveZeroes {
    public static void main(String[] args) {
        int arr[] = {0,1,0,1,2};
        // int arr[] = {0};
        // int arr[] = {};    
        int k = 0;
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==0){
                k++;
            }
            else if(k>0){
                arr[i-k] = arr[i];
                arr[i] = 0;
            }
        }  
        for(int i  = 0 ; i < n ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
