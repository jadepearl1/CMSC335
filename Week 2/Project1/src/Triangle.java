/* Triangle.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/27/2023
 * Purpose: The Triangle class is a child class of TwoDimensionalShape that creates a 2D Triangle object.
 * The class has two private member variables baseLength and heignt, a constructor with two arguments, and two
 * methods getBase and getHeight. I found that type of triangle does not impact the area so type of triangle is
 * not exactly considered here.*/

public class Triangle extends TwoDimensionalShape {
    private double baseLength;
    private double height;
    public Triangle(double baseLength, double height) {
        //using super gets the area of the triangle. The area of a triangle is 1/2 * base * height regardless of
        //what kind of triangle is being analyzed
        super(2, 0.5 * baseLength * height);
        this.baseLength = baseLength;
        this.height = height;
    }
    public double getBase() {
        return baseLength;
    }
    public double getHeight() {
        return height;
    }
}
