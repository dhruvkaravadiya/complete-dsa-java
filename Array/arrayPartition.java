//find the sum of all the min of sorted pairs of 2 numbers for each in array
// example : 1,4,3,2 => min(1,2) + min(3,4) = 1 + 3 = 4
public class arrayPartition {
    public static int[] bubbleSort(int arr[]){
        int size = arr.length;
        for(int i = 0 ; i < size ; i++){
            boolean flag = false;
            for(int j = 0 ; j < size - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    flag = true;
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                }
            }
            if(!flag){
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {1,4,3,2};
        int arr2[] = bubbleSort(arr);
        System.err.println(arr2[1]);
        int sum = 0;
        for(int i = 0 ; i < arr2.length-1 ; i+=2){
            sum+=Math.min(arr2[i], arr2[i+1]);
        }
        System.out.println("Sum : "+sum);
    }  
}