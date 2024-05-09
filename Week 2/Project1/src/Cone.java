/* Cone.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/29/2023
 * Purpose: The Cone class is a child class of ThreeDimensionalShape that creates a 3D Cone object.
 * The class has two private member variables radius and height, a constructor with two arguments, and
 * two methods getRadius and getHeight.*/

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
}
