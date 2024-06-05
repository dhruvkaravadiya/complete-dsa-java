import java.util.Scanner;
import java.math.BigInteger;
public class P3TrailingZeros {
    public static void main(String[] args) {
        System.out.println("Enter Number : ");
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int n = 12;
        //int n2 = 30;
        String res = factorial(BigInteger.valueOf(n)).toString();
        System.out.println(res);
        int count = 0;
        for(int i = res.length()-1 ; i>=0 ; i--){
            if(res.charAt(i) != '0'){
               
                break;
            }
            else if(res.charAt(i) == '0'){
                count++;
            }
        }
        System.out.println(count);
    }

    public static BigInteger factorial(BigInteger n){
        if (n.compareTo(BigInteger.ZERO) <= 0) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
