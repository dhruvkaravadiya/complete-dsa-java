// import java.util.HashMap;
// import java.util.Map.Entry;

// Brute force solution O(n^2)
// public class productOfArrayExceptSelf {
//       public static void main(String[] args) {
//             int arr[] = { 1, 2, 3, 4 };
//             HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//             for (int i = 0; i < arr.length; i++) { 
//                   int product = 1;
//                   for (int j = 0; j < arr.length; j++) {
//                         if (i != j) {
//                               product = product* arr[j];
//                         }
//                   }
//                   map.put(arr[i], product);
//             }
//             // Print the map for verification
//                   for (Entry<Integer, Integer> entry : map.entrySet()) {
//                         System.out.println(entry.getKey() + " : " + entry.getValue());
//                   }

//       }
// }

// OPTIMIZED SOLUTION USING RIGHT AND LEFT PRODUCTS MERGING O(N)

public class productOfArrayExceptSelf {
      public static void main(String[] args) {
            int arr[] = { 1, 2, 3, 4 };
            int N = arr.length;
            int result[] = new int[N];
            int leftProduct = 1;
            // calculate the product of each element's left members
            for (int i = 0; i < N; i++) {
                  result[i] = leftProduct;
                  leftProduct *= arr[i];
            }

            int rightProduct = 1;  
            // same for the right product
            for (int i = N - 1; i >= 0; i--) {
                  result[i] *= rightProduct;
                  rightProduct *= arr[i];
            }

            for(int i = 0 ; i < N ; i++){ 
                  System.out.println(result[i]);
            }
      }
}