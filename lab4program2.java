import java.util.*;
public class lab4program2{
    public static void checkString(String str) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int i = 0;
        char ch = str.charAt(i);
        try {
            while (ch != 'b') {
                stack1.push(ch);
                i++;
                ch = str.charAt(i);
            }
        } catch (Exception e) {
        }
        while (i < str.length()) {
            stack2.push(ch);
            i++;
            if (i < str.length())
                ch = str.charAt(i);
        }
        if (stack1.empty() || stack2.empty()) {
            System.out.println("Given String is not valid");
        } else if (stack1.size() != stack2.size()) {
            System.out.println("Given String is not valid");
        } else {
            boolean flag = false;
            for (int j = 0; j < stack1.size(); j++) {
                if (stack1.get(j) == 'a' && stack2.get(j) == 'b') {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("Given String is valid");
            else
                System.out.println("Given String is not valid");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        checkString(str);
        sc.close();
    }
}