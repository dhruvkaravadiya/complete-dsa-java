public class binaryToDecimal{
     public static int binaryToDecimal(String binStr){
        int decimal = 0;
        int n = binStr.length();
        for(int i = 0 ; i < n ; i++){
            int temp = Integer.parseInt(String.valueOf(binStr.charAt(n-i-1)));
            if(temp == 1){
                decimal += Math.pow(2 , i);
            }
        }
        return decimal;
    }
}
   