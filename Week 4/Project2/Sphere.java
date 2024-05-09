/* Sphere.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/15/2023
 * Purpose: The Sphere class is a child class of ThreeDimensionalShape that creates a 3D Sphere object.
 * The class has a private member variable radius, a constructor with one argument, and a method getRadius.
 * 
 * Modification: added draw method and imports to Swing to draw a Sphere in the GUI*/
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) {
        //using super gets the volume of the sphere
        super(3, (4.0 / 3.0) * Math.PI * radius * radius * radius);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }

    public void draw(Graphics g, int x, int y) {
        int diameter = (int) (2 * radius);

        BufferedImage image = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Create a radial gradient paint
        RadialGradientPaint paint = new RadialGradientPaint(
                new Point2D.Double(radius, radius),
                (float) radius,
                new float[]{0.0f, 1.0f},
                new Color[]{Color.BLUE, Color.WHITE}
        );

        // Set the paint for the graphics context
        g2d.setPaint(paint);

        // Fill the circle with the gradient
        g2d.fill(new Ellipse2D.Double(0, 0, diameter, diameter));

        g2d.dispose();

        // Draw the image onto the main graphics context
        g.drawImage(image, (int) (x - radius), (int) (y - radius), null);
    }
}