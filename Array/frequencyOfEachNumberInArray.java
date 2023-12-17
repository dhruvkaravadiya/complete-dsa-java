import java.util.HashMap;
public class frequencyOfEachNumberInArray{
      public static void main(String[] args) {
            int arr[] = {1,1,1,2,2,4,4,4,4,4,3,5,5,5,5,5,5,5,5,5};
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < arr.length; i++){
                  map.put(arr[i] , map.getOrDefault(arr[i], 0) + 1);
            }
            System.out.println(map);
      }
}