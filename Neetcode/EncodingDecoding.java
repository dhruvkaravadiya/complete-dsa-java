import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class EncodingDecoding{
    
    public static String delimiter = "\u00fe";
        public static String EMPTY_LIST_MARKER = "\u00fd";

    public static String encode(List<String> strs){
        if(strs == null){
            return "";
        }
        if(strs.isEmpty() == true){
            return EMPTY_LIST_MARKER;
        }

        String answer = "";
        for(int i = 0 ; i < strs.size() - 1 ; i++){
            answer += (strs.get(i) + delimiter);
        }
        return answer + strs.get(strs.size()-1);
    }

    public static List<String> decode(String str) {
         if (str.equals(EMPTY_LIST_MARKER)) {
            return new ArrayList<>();
        }
        // this is ok , but it will not consider edge cases where strings of length 0 are observed , as .split method will discord the empty strings
        //String[] segments = str.split(delimiter);
        // so we pass a second argument in the .split method '-1'  so that .split considers empty strings also
        String[] segments = str.split(delimiter , -1);
        List<String> decodedStrings = new ArrayList<>(Arrays.asList(segments));
        return decodedStrings;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard ASCII data with mixed punctuation, spaces, and brackets
        List<String> case1 = List.of("ID: 101", "Name: Jane Doe", "Status [Active]");
        String encoded1 = encode(case1);
        List<String> decoded1 = decode(encoded1);
        System.out.println("Test 1 (Standard): " + case1.equals(decoded1));

        // Test Case 2: Content matching common ASCII delimiters (commas, pipes, quotes)
        List<String> case2 = List.of("a,b,c", "key=\"value\"", "field1|field2");
        String encoded2 = encode(case2);
        List<String> decoded2 = decode(encoded2);
        System.out.println("Test 2 (ASCII Delimiters): " + case2.equals(decoded2));

        // Test Case 3: Edge cases with empty strings and single characters
        List<String> case3 = List.of("", "A", "", "B", "");
        String encoded3 = encode(case3);
        List<String> decoded3 = decode(encoded3);
        System.out.println("Test 3 (Empty Fields): " + case3.equals(decoded3));

    }

}