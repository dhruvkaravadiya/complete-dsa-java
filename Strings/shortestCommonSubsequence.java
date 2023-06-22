package Strings;
import java.util.Arrays;
import java.util.Comparator;

public class shortestCommonSubsequence {
    public static void main(String[] args) {
        String str1="ABABAB";
        String str2="ABAB";
        // Arrays.sort(arr,Comparator.comparing(s->s.length()));
        // StringBuilder answer = new StringBuilder();
        // for(int i = 0 ; i < arr[0].length() ; i++){
        //     char ch = arr[0].charAt(i);
        //     if(arr[1].charAt(i) == ch && answer.indexOf(String.valueOf(ch))==-1){
        //         answer.append(ch);
        //     }
        //     else{
        //         break;
        //     }
        // }
        // System.out.println(arr[0]);
        // System.out.println(arr[1]);  
        if(str1.concat(str2).equals(str2.concat(str1))){
            System.out.println(subtractStrings(str1, str2));
        }
        else{
            System.out.println("''");
        }
    }
    public static String subtractStrings(String s1 , String s2){
        String res = s2.replace(s1, "");
        System.out.println(res);
        if(res.length() == 0){
            return s1;
        }
        else {
            return res;
        }
    }
}
