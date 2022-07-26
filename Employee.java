import java.util.Scanner;
class Employee_demo{
	int employee_id;
	String name;
	String designation;
	double salary;

	public void readDetais(){
		Scanner sc=new Scanner(System.in);
		System.out.print(" empId ");
		empId=sc.nextInt();
		System.out.print(" empName ");
		sc.nextLine();
		empName = sc.nextLine();
		System.out.print(" empDesignation ");
		empDesignation=sc.nextLine();
		System.out.print("empSalary ");
		empSalary=sc.nextDouble();
	}

	public void printDetais(){
		System.out.println("empId: "+empId);
		System.out.println("empName: "+name);
		System.out.println("empDesignation "+empDesignation);
		System.out.println("empSalary "+empSalary);
	}
}
public class Employee{
	public static void main(String[] args) {
		Employee_Detail empObj = new Employee_Detail();
		empObj.readDetais();
		empObj.printDetais();
	}
}