/* Rectangle.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/27/2023
 * Purpose: The Rectangle class is a child class of TwoDimensionalShape that creates a 2D Rectangle object.
 * The class has two private member variables length and width, a constructor with two arguments, and two
 * methods getLength and getWidth.*/

public class Rectangle extends TwoDimensionalShape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        //using super takes the area of the rectangle
        super(2, length * width);
        this.length = length;
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
}