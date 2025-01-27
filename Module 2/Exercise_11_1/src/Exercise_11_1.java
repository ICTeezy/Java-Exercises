import java.util.Scanner;

public class Exercise_11_1
{

    public static void main( String[] args )  {

        Scanner reader = new Scanner(System.in);

        System.out.println("Triangle Information: ");
        System.out.println("Side 1: ");
        double side1 = Math.abs(reader.nextDouble());

        System.out.println("Side 2: ");
        double side2 = Math.abs(reader.nextDouble());

        System.out.println("Side 3: ");
        double side3 = Math.abs(reader.nextDouble());

        System.out.println("Color: ");
        String color = reader.next();

        System.out.println("Filled (Y or N): ");
        String filledCharacter = reader.next();
        boolean filled = filledCharacter.equalsIgnoreCase("y");

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setFilled(filled);
        triangle.setColor(color);

        System.out.println(triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + (triangle.isFilled() ? "Yes" : "No"));
    }

}