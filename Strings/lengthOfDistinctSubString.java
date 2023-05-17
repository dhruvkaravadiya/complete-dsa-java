package Strings;

import java.util.HashSet;
public class lengthOfDistinctSubString{
    public static void main(String[] args) {
        String str = "abacdfghjabcd";
        int maxLen=0;
        int currLen=0;
        int start=0;
        int end=0;
        HashSet<Character> set = new HashSet<Character>(); 
        while(end < str.length()){
            if(set.contains(str.charAt(end))){
                set.remove(str.charAt(start));
                start++;
            }
            else{
                set.add(str.charAt(end));
                end++;
                currLen = end-start;
                maxLen=Math.max(currLen,maxLen);
            }
        }
        System.out.println(maxLen);
    }
}