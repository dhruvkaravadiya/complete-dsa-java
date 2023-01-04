public class insertion_sort {
    public static void main(String[] args) {
        int [] arr  = {3,5,4,9,6,1,2,10,7,8};
        int j = 0;
        for(int i = 1 ; i < 9 ; i++ ){
           int x = arr[i];
           j =i-1;
           while(x < arr[j] && j>0){
                arr[j+1] = arr[j];
                j--;
           } 
           arr[j+1] = x;
        }
        for(int i = 0 ; i < 10 ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
