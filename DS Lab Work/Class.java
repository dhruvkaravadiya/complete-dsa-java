/*Create class Employee_Detail with attributes Employee_id, Name, Designation, and Salary. Write a 
program to read the detail from user and print it. */
import java.util.*;
class Student{
	int Enrollment_no;
	String Student_Name;
	int Semester;

	void GetStudentDetails()
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter a Enrollment_no: ");
		Enrollment_no = S.nextInt();
		System.out.println("Enter a Student_Name: ");
		Student_Name = S.next();
		System.out.println("Enter a Semester: ");
		Semester = S.nextInt();
	}
}

class Result{
	int Enrollment_no;
	Double CPI;
	Double SPI;

		void GetResult()
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Enter a Enrollment_no: ");
			Enrollment_no = s.nextInt();
			System.out.println("Enter a CPI: ");
			CPI = s.nextDouble();
			System.out.println("Enter a SPI: ");
			SPI = s.nextDouble();
		}

		void DisplayResult(Student s){
			System.out.println("CPI of Student is :"+CPI);
			System.out.println("SPI of Student is :"+SPI);
		}
}

public class Class{
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.GetStudentDetails();
		Result r1 = new Result();
		r1.GetResult();
		r1.DisplayResult(s1);
	}
}