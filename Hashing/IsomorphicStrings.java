package Hashing;

import java.util.HashMap;

public class IsomorphicStrings {
      public static void main(String[] args) {
            String str1 = "add";
            String str2 = "odd";

            System.out.println(evaluate(str1, str2));
      }

      public static boolean evaluate(String s, String t) {
            if (s.length() != t.length()) {
                  return false;
            } else {
                  HashMap<Character, Character> map1 = new HashMap<>();
                  HashMap<Character, Character> map2 = new HashMap<>();

                  for (int i = 0; i < s.length(); i++) {
                        char sChar = s.charAt(i);
                        char tChar = t.charAt(i);
                        if (map1.containsKey(sChar)) {
                              if (tChar != map1.get(sChar)) {
                                    return false;
                              }
                        } else {
                              map1.put(sChar, tChar);
                        }
                        if (map2.containsKey(tChar)) {
                              if (sChar != map2.get(tChar)) {
                                    return false;
                              }
                        } else {
                              map2.put(tChar, sChar);
                        }
                  }
                  return true;
            }

      }
}
