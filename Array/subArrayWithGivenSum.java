import java.util.HashMap;

//Count numberof sub arrays having sum equal k int the array
//Naive Approach time - O(n.n) , space - O(1)
// public class subArrayWithGivenSum{
//     public static void main(String[] args) {
//         int arr[] = {1,2,3,4,5,6,7,8,9,10};
//         int n = arr.length;
//         int k = 55;
//         int count = 0;
//         for(int i = 0 ; i < n ; i++){
//             int sum = 0;
//             for(int j = i ; j < n ; j++){
//                 sum+=arr[j];
//                 if(sum == k){
//                     count++;
//                 }
//             }
//         }
//         System.out.println(count);
//     }
// }

//Optimized Approach  time - O(n) , space - O(n)
public class subArrayWithGivenSum{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int sum = 9;
        int n = arr.length;
        int currSum=0;
        int res=0;
        HashMap<Integer, Integer> prevSum = new HashMap<>();        
        prevSum.put(0,1);
        for(int i = 0 ; i < n ;i++){
            currSum += arr[i];
            int removeSum=currSum-sum;
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }
        System.out.println(res);
    }
}