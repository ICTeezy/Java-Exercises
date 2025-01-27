public class BinaryFormatException extends RuntimeException {

    public BinaryFormatException(String binaryString) {
        super("String " + binaryString + " is not a valid binary string!");
    }

}
