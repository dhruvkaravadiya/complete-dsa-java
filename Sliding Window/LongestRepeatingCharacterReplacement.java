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

// This is the BIGGEST HINT or another way
//  frame thie question in another words
// Maximize the number of characters of highest frequency 
// which can be replaced under given limit for in all intervals possible 

public class LongestRepeatingCharacterReplacement {
      public static void main(String[] args) {
            String s = "ABAABBA";
            int limit = 1;

            // initialize variables
            int mostFreqChar = 0;
            int max_length = 0;
            int chars_count[] = new int[26];
            int left = 0;
            // iterate over string left to right
            for (int right = 0; right < s.length(); right++) {
                  // first count the character frequency
                  // of current character in the current window
                  chars_count[s.charAt(right) - 'A']++;
                  System.out.println("Count of A: " + chars_count[s.charAt(right) - 'A']);
                  // now update the most frequent character
                  mostFreqChar = Math.max(mostFreqChar, chars_count[s.charAt(right) - 'A']);
                  // first find the number to be replaced
                  // it can be found by taking the interval
                  // length (r-l+1) minus mostFreqCharacter's frequency
                  // Reason : interval will have most freq charcater
                  // and the other characters with less count
                  // we obviously want to replace the char with less count ,
                  // so lengthOfWindow - mostFrequent will yield
                  // the count of numbers which 'CAN' be replaced
                  // short : LESS COUNT CHARACTER = NUMBER TO BE REPLACED

                  int numberOfLettersToChange = (right - left + 1) - mostFreqChar;
                  // now check if the count of less frequent charcater is
                  // greater than the value k
                  // if is greater than k, then we move the left pointer to r by 1
                  // left ++
                  // Example : s = ABABAB , left=0 , r=3 , limitToReplace = 1 (ASSUME)
                  // then interval ABAB , we have to move the left by one, i.e. BAB,
                  // so now least freq will be A
                  // and it is valid string ,so we can replace A and update the max
                  // AND
                  // we decrease the count of the current character by 1
                  // as the freq array holds the freq of character in current interval
                  if (numberOfLettersToChange > limit) {
                        chars_count[s.charAt(right) - 'A']--;
                        left++;
                  }
                  // if lessCountCharacter is <= k , then we move one and
                  // at the end , we just update the max length of the interval
                  // or substring,
                  // if the current substring formed after replacing (NOT LITERRALLY)
                  // the update the new max length
                  max_length = Math.max(max_length, right - left + 1);

            }
            System.out.println("Final Max Length :  " + max_length);
      }
}
