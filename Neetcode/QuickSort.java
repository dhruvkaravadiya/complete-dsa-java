import java.util.Arrays;
public class quicksort {
    // You implement this
    static void quicksort(int[] arr, int low, int high) {
        if(low < high){
            int pivot = partition(arr , low , high);
            quicksort(arr , low , pivot-1);
            quicksort(arr , pivot+1 , high);
        }
    }


    // You can add your partition method here
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low ; j < high ; j++){
            if(arr[j] < pivot){
                i++;
                
                int x = arr[j];
                arr[j] = arr[i];
                arr[i] = x; 
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {10, 7, 8, 9, 1, 5};

        // Test Case 2
        int[] arr2 = {5, 4, 3, 2, 1};

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};

        // Test Case 4
        int[] arr4 = {10, 10, 5, 5, 1, 1};

        // Test Case 5
        int[] arr5 = {3};

        // Test Case 6
        int[] arr6 = {};

        // Test Case 7
        int[] arr7 = {9, 3, 7, 1, 8, 2, 6, 4, 5};

        // Test Case 8
        int[] arr8 = {100, 20, 50, 10, 80, 30};

        // Test Case 9
        int[] arr9 = {-5, 3, -2, 8, 0, -10, 4};

        // Test Case 10
        int[] arr10 = {5, 5, 5, 5, 5};


        // Calling Quick Sort
        quicksort(arr1, 0, arr1.length - 1);
        quicksort(arr2, 0, arr2.length - 1);
        quicksort(arr3, 0, arr3.length - 1);
        quicksort(arr4, 0, arr4.length - 1);
        quicksort(arr5, 0, arr5.length - 1);
        quicksort(arr6, 0, arr6.length - 1);
        quicksort(arr7, 0, arr7.length - 1);
        quicksort(arr8, 0, arr8.length - 1);
        quicksort(arr9, 0, arr9.length - 1);
        quicksort(arr10, 0, arr10.length - 1);


        // Printing results
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.toString(arr6));
        System.out.println(Arrays.toString(arr7));
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.toString(arr9));
        System.out.println(Arrays.toString(arr10));
    }


    
}