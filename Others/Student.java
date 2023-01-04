import java.util.Scanner;

public class Student{
    public static int c = 1;
    int enrollmentNo;
    String studName;
    int sem;
    double cpi;

    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for student " + c);
        System.out.println("Enter enrollment number ");
        enrollmentNo = sc.nextInt();
        System.out.println("Enter name ");
        sc.nextLine();
        studName = sc.nextLine();
        System.out.println("Enter semester ");
        sem = sc.nextInt();
        System.out.println("Enter cpi");
        cpi = sc.nextFloat();
        c++;
        System.out.println("\n\n");

    }

    public void displayDetails() {
        System.out.println("Name " + studName);
        System.out.println("enrollment_no " + enrollmentNo);
        System.out.println("semester " + sem);
        System.out.println("cpi " + cpi);
    }

    public static void main(String[] args) {
        Student[] student = new Student[5];
        for (int i = 0; i < 5; i++) {
            student[i] = new Student();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Details of student " + i + 1);
            student[i].displayDetails();

        }
    }
}