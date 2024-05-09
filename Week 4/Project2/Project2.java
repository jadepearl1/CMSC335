/* Jade Pearl
 * CMSC 335 Project 2
 * Last modified: 11/15/2023
 * Purpose: Project2.java contains the main method which creates a Swing GUI frame which is where
 * all of the shapes will be drawn. It implements a nested class ShapePanel that creates more elements
 * in the JFrame (the labels, button, and combobox). It has a constructor where it creates the needed
 * fields in the frame and adds functionality to the draw button. The method paintComponent determines where in
 * the frame that the shape is drawn (it attempts to center all shapes drawn in the frame). The other method
 * createShape takes parameters passed from another nested class DrawButtonListener and creates a new shape
 * using the shape classes already implemented (which will use their draw methods to draw the shapes to the
 * frame. The nested class within ShapePanel, DrawButtonListener, implements the ActionListener
 * interface as defined by Oracle. It processes the choice in the combo box picked by the user and develops 
 * functionality for the draw button. It takes the numbers written in the text fields of the frame and passes them
 * and the chosen shape to the createShape method to carry on drawing the shape with the entered parameters.
 * 
 * This file also uses exception handling if data is not properly processed by the GUI. Any thrown exceptions will be
 * printed to the console, not the GUI frame.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Project2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            ShapePanel shapePanel = new ShapePanel();
            frame.add(shapePanel);

            frame.setVisible(true);
        });
    }
}

class ShapePanel extends JPanel {
    private JComboBox<String> shapeComboBox;
    private JTextField parameter1Field;
    private JTextField parameter2Field;
    private JButton drawButton;

    private Shape selectedShape;

    private List<String> shapesRequiringTwoParameters = Arrays.asList("Triangle", "Rectangle", "Cone", "Cylinder", "Torus");

    public ShapePanel() {
        String[] shapeOptions = {"Circle", "Square", "Triangle", "Rectangle", "Sphere", "Cube", "Cone", "Cylinder", "Torus"};
        shapeComboBox = new JComboBox<>(shapeOptions);

        parameter1Field = new JTextField(10);
        parameter2Field = new JTextField(10);

        drawButton = new JButton("Draw Shape");
        drawButton.addActionListener(new DrawButtonListener());

        setLayout(new FlowLayout());
        add(new JLabel("Select Shape:"));
        add(shapeComboBox);
        add(new JLabel("Parameter 1:"));
        add(parameter1Field);
        add(new JLabel("Parameter 2:"));
        add(parameter2Field);
        add(drawButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (selectedShape != null) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            selectedShape.draw(g, centerX, centerY); //draw shapes at center of frame
        }
    }

    private class DrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String shapeType = (String) shapeComboBox.getSelectedItem();
            double parameter1, parameter2;
            try {
                parameter1 = Double.parseDouble(parameter1Field.getText());
                if (shapesRequiringTwoParameters.contains(shapeType)) {
                    parameter2 = Double.parseDouble(parameter2Field.getText());
                } else {
                    parameter2 = 0;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ShapePanel.this, "Invalid input. Please enter valid numbers.");
                return;
            }

            selectedShape = createShape(shapeType, parameter1, parameter2);
            repaint();
        }
    }

    private Shape createShape(String shapeType, double parameter1, double parameter2) {
        switch (shapeType) {
            case "Circle":
                return new Circle(parameter1);
            case "Square":
                return new Square(parameter1);
            case "Triangle":
                return new Triangle(parameter1, parameter2);
            case "Rectangle":
                return new Rectangle(parameter1, parameter2);
            case "Sphere":
                return new Sphere(parameter1);
            case "Cube":
                return new Cube(parameter1);
            case "Cone":
                return new Cone(parameter1, parameter2);
            case "Cylinder":
                return new Cylinder(parameter1, parameter2);
            case "Torus":
                return new Torus(parameter1, parameter2);
            default:
                return null;
        }
    }
}