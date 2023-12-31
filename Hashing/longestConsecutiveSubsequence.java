package Hashing;

import java.util.HashSet;

// ALGORITHM FOR O(N) solution

// 1. fisrt sort the array
// 2 create 2 variables , one for final answer and other too == 1
// not for each element check if the number arr[i] != arr[i - 1]
// if(arr[i] - arr[i+1] == 1)
// count ++;
// else if(arr[i] - arr[i+1] == 0)
// continue
// else { (diff > 2) }
// count = 1
// Math.max(max_count, count)

// O(N) without Hashing
/* 
import java.util.*;
public class longestConsecutiveSubsequence {
      public static void main(String[] args) {
            int arr[] = { 2, 3, 5, 1, 4, 7, 6, 9, 8, 0 };
            int N = arr.length;
            if (N == 1) {
                  System.out.println("Longest Consecutive subsequence: 1");
                  return;
            }
            Arrays.sort(arr);
            int count = 1;
            int max_count = 1;
            for (int i = 0; i < N - 1; i++) {
                  
                  if(arr[i+1] - arr[i] == 1)
                        count++;
                  else if(arr[i+1] - arr[i] == 0)
                              continue;
                  else {
                        count = 1;
                  }
                  max_count = Math.max(max_count, count);
                  System.out.println(max_count);
            }
      }
}
*/

// using hashing
public class longestConsecutiveSubsequence {
      public static void main(String[] args) {
            int arr[] = { 2, 3, 5, 1, 4, 7, 6, 9, 8, 0 };
            int N = arr.length;

            HashSet<Integer> set = new HashSet<Integer>();
            int result = 0;

            // Hash all the array elements
            for (int i = 0; i < N; ++i)
                  set.add(arr[i]);

            for(int i = 0 ; i  < N ; i++){
                  if(!set.contains(arr[i]-1)){
                        int temp = arr[i];
                        while(set.contains(temp)){
                              set.remove(Integer.valueOf(temp));
                              temp++;
                        }
                        if(result < (temp - arr[i])){
                              result = temp - arr[i];
                        }
                  }
            }
            System.out.println(result);
      }
}

/*
create an empty hashset and add all elements of array to it
initialize the result to store the length of longestCommonSubsequence
now for i - > N (length of array) 
      check if set already contains the previous consecutive iteration element arr[i-1]
      if it contains then incremenet a variable temp until the set contains the consecutive iteration element temp ++
      and replace the ans value if the difference between temp and curren element is more than result length
*/