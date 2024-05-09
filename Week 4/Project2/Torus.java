/* Torus.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/15/2023
 * Purpose: The Torus class is a child class of ThreeDimensionalShape that creates a 3D Torus object.
 * The class has two private member variables majorRadius and minorRadius, a constructor with two arguments, and
 * two methods getMajorRadius and getMinorRadius.
 * 
 * Modification: added a draw method and imports to Swing to draw a Torus in GUI*/

import java.lang.Math;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Torus extends ThreeDimensionalShape {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        super(3, (Math.PI * Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius));
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void draw(Graphics g, int x, int y) {
        //create the outer circle dimensions
        int outerCircleWidth = (int) (majorRadius * 2);
        int outerCircleHeight = (int) (majorRadius * 2);
        int outerCircleX = x - (outerCircleWidth / 2);
        int outerCircleY = y - (outerCircleHeight / 2);
        //create the inner circle dimensions
        int innerCircleWidth = (int) (minorRadius * 2);
        int innerCircleHeight = (int) (minorRadius * 2);
        int innerCircleX = x - (innerCircleWidth / 2);
        int innerCircleY = y - (innerCircleHeight / 2);
        //Creates the color for gradience of the torus outer circle
        GradientPaint gradient = new GradientPaint(
                outerCircleX, outerCircleY, Color.BLACK,
                innerCircleX + innerCircleWidth, innerCircleY + innerCircleHeight, Color.LIGHT_GRAY);
        //paint/draw the torus
        ((Graphics2D) g).setPaint(gradient);
        g.fillOval(outerCircleX, outerCircleY, outerCircleWidth, outerCircleHeight);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(innerCircleX, innerCircleY, innerCircleWidth, innerCircleHeight);
    }
}