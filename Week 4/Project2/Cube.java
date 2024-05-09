/* Cube.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1 and last modified on 11/14/2023
 * Purpose: The Cube class is a child class of ThreeDimensionalShape that creates a 3D Cube object.
 * The class has a private member variable sideLength, a constructor with one argument, and a method getSideLength.
 * 
 * Modification: added a draw method to draw the shapes in a GUI */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Cube extends ThreeDimensionalShape {
    private double sideLength;

    public Cube(double sideLength) {
        // using super gets the volume of the cube
        super(3, sideLength * sideLength * sideLength);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        int side = (int) sideLength;

        // Front face
        Polygon frontFace = new Polygon();
        frontFace.addPoint(x - side / 2, y - side / 2);
        frontFace.addPoint(x + side / 2, y - side / 2);
        frontFace.addPoint(x + side / 2, y + side / 2);
        frontFace.addPoint(x - side / 2, y + side / 2);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(frontFace);
        g2d.setColor(Color.BLACK);
        g2d.draw(frontFace);

        // Back face
        int backOffset = side / 4;
        Polygon backFace = new Polygon();
        backFace.addPoint(x - side / 2 + backOffset, y - side / 2 - backOffset);
        backFace.addPoint(x + side / 2 + backOffset, y - side / 2 - backOffset);
        backFace.addPoint(x + side / 2 + backOffset, y + side / 2 - backOffset);
        backFace.addPoint(x - side / 2 + backOffset, y + side / 2 - backOffset);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(backFace);
        g2d.setColor(Color.BLACK);
        g2d.draw(backFace);

        // Connect front and back faces
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x - side / 2, y - side / 2, x - side / 2 + backOffset, y - side / 2 - backOffset);
        //g2d.drawLine(x + side / 2, y - side / 2, x + side / 2 + backOffset, y - side / 2 - backOffset);
        g2d.drawLine(x + side / 2, y + side / 2, x + side / 2 + backOffset, y + side / 2 - backOffset);
        g2d.drawLine(x - side / 2, y + side / 2, x - side / 2 + backOffset, y + side / 2 - backOffset);
    }
}
