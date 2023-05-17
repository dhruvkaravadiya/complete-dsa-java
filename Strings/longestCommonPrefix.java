package Strings;

import java.util.Arrays;

public class longestCommonPrefix{
    public static void main(String[] args) {
        String[] arr = {"hello","helsing","help"};
        int size = arr.length;
        Arrays.sort(arr);
        int length = arr[0].length();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++){
            if(arr[0].charAt(i) == arr[size-1].charAt(i)){
                result.append(arr[0].charAt(i));
            }
        }
        System.out.println(result);
    }
}