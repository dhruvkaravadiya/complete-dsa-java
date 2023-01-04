import java.util.Scanner;
public  class ArrayReplace{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);

		System.out.print("Enter size: ");
		int n = sc.nextInt();
		int array[] = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter array element: ");
			array[i]=sc.nextInt();
		}

		System.out.print(" number 1: ");
		int a=sc.nextInt();
		System.out.print("number 2: ");
		int b=sc.nextInt();

		boolean flag=true;
		for(int i=0;i<n;i++){
			if(array[i]==a){
				System.out.println("at index"+i);
				array[i]=b;
				flag=false;
			}
		}
		if(flag)
			System.out.print("number not found");

		if(!flag){
			System.out.println("New Array");
			for(int i=0;i<n;i++){
			System.out.println("Array element : "+array[i]);
			}
		}
		
	}
}