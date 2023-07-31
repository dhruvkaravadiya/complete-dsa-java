//implement selection sort
//Algo : With each iteration the smallest element is 
//       placed at the first index of the unsorted array
package Sorting;
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {10,9,8,7,6,5,4,3,2,1};
        int size = arr.length;
        System.out.print("Before : ");
        for(int i = 0 ; i < size ; i++ ){
            System.out.print(arr[i] + " ");
        }
        
        for(int i = 0 ; i < size ; i++){
            int min = arr[i];
            int minIndex = i;

            for(int j = i; j < size ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }   
           int temp =  arr[minIndex];
           arr[minIndex] = arr[i];
           arr[i] = temp;
        }

        System.out.print("\nAfter : ");
        for(int i = 0 ; i < size ; i++ ){
            System.out.print(arr[i] + " ");
        }
    }
}
