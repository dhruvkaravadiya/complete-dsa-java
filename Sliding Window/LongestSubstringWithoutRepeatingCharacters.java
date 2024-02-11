// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
      public static void main(String[] args) {
            int low = 0;
            int maxLen = 0;
            String str = "abcabcdabb";
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int high = 0; high < str.length(); high++) {
                  char ch = str.charAt(high);
                  if (map.containsKey(ch)) {
                        low = Math.max(low, map.get(ch) + 1);
                  }
                  map.put(ch, high);
                  maxLen = Math.max(maxLen, high - low + 1);
            }
            System.out.println(maxLen);
      }
}
