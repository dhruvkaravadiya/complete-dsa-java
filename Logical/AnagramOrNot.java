package Logical;

import java.util.HashMap;

public class AnagramOrNot {
      public static void main(String[] args) {
            System.out.println(checkAnagram("Mother In Law", "Hitler Woman")); // true
            System.out.println(checkAnagram("SiLeNt CAT", "LisTen AcT")); // true
            System.out.println(checkAnagram("ASTRONOMERS", "NO MORE STARS")); // true
            System.out.println(checkAnagram("School1 MASTER", "The ClassROOM"));// false
      }

      public static boolean checkAnagram(String s1, String s2) {
            s1 = s1.replaceAll("\\s", "").toLowerCase();
            s2 = s2.replaceAll("\\s", "").toLowerCase();

            if (s1.length() != s2.length()) {
                  return false;
            }

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                  char ch = s1.charAt(i);
                  map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (int i = 0; i < s2.length(); i++) {
                  char ch = s2.charAt(i);
                  if (!map.containsKey(ch)) {
                        return false;
                  }
                  map.put(ch, map.get(ch) - 1);
                  if (map.get(ch) == 0) {
                        map.remove(ch);
                  }
            }
            return map.isEmpty();
      }
}
