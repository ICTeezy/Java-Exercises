public class Exercise_12_9 {

    public static int binaryToDecimal(String binaryString) throws BinaryFormatException {

        if (binaryString.isEmpty()) {
            throw new BinaryFormatException(binaryString);
        }

        int decimalConversion = 0;
        char[] charArray = binaryString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char charAt = charArray[i];

            if (charAt != '1' && charAt != '0') {
                throw new BinaryFormatException(binaryString);
            }

            if (charAt == '1') {
                decimalConversion += (int) Math.pow( 2, charArray.length - i - 1 );
            }
        }

        return decimalConversion;
    }

}
