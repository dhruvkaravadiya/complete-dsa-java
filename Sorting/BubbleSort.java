// Time Complexity : 
// O(n^2) in worst case 
// O(n) in best case

//Algo : Compare two elements , if the first is greater,then
// swap it  with second , thus at the end of one for loop iteration 
//greatest will be at the end  , and the remaining array remains intaact
/* 

Regular Bubble Sort without flag

class Main {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int n = arr.length;
        System.out.print("Before : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        for(int i = 0 ; i < n ; i++){
               for(int j = 0 ; j < n-1 ; j++){
                   if(arr[j] > arr[j+1]){
                       int temp = arr[j];
                       arr[j] = arr[j+1];
                       arr[j+1] = temp; 
                   }
               }
        }
         System.out.print("after : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
*/

// Optimized Bubble Sort
// Apply flag to check if array already sorted
// make the inner loop upto n-i-1 because after each iteration 
// the largest element will be at the end of the array
// so no need to consider the last on in the next iteration of outer loop

public class BubbleSort {
    public static void main(String[] args) {
        // here we are taking the worst case for test run
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int n = arr.length;
        System.out.print("Before : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }

        }

        System.out.print("\nAfter Bubble Sort : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
