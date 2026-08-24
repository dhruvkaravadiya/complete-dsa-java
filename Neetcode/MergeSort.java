// O(n log n) in all cases
import java.util.Arrays;
public class MergeSort{

    public static void MergeSort(int[] arr , int low , int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            MergeSort(arr, low, mid);
            MergeSort(arr, mid+1, high);
            merge(arr , low, mid , high);
        }


    }

    //steps for doing merge
    // keep dividing until the array size is just 1
    public static void merge(int[] arr , int low , int mid , int high){
        // get the sizes of both the arrays first
        int size1 = mid - low + 1;
        int size2 = high - mid;

        // make temporary arrays
        int L[] = new int[size1];
        int R[] = new int [size2];

        // now copy element from array to temp arrays so
        //  then we can sort them and add them to the original array
        for(int i = 0 ; i < size1 ; i++){
            L[i] = arr[low+i];
        }
        for(int i = 0 ; i < size2 ; i++){
            R[i] = arr[i+mid+1];
        }

        // now we have to sort them
        // i and j pointers to walk through both arrays and 
        // increment them when we have to put a element in the original array
        int i = 0;
        int j = 0;
        // from low we need to enter the sorted elements which we will get from the temporary array
        int k = low;
        while(i < size1 && j < size2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        // after this process maybe i or j have not reached the end , so now we add rest

        // now just add the remaining elements
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < size2){
            arr[k] = R[j];
            j++;
            k++;
        }
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
        MergeSort(arr1, 0, arr1.length - 1);
        MergeSort(arr2, 0, arr2.length - 1);
        MergeSort(arr3, 0, arr3.length - 1);
        MergeSort(arr4, 0, arr4.length - 1);
        MergeSort(arr5, 0, arr5.length - 1);
        MergeSort(arr6, 0, arr6.length - 1);
        MergeSort(arr7, 0, arr7.length - 1);
        MergeSort(arr8, 0, arr8.length - 1);
        MergeSort(arr9, 0, arr9.length - 1);
        MergeSort(arr10, 0, arr10.length - 1);


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
