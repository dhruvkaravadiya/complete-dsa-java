package Greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
      public static void main(String[] args) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            String str = "abccccdd";
            for (int i = 0; i < str.length(); i++) {
                  map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
            int count = 0;
            boolean oddFound = false;

            for (int freq : map.values()) {
                  count += (freq / 2) * 2;
                  if (freq % 2 == 1) {
                        oddFound = true;
                  }
            }
            if (oddFound) {
                  count = count + 1;
            }
            System.out.println(count);
      }
}
