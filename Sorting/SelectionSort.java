// Time Complexity : O(n^2) in all cases
// Space Complexity : O(1) as we are not using any extra space

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element from the unsorted part of the array and placing it at the beginning.
 * It divides the array into two parts: the sorted part and the unsorted part.
 * Initially, the sorted part is empty and the unsorted part is the entire
 * array.
 * The algorithm then selects the smallest element from the unsorted part and
 * swaps it with the leftmost element of the unsorted part.
 * This process continues until the entire array is sorted.
 * 
 * select min in each outer loop iteration and place it at the beginning
 **/

/*
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
*/

// to optimize , we will use a flag to skip if the min is already at the correct position , 
// i.e. the beginning of the unsorted array 
// 
// Time Complexity : still n^2 in worst case
// here we are just skipping the swap to decrease the number of operations

class Main {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int n = arr.length;
        System.out.print("Before : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        for(int i = 0 ; i < n ; i++){
            int min = arr[i];
            int minIndex = i;
            boolean flag = false;
            for(int j = i+1 ; j < n ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                    flag = true;
                }
            }
            if(flag){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;   
            }
        }
        System.out.print("\nAfter  : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}