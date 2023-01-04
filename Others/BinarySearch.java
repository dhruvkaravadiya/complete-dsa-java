import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        int arr [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int start = 0; 
        int last = arr.length;
        int middle;
        Scanner sc = new Scanner(System.in);
        int searchElement = sc.nextInt();
        for(int i = start ; i < last ; i++){
            middle = (start + last)/2;
            if(searchElement > middle ){
                start = middle;
            }
            else if(searchElement < middle){
                last = middle;
            }
            else{
                if(middle == searchElement){
                    System.out.println("Number found"+i); 
                    break;                   
                }
                else{
                    System.out.println("Number NOT found"); 
                    break;
                }
            }
        }
    }
}
