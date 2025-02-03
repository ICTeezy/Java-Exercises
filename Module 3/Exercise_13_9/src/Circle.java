public class Circle extends GeometricObject implements Comparable<Circle> {

    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public int compareTo( Circle o ) {
       if (this.radius == o.radius)  {
           return 0;
       } else if (this.radius < o.radius) {
           return -1 * (int) this.radius;
       } else {
           return (int) this.radius;
       }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }

        return this.radius == ((Circle)o).radius;
    }

    public void printCircle() {
        System.out.println("The circle created " + getDateCreated() + " and the radius is " + radius);
    }
}
