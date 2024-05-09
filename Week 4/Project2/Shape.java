/* Shape.java
 * Jade Pearl
 * CMSC 335 Project 2
 * Taken from my Project 1. Last modified on 11/13/2023
 * Purpose: The Shape class creates a Shape object that has a certain number of dimensions (typically 2 or 3 dimensions)
 * The class itself declares a private member variable numDimensions and has a default constructor with an argument and
 * a function geDimensions that returns the number of dimensions the shape object has 
 * 
 * Modification: added a draw method definition to draw Shapes. made the class abstract*/

import java.awt.Graphics;

public abstract class Shape {
    //A shape has a number of dimensions - 2 or 3. I included a get function in case it was ever possibly needed
    private int numDimensions;
    public Shape(int numDimensions) {
        this.numDimensions = numDimensions;
    }
    public int getDimensions() { return numDimensions; }
    public abstract void draw(Graphics g, int x, int y);
}