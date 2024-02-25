package Strings;

public class addBinary {
      public static void main(String[] args) {
            String a = "11";
            String b = "1";
            System.out.println(calculateBinarySum(a, b));
      }

      public static String calculateBinarySum(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry == 1) {
                  int sum = carry;
                  if (i >= 0) {
                        sum += a.charAt(i--) - '0';
                  }
                  if (j >= 0) {
                        sum += b.charAt(j--) - '0';
                  }
                  // now we apped the remainder of modulo of sum of decimal 'sum' to stringbuilder
                  // object
                  sb.append(sum % 2);
                  // now we reassign carry to sum/2
                  carry = sum / 2;
            }
            // reverse the string builder and convert to string
            return sb.reverse().toString();
      }
}
