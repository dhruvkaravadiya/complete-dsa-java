import javaa.util.Scanner;
public class Matrix_Addition{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter rows: ");
		int m=sc.nextInt();
		System.out.print("Enter columns: ");
		int n=sc.nextInt();
		int a[][]=new int[m][n];
		int b[][]=new int[m][n];
		int c[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(i+" row and "+j+"column: ");
				array1[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(i+" row and "+j+" column: ");
				array2[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				additionArray[i][j]=array1[i][j]+array2[i][j];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("\t"+additionArray[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}	
}
    }}