/* TwoDimensionalShape.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/25/2023
 * Purpose: The TwoDimensionalShape class is a child class of Shape that creates a 2D shape object.
 * The class has a private member variable area, a constructor with two arguments, and a getArea method
 * in order to return the area to a method from which it is called. */

public class TwoDimensionalShape extends Shape {
    private double area;
    public TwoDimensionalShape(int numDimensions, double area) {
        //the number of dimensions is 2 in this class
        super(numDimensions);
        this.area = area;
    }
    public double getArea() { return area; }
}
