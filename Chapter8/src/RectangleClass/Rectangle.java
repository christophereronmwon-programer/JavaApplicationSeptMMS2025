
package RectangleClass;

public class Rectangle {

    private double length = 1.0;
    private double width = 1.0;

    // Default constructor
    public Rectangle() {
    }

    // Constructor with parameters
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // Setters
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0)
            this.length = length;
        else
            System.out.println("Length must be between 0 and 20.");
    }

    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0)
            this.width = width;
        else
            System.out.println("Width must be between 0 and 20.");
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Calculate area
    public double area() {
        return length * width;
    }

    // Calculate perimeter
    public double perimeter() {
        return 2 * (length + width);
    }
}
