package Strings;
public class wordLadder {
    public static void main(String[] args) {
        //String beg="hit";
        String end="cog";
        String []words = {"hot","dot","dog","lot","log","cog"};
        // List<String> list = Arrays.asList(words);
        // if(!list.contains(beg) || !list.contains(end)){
        //     System.out.println(0);
        // }
        int count=0;
        int i=0;
        String currString="";
        while(!currString.equals(end)){
            currString=words[i];
            if(checkStrings(words[i],words[i+1])){
                count++;
            } 
        }
        System.out.println(count);
    }
    public static boolean checkStrings(String w1, String w2){  
        int flag=0;   
        for(int i = 0 ; i < w1.length() ; i++){
            if(w2.charAt(i)!=w1.charAt(i)){
                flag++;
            }
        }
        if(flag ==1){
            return true;
        }
        else{
            return false;
        }
    }
}
