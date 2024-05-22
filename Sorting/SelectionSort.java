/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element from the unsorted part of the array and placing it at the beginning.
 * It divides the array into two parts: the sorted part and the unsorted part.
 * Initially, the sorted part is empty and the unsorted part is the entire
 * array.
 * The algorithm then selects the smallest element from the unsorted part and
 * swaps it with the leftmost element of the unsorted part.
 * This process continues until the entire array is sorted.
 **/

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