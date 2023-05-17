import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
    public static void main(String[] args) {
        int rowIndex = 3;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        ArrayList<Integer> previous = new ArrayList<Integer>();

        previous.add(1);
        output.add(previous);
        int foundIndex = 0;
        if(rowIndex == 0){
            System.out.println(output.get(0));
        }
        for(int i = 2  ; i <= rowIndex+1 ; i++){
            
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);

            for(int j = 0  ; j < previous.size()-1 ; j++){
                curr.add(previous.get(j) + previous.get(j+1));
            }
            curr.add(1);
            output.add(curr);
            previous = curr;
            foundIndex = i;
        }
        System.out.println(output.get(rowIndex));
        System.out.println(foundIndex);
    }
}