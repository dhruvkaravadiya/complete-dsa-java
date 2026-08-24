import java.util.*;
public class permutationInString{
    public static boolean isPermutation(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }
        int[] freq = new int[128];
        for(int i = 0 ; i < s1.length() ; i++){
            freq[s1.charAt(i)]++;
        } 
        int left = 0;
        
        for(int right = (s1.length() - 1) ; right < s2.length() ; right++){
            String currentString = s2.substring(left, right+1);

            int[] currentFreq = new int[128];

            for (int i = 0; i < currentString.length(); i++) {
                currentFreq[currentString.charAt(i)]++;
            }
            if (Arrays.equals(freq, currentFreq)) {
                return true;
            }
            left++;
        }
        return false;
    }

    public static void main(String[] args) {

        // Test Case 1
        System.out.println(isPermutation("abc", "bca"));     // true

        // Test Case 2
        System.out.println(isPermutation("listen", "silent")); // true

        // Test Case 3
        System.out.println(isPermutation("abc", "xyz"));     // false

        // Test Case 4
        System.out.println(isPermutation("aabb", "bbaa"));   // true

        // Test Case 5
        System.out.println(isPermutation("aabb", "abbb"));   // false

        // Test Case 6
        System.out.println(isPermutation("abc", "abcd"));    // false

        // Test Case 7
        System.out.println(isPermutation("a", "a"));         // true

        // Test Case 8
        System.out.println(isPermutation("a", "b"));         // false

        // Test Case 9
        System.out.println(isPermutation("hello", "olleh")); // true

        // Test Case 10
        System.out.println(isPermutation("hello", "hell"));  // false
    }
}
