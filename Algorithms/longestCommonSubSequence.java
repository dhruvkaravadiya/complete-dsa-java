package Algorithms;
public class longestCommonSubSequence {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.next(); 
        System.out.print("Enter Second string : ");
        String s2 = sc.next();
        System.out.println(lcs(s1,s2));
        sc.close();
    }
    public static String lcs(String s1 ,String s2){
        int m = s1.length();
        int n = s2.length();
        int [][]arr = new int[m+1][n+1];
        String ans = "";
        int maxLen = 0;
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ;j++){
                if(i==0 || j==0){
                    arr[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    
                    arr[i][j] = arr[i-1][j-1] + 1;
                    
                    if(arr[i][j] > maxLen) {
                        maxLen = arr[i][j];
                        ans = s1.substring(i-maxLen, i);
                    }
                }
                else{
                    arr[i][j] = ((arr[i-1][j] > arr[i][j-1]) ? arr[i-1][j]:arr[i][j-1]) ;
                }
            }
        }
        return ans; 
    }
}
