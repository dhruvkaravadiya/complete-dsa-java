public class decimalToBinary{
    public static String decimalToBinary(int decimal) {
    String binary = "";

    while (decimal != 0) {
        int remainder = decimal % 2;
        binary = remainder + binary;
        decimal = decimal / 2;
    }

    return binary;
}
}