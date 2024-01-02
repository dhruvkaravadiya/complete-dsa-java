package Strings;

public class ValidPalindrome {
      public static boolean isPalindrome(String s) {
            s = s.replaceAll("\\s", "");
            s = s.toLowerCase();
            s = s.replaceAll("[^a-zA-Z0-9]", "");
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                  if (s.charAt(start) != s.charAt(end)) {
                        return false;
                  }
                  start++;
                  end--;
            }
            return true;
      }

      public static void main(String[] args) {
            System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
            System.out.println(isPalindrome("race a car"));
      }
}
