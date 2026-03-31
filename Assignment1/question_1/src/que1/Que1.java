/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package que1;

/**
 *
 * @author root
 */
public class Que1 {

    public static void main(String[] args) {

        // Upcasting
        Shape s1 = new Rectangle("Blue", 10, 5);
        Shape s2 = new Triangle("Red", 8, 6);

        // Polymorphism
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("Area of Shape 1: " + s1.getArea());
        System.out.println("Area of Shape 2: " + s2.getArea());

        // Downcasting
        Rectangle r = (Rectangle) s1;
        Triangle t = (Triangle) s2;

        System.out.println("Downcasted Rectangle Area: " + r.getArea());
        System.out.println("Downcasted Triangle Area: " + t.getArea());
    }
}

