//ALGORITHM : 
// Compare key with each element on the left of it until an element smaller than
// it is found.
// For descending order, change key<array[j] to key>array[j].
// Place key at after the element just smaller than it
package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int size = arr.length;
        System.out.print("Before : ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = key;
        }

        System.out.print("\nAfter Insertion Sort : ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
