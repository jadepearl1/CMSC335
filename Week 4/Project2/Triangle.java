/* Triangle.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/15/2023
 * Purpose: The Triangle class is a child class of TwoDimensionalShape that creates a 2D Triangle object.
 * The class has two private member variables baseLength and heignt, a constructor with two arguments, and two
 * methods getBase and getHeight. I found that type of triangle does not impact the area so type of triangle is
 * not exactly considered here.
 * 
 * Modification: added a draw method and import to Swing for drawing a Triangle in the GUI*/

import java.awt.Graphics;

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
    public void draw(Graphics g, int x, int y) {
        //This uses the drawPolygon for drawing which requires 3 points
        //Find the 3 points for drawing an isosceles triangle.
        int x1 = x - (int) (baseLength / 2);
        int y1 = y + (int) (height / 2);
        int x2 = x + (int) (baseLength / 2);
        int y2 = y + (int) (height / 2);
        int x3 = x;
        int y3 = y - (int) (height / 2);

        int[] xp = {x1, x2, x3};
        int[] yp = {y1, y2, y3};
        int vertices = 3;
        g.drawPolygon(xp, yp, vertices);
    }
}
