
package RectangleClass;

public class RectangleTest {

    public static void main(String[] args) {

        Rectangle rect = new Rectangle();

        rect.setLength(12.5);
        rect.setWidth(7.5);

        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Area: " + rect.area());
        System.out.println("Perimeter: " + rect.perimeter());
    }
}
