/* Shape.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/25/2023
 * Purpose: The Shape class creates a Shape object that has a certain number of dimensions (typically 2 or 3 dimensions)
 * The class itself declares a private member variable numDimensions and has a default constructor with an argument and
 * a function geDimensions that returns the number of dimensions the shape object has */

public class Shape {
    //A shape has a number of dimensions - 2 or 3. I included a get function in case it was ever possibly needed
    private int numDimensions;
    public Shape(int numDimensions) {
        this.numDimensions = numDimensions;
    }
    public int getDimensions() { return numDimensions; }
}