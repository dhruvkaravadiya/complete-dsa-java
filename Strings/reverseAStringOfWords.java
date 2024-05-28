package Strings;

public class reverseAStringOfWords {
      public static void main(String[] args) {
            String temp = "this is an amazing program";
            String[] strs = temp.split(" ");
            for (int i = 0; i < strs.length / 2; i++) {
                  String temp2 = strs[i];
                  strs[i] = strs[strs.length - i - 1];
                  strs[strs.length - i - 1] = temp2;

            }
            System.out.println(strs[0]);
            System.out.println(strs[1]);
            System.out.println(strs[2]);
            System.out.println(strs[3]);
            System.out.println(strs[4]);

      }
}
