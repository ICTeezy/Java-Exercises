import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise6_31 {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");

        long cardNumber;

        try {
            cardNumber = read.nextLong();
        } catch (InputMismatchException ignored) {
            System.out.println("Make sure your input is a long integer!");
            return;
        }

        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid.");
        } else {
            System.out.println(cardNumber + " is invalid.");
        }
    }

    public static boolean isValid(long number) {

        int size = getSize(number);

        if (size < 13 || size > 16) { //Ensure card has valid number of digits
            return false;
        }

        if (!(prefixMatched(number, 4)
                        || prefixMatched(number, 5)
                        || prefixMatched(number, 37)
                        || prefixMatched(number, 6)))
        {
            return false;
        } // Check if the card number has a valid prefix

        int digitsSum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

        return digitsSum % 10 == 0;
    }

    public static boolean prefixMatched(long number, int prefix) {
        return getPrefix(number, getSize(prefix)) == prefix;
    }

    public static long getPrefix(long number, int prefixLength) {
        int numberSize = getSize(number);

        if (numberSize < prefixLength) {
            return number;
        }

        for (int i = 0; i < numberSize - prefixLength; i++) {
            number /= 10;
        }

        return number;
    }

    public static int getSize(long number) {
        int size = 0;

        while (number > 0) {
            number /= 10;
            size++;
        }

        return size;
    }

    public static int getDigit(int number) {

        if (number < 10) {
            return number;
        }

        return (number % 10) + (number / 10);
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;

        int size = getSize(number);
        for (int i = 0; i < size / 2; i++) {
            int digit = (int) (number % 10);
            sum += digit;
            number /= 100; //This eats two digits, so we can process the next odd.
        }

        return sum;
    }

    public static int sumOfDoubleEvenPlace(long number) {

        int sum = 0;

        int size = getSize(number);
        for (int i = 0; i < size / 2; i++) {
            number /= 10L; //Eat the odd position digit

            int digit = (int) (number % 10) * 2;
            sum += getDigit(digit);

            number /= 10L; //Eat the digit we just processed
        }

        return sum;
    }

}