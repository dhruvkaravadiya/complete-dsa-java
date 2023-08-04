//Time Complexity - O(n log n)
//Merge Sort using Divide And Conquer
//Algo : Keep dividing the array until only 1 left , 
// then sort then and marge them recursively
package Sorting;

public class MergeSort {
    //here we will sort and combine the arrays recursively
    //array 1 will always be - arr[left...mid]
    //array 2 will always be - arr[mid+1...right]
    static void merge(int[] arr , int left,int mid, int right){
        //first get size of the two arrays
        int s1 = mid-left+1;
        int s2 = right-mid;
        //create temperory arrays
        int L[] = new int[s1];
        int R[] = new int[s2];
        //copy elements from the arr array to the two arrays
        for(int i = 0 ; i < s1 ; i++){
            L[i] = arr[left+i];
        }
        for(int i = 0 ; i < s2 ; i++){
            R[i] = arr[i+mid+1];
        }

        //sort the two arrays
        int i = 0;
        int j = 0;
        int k = left;
        while(i < s1 && j < s2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any left
        while (i < s1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any left
        while (j < s2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //here we will recursively divide the recursively
    static void mergeSort(int[] arr,int left, int right){
        if(left < right){
            int mid = left+(right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.print("Before Merge Sort : ");
        printArray(arr);
        mergeSort(arr,0,arr.length-1);
        System.out.print("After Merge Sort : ");
        printArray(arr);
        
    }
}
