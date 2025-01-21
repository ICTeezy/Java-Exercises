import java.util.Scanner;

public class Exercise_8_29 {

    public static boolean equals(int[][] m1, int[][] m2) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] promptMatrix(Scanner reader) {
        System.out.print("Enter 9 integers ex. (1 2 3 4 ... 9): ");
        String[] matrixIntegers = reader.nextLine().split(" ");

        if (matrixIntegers.length != 9) {
            System.out.println("Please make sure you provide 9 integers!");
            return null;
        }

        int[][] matrix = new int[3][3];

        int inputIndex = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                try {
                    int parsedInteger = Integer.parseInt(matrixIntegers[inputIndex]);
                    matrix[i][j] = parsedInteger;
                } catch (NumberFormatException e) {
                    System.out.println("Make your input is a space separated list of integers (1 2 3 4)!");
                    return null;
                }

                inputIndex++;
            }
        }

        return matrix;
    }

    public static void main( String[] args ) {

        Scanner reader = new Scanner(System.in);

        int[][] matrixA = promptMatrix(reader);

        if (matrixA == null) {
            return;
        }

        int[][] matrixB = promptMatrix(reader);

        if (matrixB == null) {
            return;
        }

        System.out.println(equals( matrixA, matrixB ) ? "Equal!" : "Not equal :(");
    }

}
