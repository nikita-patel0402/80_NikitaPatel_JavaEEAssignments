package que1;

public class Rectangle extends Shape {

    private int length;
    private int width;

    // Parameterized constructor
    public Rectangle(String color, int length, int width) {
        super(color);   // calls Shape constructor
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle [Length=" + length +
               ", Width=" + width +
               ", Area=" + getArea() +
               ", " + super.toString() + "]";
    }
}
