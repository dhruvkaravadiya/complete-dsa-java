import java.util.HashMap;
import java.util.Map;

class isAnagraOrNot {
      public static void populateHashMap(
                  Map<Character, Integer> hashMap, char[] characters) {
            for (char ch : characters) {
                  hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
            }
      }

      public static boolean areCountsEqual(
                  Map<Character, Integer> hashMap1, Map<Character, Integer> hashMap2) {
            for (char ch : hashMap1.keySet()) {
                  if (!hashMap2.containsKey(ch) || !hashMap1.get(ch).equals(hashMap2.get(ch))) {
                        return false;
                  }
            }
            return true;
      }

      public static boolean isAnagram(String s, String t) {
            if (t.length() != s.length()) {
                  return false;
            }
            char[] ch1 = s.toCharArray();
            char[] ch2 = t.toCharArray();
            Map<Character, Integer> hashMap1 = new HashMap<>();
            Map<Character, Integer> hashMap2 = new HashMap<>();

            // Populate HashMaps with sample data
            populateHashMap(hashMap1, ch1);
            populateHashMap(hashMap2, ch2);

            // Check if counts are equal for every character
            return areCountsEqual(hashMap1, hashMap2);
      }

      public static void main(String[] args) {
            System.out.println(
                        "ANAGRAM & RANAGMA : " +
                              isAnagram("ANAGRAM", "RANAGMA"));
            System.out.println(
                        "successful & fsucecslus : " +
                              isAnagram("successful", "fsucecslus"));
            System.out.println(
                        "treat & treot : " +
                              isAnagram("treat", "treot"));
      }
}
