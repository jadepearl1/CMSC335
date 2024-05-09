/* Rectangle.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/14/2023
 * Purpose: The Rectangle class is a child class of TwoDimensionalShape that creates a 2D Rectangle object.
 * The class has two private member variables length and width, a constructor with two arguments, and two
 * methods getLength and getWidth.
 * 
 * Modification: added draw method and Swing import to draw a Rectangle object in GUI*/

import java.awt.Graphics;

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
    public void draw(Graphics g, int x, int y) {
        int startX = x - (int) (width / 2);
        int startY = y - (int) (length / 2);

        g.drawRect(startX, startY, (int) width, (int) length);
    }
}