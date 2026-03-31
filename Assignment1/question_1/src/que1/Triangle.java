package que1;

public class Triangle extends Shape {

    private int base;
    private int height;

    // Parameterized constructor
    public Triangle(String color, int base, int height) {
        super(color);   // calls Shape constructor
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle [Base=" + base +
               ", Height=" + height +
               ", Area=" + getArea() +
               ", " + super.toString() + "]";
    }
}
