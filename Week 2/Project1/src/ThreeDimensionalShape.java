/* ThreeDimensionalShape.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/25/2023
 * Purpose: The ThreeDimensionalShape class is a child class of Shape that creates a 3D shape object.
 * The class has a private member variable volume, a constructor with two arguments, and a getVolume method
 * in order to return the volume to a method from which it is called. */

public class ThreeDimensionalShape extends Shape {
    private double volume;
    public ThreeDimensionalShape(int numDimensions, double volume) {
        //There are 3 dimensions in this class
        super(numDimensions);
        this.volume = volume;
    }
    public double getVolume() { return volume; }
}
