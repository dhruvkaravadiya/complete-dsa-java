// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
public class LongestRepeatingCharacterReplacement {
      public static void main(String[] args) {
            String s = "ABAABBA";
            int limit = 1;

            // initialize variables
            int max_count = 0;
            int max_length = 0;
            int chars_count[] = new int[26];
            int left = 0;
            // iterate over string left to right
            for (int right = 0; right < s.length(); right++) {
                  // first count the character occurence of current character
                  chars_count[s.charAt(right) - 'A']++;
                  System.out.println("Count of A: " + chars_count[s.charAt(right) - 'A']);
                  // now update the max count to be max of it and the
                  // count of the current character occurance
                  System.out.println("Max Count Before: " + max_count);
                  max_count = Math.max(max_count, chars_count[s.charAt(right) - 'A']);
                  System.out.println("Max Count After: " + max_count);
                  // now check if the number of characters to
                  // be replaced exceeds the allowed limit k
                  // If so, move the start pointer to shrink the window.
                  // Update the count of the character at the start pointer
                  // in the char_count array.
                  if ((right - left + 1) - max_count > limit) {
                        chars_count[s.charAt(right) - 'A']--;
                        left++;
                  }
                  // At each step, calculate the length of the current substring (end - start + 1)
                  // and update max_length if the current substring is longer.
                  System.out.println("Max Length Before : " + max_length);
                  max_length = Math.max(max_length, right - left + 1);
                  System.out.println("Max Length After : " + max_length);
                  System.out.println();
            }
            System.out.println("Final Max Length :  " + max_length);
      }
}
