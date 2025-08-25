//Implement sort with Time Complexity : O(n) if best case
//Algo : Compare two elements , if the first is greater,then
// swap it  with second , thus at the end of one for loop iteration 
//greatest will be at the end  , and the remaining array remains intaact

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
