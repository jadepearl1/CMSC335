/* Cube.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/29/2023
 * Purpose: The Cube class is a child class of ThreeDimensionalShape that creates a 3D Cube object.
 * The class has a private member variable sideLength, a constructor with one argument, and a method getSideLength.*/

public class Cube extends ThreeDimensionalShape {
    private double sideLength;
    public Cube(double sideLength) {
        //using super gets the volume of the cube
        super(3, sideLength * sideLength * sideLength);
        this.sideLength = sideLength;
    }
    public double getSideLength() {
        return sideLength;
    }
}
