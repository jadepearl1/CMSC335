/* Cylinder.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/15/2023
 * Purpose: The Cylinder class is a child class of ThreeDimensionalShape that creates a 3D Cylinder object.
 * The class has two private member variables radius and height, a constructor with two arguments, and
 * two methods getRadius and getHeight.
 * 
 * Modification: added draw method and necessary Swing imports to draw a Cylinder in GUI*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;
    public Cylinder(double radius, double height) {
        super(3, Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
    }
    public double getRadius() {
        return radius;
    }
    public double getHeight() {
        return height;
    }
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw cylinder body
        int bodyTopLeftX = x - (int) radius;
        int bodyTopLeftY = y - (int) height;
        int bodyWidth = (int) (2 * radius);
        int bodyHeight = (int) height;

        Rectangle2D body = new Rectangle2D.Double(bodyTopLeftX, bodyTopLeftY, bodyWidth, bodyHeight);
        g2d.fill(body);
        g2d.setColor(Color.BLACK);
        g2d.draw(body);

        // Draw top circular base
        int topBaseCenterX = x;
        int topBaseCenterY = bodyTopLeftY;

        Ellipse2D topBase = new Ellipse2D.Double(
                topBaseCenterX - radius, topBaseCenterY - radius, 2 * radius, 2 * radius);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(topBase);
        g2d.setColor(Color.BLACK);
        g2d.draw(topBase);

        // Draw bottom circular base
        int bottomBaseCenterX = x;
        int bottomBaseCenterY = y;

        Ellipse2D bottomBase = new Ellipse2D.Double(
                bottomBaseCenterX - radius, bottomBaseCenterY - radius, 2 * radius, 2 * radius);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(bottomBase);
        g2d.setColor(Color.BLACK);
        g2d.draw(bottomBase);
    }
}
