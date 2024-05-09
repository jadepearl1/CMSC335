/* Sphere.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/29/2023
 * Purpose: The Sphere class is a child class of ThreeDimensionalShape that creates a 3D Sphere object.
 * The class has a private member variable radius, a constructor with one argument, and a method getRadius.*/

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
}