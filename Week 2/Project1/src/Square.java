/* Square.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/27/2023
 * Purpose: The Square class is a child class of TwoDimensionalShape that creates a 2D Square object.
 * The class has a private member variable sideLength, a constructor with one argument, and a getSideLength method.*/

//For use of Math.pow()
import java.lang.Math;
public class Square extends TwoDimensionalShape {
    //only one variable of sideLength is needed because squares have all equal sides.
    private double sideLength;
    public Square(double sideLength) {
        //using super gets the area of the square.
        super(2, Math.pow(sideLength, 2));
        this.sideLength = sideLength;
    }
    public double getSideLength() { return sideLength; }
}
