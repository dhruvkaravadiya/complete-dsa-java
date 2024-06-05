import java.util.Scanner;
public class P4_NthDigitInfiniteSequence {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the Natural Number : ");
        //int x = sc.nextInt();
        //System.out.println(helper(x));
        System.out.println(helper(3));
        System.out.println(helper(12));
        System.out.println(helper(10));
        System.out.println(helper(50));
    }
    public static int helper(int x){
        String str = "";
        for(int i = 1 ; str.length() < x ; i++){
            str+=String.valueOf(i);

        }
        return str.charAt(str.length()-1);
    }
}
