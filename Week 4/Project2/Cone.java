/* Cone.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from Project 1 and last modified on 11/14/2023
 * Purpose: The Cone class is a child class of ThreeDimensionalShape that creates a 3D Cone object.
 * The class has two private member variables radius and height, a constructor with two arguments, and
 * two methods getRadius and getHeight.
 * 
 * Modification: includes a draw method for drawing the Cone object in a GUI */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Polygon;


public class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;
    public Cone(double radius, double height) {
        //uding super takes the volume of the Cone
        super(3, (1.0 / 3.0) * Math.PI * radius * radius * height);
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
        int baseX = x - (int) (radius / 2);
        int baseY = y;
        int tipX = x;
        int tipY = y - (int) height;

        // Draw cone
        Polygon cone = new Polygon();
        cone.addPoint(baseX, baseY);
        cone.addPoint(baseX + (int) radius, baseY);
        cone.addPoint(tipX, tipY);

        // Apply gradient for shading
        GradientPaint gradient = new GradientPaint(
                x, y, Color.LIGHT_GRAY,
                x, y - (int) height, Color.DARK_GRAY);
        g2d.setPaint(gradient);
        g2d.fill(cone);
        g2d.setColor(Color.BLACK);
        g2d.draw(cone);

        // create the dimensions of the circular base of the cone
        int baseCenterY = y; // Adjust the base center position
        int baseStartX = x - (int) (radius / 2);
        int baseStartY = baseCenterY - (int) (radius / 4);
        int baseWidth = (int) radius;
        int baseHeight = (int) (radius / 2);
        //draw the base using Ellipse2D
        Ellipse2D base = new Ellipse2D.Double(baseStartX, baseStartY, baseWidth, baseHeight);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(base);
        g2d.setColor(Color.BLACK);
        g2d.draw(base);
    }
}
