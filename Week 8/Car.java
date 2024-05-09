/* Car.java
 * Date Created: 12/6/2023
 * Date Modified: 12/13/2023
 * Jade Pearl
 * The Car class creates a graphical representation of a car within a traffic simulation.
 * It contains properties and methods for the car's movement, interaction with traffic signals,
 * and display of information on its assigned panel.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car extends JPanel implements Runnable {
    // Properties for car position, size, movement status, traffic display, intersection, speed, and image
    private int xPosition;
    private int yPosition;
    private int carWidth = 150;
    private int carHeight = 100;
    private boolean isMoving; 
    private TrafficDisplay trafficDisplay; 
    private String intersection; //each car is given an intersection with a TrafficDisplay (light)
    private int speed;
    private BufferedImage carImage;

    // Constructor initializes the car with its assigned intersection, speed, and initial position
    public Car(TrafficDisplay trafficDisplay, String intersection, int speed) {
        this.trafficDisplay = trafficDisplay;
        this.intersection = intersection;
        this.speed = speed; // Assign the speed
        this.xPosition = 0;
        this.yPosition = 300;
        this.isMoving = true;

        try {
            carImage = ImageIO.read(getClass().getResource("/car.png")); // Load the car image
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPreferredSize(new Dimension(300, 400));
        setBackground(Color.WHITE);

        new Thread(this).start();
    }

    // Method to update the car's position based on its speed and panel width
    public void moveCar() {
        if (isMoving) {
            xPosition += speed; // Move the car according to its speed
            if (xPosition > getWidth()) {
                xPosition = -carWidth; // Reset the car's position to the left when it reaches the panel's width
            }
        }
    }

    // Method to check the traffic signal color for the car's assigned intersection
    public boolean isSignalRed() {
        Color signalColor = trafficDisplay.getSignalColor(intersection);
        return signalColor == Color.RED;
    }

    // Method to paint the car image and display car information on its panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCar(g); // Draw the car image
        displayCarInfo(g); // Display car information on the panel
    }

    // Method to draw the car image on the panel
    public void drawCar(Graphics g) {
        if (carImage != null) {
            g.drawImage(carImage, xPosition, yPosition, carWidth, carHeight, this);
        } else {
            // If the image fails to load, draw a rectangle as a placeholder
            g.setColor(Color.BLUE);
            g.fillRect(xPosition, yPosition, carWidth, carHeight);
        }
    }

    // Method to display car information (intersection, timestamp, position, speed) on the panel
    public void displayCarInfo(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Intersection: " + intersection, 10, 20); // Display the intersection name

        // Get current timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = dateFormat.format(now);
        g.drawString("Timestamp: " + formattedDate, 10, 40);

        // Display car position (X, Y)
        g.drawString("X Position: " + xPosition, 10, 60);
        g.drawString("Y Position: " + yPosition, 10, 80);

        // Display car speed
        g.drawString("Speed: " + speed, 10, 100);
    }

    // Thread execution controlling the car's movement based on traffic signals
    @Override
    public void run() {
        while (true) {
            moveCar();
            if (isSignalRed()) {
                isMoving = false; // Stop the car when the signal is red
            } else {
                isMoving = true; // Allow the car to move when the signal changes
            }
            repaint(); // Redraw the car
            try {
                Thread.sleep(20); // Adjust the sleep duration for smoother movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
