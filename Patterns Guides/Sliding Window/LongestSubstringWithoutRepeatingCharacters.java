import java.util.HashSet;
// public class LongestSubstringWithoutRepeatingCharacters {

//     public static int lengthOfLongestSubstring(String s) {

//         // here the window size is not mentioned, so the window size will be dynamic
//         // expand the window size when Unknown character is occurs
//         // shrink the window size from left until known character if removed when Known character occurs
//         int n = s.length();
//         HashSet<Character> set = new HashSet<>();
//         int maxLength = 0;
//         int left = 0;

//         for(int right = 0 ; right < n ; right++){
//             char curr = s.charAt(right);
//             //if known character came , shrink from left until known character from hashset
//             while(set.contains(s.charAt(right))){
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//             //add the current character to the hashset and 
//             // get the size of hashmap and update the max length if needed
//             set.add(curr);
//             // current window size can be get by (right - left + 1)
//             maxLength = Math.max(maxLength , right - left + 1);
//         }

//         return maxLength;
//     }

//     public static void main(String[] args) {

//         String[] inputs = {
//             "abcabcbb",
//             "bbbbb",
//             "pwwkew",
//             "",
//             " ",
//             "dvdf",
//             "abcdef",
//             "abba"
//         };

//         int[] expected = {
//             3,
//             1,
//             3,
//             0,
//             1,
//             3,
//             6,
//             2
//         };

//         for (int i = 0; i < inputs.length; i++) {

//             int result = lengthOfLongestSubstring(inputs[i]);

//             System.out.println(
//                 "Test " + (i + 1) +
//                 " | Input: \"" + inputs[i] + "\"" +
//                 " | Expected: " + expected[i] +
//                 " | Got: " + result +
//                 " | " + (result == expected[i] ? "PASS" : "FAIL")
//             );
//         }
//     }
// }

// to improve the same implementation of the sliding window
// we can use a frequency array instead of the hashset
// to improve the time complexity of the problem slightly
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        // here the window size is not mentioned, so the window size will be dynamic
        // expand the window size when Unknown character is occurs
        // shrink the window size from left until known character if removed when Known character occurs
        int n = s.length();
        // using frequency array instead of hashhset
        int[] freq = new int[128];
        int maxLength = 0;
        int left = 0;

        for(int right = 0 ; right < n ; right++){
            char curr = s.charAt(right);
            // in freq array implementation increase the freq of current character first
            freq[curr]++;
            // If current character frequency > 1, move left pointer
            // until the duplicate character's frequency becomes 1.
            while(freq[curr] > 1){
                freq[s.charAt(left)]--;
                left++;
            }
            // current window size can be get by (right - left + 1)
            maxLength = Math.max(maxLength , right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String[] inputs = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "",
            " ",
            "dvdf",
            "abcdef",
            "abba"
        };

        int[] expected = {
            3,
            1,
            3,
            0,
            1,
            3,
            6,
            2
        };

        for (int i = 0; i < inputs.length; i++) {

            int result = lengthOfLongestSubstring(inputs[i]);

            System.out.println(
                "Test " + (i + 1) +
                " | Input: \"" + inputs[i] + "\"" +
                " | Expected: " + expected[i] +
                " | Got: " + result +
                " | " + (result == expected[i] ? "PASS" : "FAIL")
            );
        }
    }
}