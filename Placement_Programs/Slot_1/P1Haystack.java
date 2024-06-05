
public class P1Haystack{
    public static void main(String[] args) {
        // String haystack = args[0];
        // String needle = args[1];
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(checkOccurance(haystack , needle));
    }

    public static int checkOccurance(String s , String t){
        int m = s.length();
        int n = t.length();
        int j = 0;
        int i = 0;
        int k = 0;
        while(i < m && j < n){
                if(s.charAt(i) == t.charAt(j)){
                    j++;
                    i++;
                }
                else{
                    j=0;
                    i = k + 1;
                    k = i;
                }
            }  
        if(j == n)  return k;
        else  return -1;
    }
}