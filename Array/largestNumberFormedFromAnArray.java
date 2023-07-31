import java.util.Arrays;
import java.util.Comparator;
class LargeNumberComparision implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);
    }
    
}
public class largestNumberFormedFromAnArray {
    public static void main(String[] args) {
        int arr[] = {20,1};
        int n = arr.length;
        String[] arrStr = new String[arr.length];
        for(int i = 0 ; i < n ; i++){
            arrStr[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(arrStr,new LargeNumberComparision());
        if(arrStr[0].equals("0")){
            System.out.println("0");
        }
        String result="";
        for(String str : arrStr){
            result+=str;
        }
        System.out.println(result);
    }
}
