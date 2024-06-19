package Logical;

public class PalindromeChecker {
      public static void main(String[] args) {
            String a = "1z2z3123lkkl3213z2z1";
            String b = "aa234b43aa";
            System.out.println(isPalindrome(a));
            System.out.println(isPalindrome(b));
      }

      public static boolean isPalindrome(String str) {
            if (str.length() == 1) {
                  return true;
            }
            if (str.length() == 2) {
                  return false;
            }
            int l = 0;
            int r = str.length() - 1;
            while (l < r) {
                  if (str.charAt(l) != str.charAt(r)) {
                        return false;
                  }
                  l++;
                  r--;
            }
            return true;
      }
}