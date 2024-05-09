/* Circle.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1 code and last modified on 11/13/2023
 * Purpose: The Circle class is a child class of TwoDimensionalShape that creates a 2D Circle object.
 * The class has a private member variable radius, a constructor with one argument, and a getRadius method
 * in order to return the radius.
 * 
 * Modification: added a draw method to draw a Circle object in a GUI */
import java.awt.*;
public class Circle extends TwoDimensionalShape {
    private double radius;
    public Circle(double radius) {
        //calling the parents constructor using super gets the area of the circle.
        super(2, Math.PI * radius * radius);
        this.radius = radius;
    }
    public double getRadius() { return radius; }
    public void draw(Graphics g, int x, int y) {
        g.drawOval(x, y, (int) radius, (int) radius); };
}
