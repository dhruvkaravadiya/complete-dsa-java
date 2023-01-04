public class Prime {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();

        boolean flag = false;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Given number is composite");
        } else {
            System.out.println("Given number is prime");
        }
        sc.close();
    }
}