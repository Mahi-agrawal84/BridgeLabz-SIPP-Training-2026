// Abstract Shape Hierarchy with Area Report

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}

// Circle class (radius is immutable)
class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Triangle class
class Triangle extends Shape {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double area() {
        double s = perimeter() / 2; // Semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

// Main Class
public class ShapeReport {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(10, 4),
            new Triangle(3, 4, 5)
        };

        System.out.println(" SHAPE AREA REPORT ");
        System.out.printf("%-12s %-15s %-15s%n",
                "Shape", "Area", "Perimeter");
        System.out.println("");

        for (Shape shape : shapes) {
            System.out.printf("%-12s %-15.2f %-15.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.area(),
                    shape.perimeter());
        }
    }
}