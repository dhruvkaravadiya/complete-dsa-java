package Others;
public class c_sort {
    public static void main(String[] args) {
        int [] arr  = {3,5,5,4,9,6,1,1,2,10,7,7,8};
        int [] temp = new int[10];
        int [] answer = new int[14];
        for(int i = 0 ; i < 9 ; i++){
            temp[i] = 0;
        }
        for(int i = 0 ; i < 14 ; i++){
            temp[arr[i]] = temp[arr[i]] + 1;
        }
        for(int i = 1 ; i < 10 ; i++){
            temp[i] = temp[i] + temp[i-1];
        }
        for(int i = 14 ; i >=1 ; i-- ){
            answer[temp[arr[i]]] = arr[i];
            answer[arr[i]] = answer[arr[i]] -1;
        }
        for(int i = 0 ; i < 14 ; i++ ){
            System.out.print(answer[i]+" ");
        }
    }
}
