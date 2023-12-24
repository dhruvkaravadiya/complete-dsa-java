import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
/*


//  SOLUTION : 1 USING sort and find pair,
//  little optiized then the naive approach


public class TwoSum {

    public static int[] sort(int arr[]) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return arr;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 11, 7, 4, 1 };
        int x = 9;
        int temp[] = Arrays.copyOf(arr, arr.length);
        sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        for (int z = 0; z < arr.length; z++) {
            map.put(arr[z], z);
        }

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {

            int sum = temp[i] + temp[j];
            // System.out.println(i+" "+j);
            // System.out.println(sum);
            if (x == sum) {
                // System.out.println(i+" , "+j);
                break;
            } else if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        // System.out.println(i+" "+temp[i]);
        // System.out.println(j+" "+temp[j]);

        int ret[] = new int[2];
        ret[0] = map.get(temp[i]);
        ret[1] = map.get(temp[j]);
        // System.out.println(ret[0]+" "+ret[1]);
    }
}


 */

//      SOLUTION : 2 
//      USING HASH Map
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 6, 3, 8, 2, 0, 6 };
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(arr[0], 0);
        int ans[] = new int[2];
        int k = 6;
        for (int i = 1; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                ans[0] = map.get(k - arr[i]);
                ans[1] = i;
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println(ans[0] + " : " + ans[1]);
    }
}