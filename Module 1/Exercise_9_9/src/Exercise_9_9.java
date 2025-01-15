

public class Exercise_9_9 {

    public static void main(String[] args) {

        RegularPolygon polygonOne = new RegularPolygon();

        System.out.println("Polygon One");
        System.out.println("Perimeter: " + polygonOne.getPerimeter());
        System.out.println("Area: " + polygonOne.getArea());
        System.out.println();

        RegularPolygon polygonTwo = new RegularPolygon(6,2);

        System.out.println("Polygon Two");
        System.out.println("Perimeter: " + polygonTwo.getPerimeter());
        System.out.println("Area: " + polygonTwo.getArea());
        System.out.println();

        RegularPolygon polygonThree = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon Three");
        System.out.println("Perimeter: " + polygonThree.getPerimeter());
        System.out.println("Area: " + polygonThree.getArea());

    }

}

class RegularPolygon {

    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;


    public RegularPolygon() {}

    public RegularPolygon(int sides, double sideLength) {
        this(sides, sideLength, 0.0, 0.0);
    }

    public RegularPolygon(int sides, double sideLength, double x, double y) {
        this.n = sides;
        this.side = sideLength;
        this.x = x;
        this.y = y;
    }

    public int getSides() {
        return n;
    }

    public double getSideLength() {
        return side;
    }

    public double getXCoordinate() {
        return x;
    }

    public double getYCoordinate() {
        return y;
    }

    public void setSides(int sides) {
        this.n = sides;
    }

    public void setSideLength(double sideLength) {
        this.side = sideLength;
    }

    public void setXCoordinate(double x) {
        this.x = x;
    }

    public void setYCoordinate(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return this.n * this.side;
    }

    public double getArea() {
        return (n * (side * side)) / (4 * Math.tan(Math.PI / n));
    }

}