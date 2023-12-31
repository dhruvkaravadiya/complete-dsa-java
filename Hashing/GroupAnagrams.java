package Hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
      public static HashMap<String , ArrayList<String>> anagrams(String []input){
            HashMap<String, ArrayList<String>> map = new HashMap<String , ArrayList<String>>();

            for(int i = 0 ; i  < input.length ; i++){
                  String str = input[i];
                  char[] chrs = str.toCharArray();
                  Arrays.sort(chrs);
                  String mapKey = String.valueOf(chrs);
                  ArrayList<String> list = map.getOrDefault(mapKey, new ArrayList<>());
                  list.add(str);
                  map.put(mapKey , list);
            }
            return map;
      }
      public static void main(String[] args) {
            String[] strs = {"eat","tea","tan","ate","nat","bat"};
            HashMap<String, ArrayList<String>> map = anagrams(strs);
            for(String key: map.keySet()){
                  ArrayList<String> list = map.get(key);
                  System.out.println(Arrays.toString(list.toArray()));
            }
      }
}