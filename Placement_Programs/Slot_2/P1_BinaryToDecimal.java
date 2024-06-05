import java.util.Scanner;

public class P1_BinaryToDecimal{
    public static void main(String[] args) {
        double num = 101.110;
        String[] strs =  Double.toString(num).split("\\."); 
        System.out.println(strs[0]);
        System.out.println(strs[1]);  
        double leftPart = productSum(strs[0], strs[0].length()-1, 0);
        double rightPart = productSum(strs[1], (strs[1].length() - 1) * (-1), strs[1].length() * (-1));
        //System.out.println(leftPart);
        //System.out.println(rightPart);
        double decimalNum = leftPart + rightPart;
        System.out.println(decimalNum);
    }
    public static int productSum(String str , int l , int r){
        int res = 0;
        int x = 0;
        for(int i = l ; i >= r ; i--){
            System.out.println(str.charAt(x));
            if(str.charAt(x) == '1'){
                res +=  Math.pow(2, l ); 
                x++; 
            }    
        }
        return res;
    }
}
