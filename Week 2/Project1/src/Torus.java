/* Torus.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/29/2023
 * Purpose: The Torus class is a child class of ThreeDimensionalShape that creates a 3D Torus object.
 * The class has two private member variables majorRadius and minorRadius, a constructor with two arguments, and
 * two methods getMajorRadius and getMinorRadius.*/

import java.lang.Math;
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
}