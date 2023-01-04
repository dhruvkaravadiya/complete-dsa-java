package Others;
import java.util.*;
public class Factorial{
	public static void main(String[] args){
		int fact=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++)
        {
        	fact=fact*i;
        }
	System.out.println("The factorial of  is "+fact);
	}
}