/* Cylinder.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/29/2023
 * Purpose: The Cylinder class is a child class of ThreeDimensionalShape that creates a 3D Cylinder object.
 * The class has two private member variables radius and height, a constructor with two arguments, and
 * two methods getRadius and getHeight.*/

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
}
