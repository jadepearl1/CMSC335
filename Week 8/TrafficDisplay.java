/* TrafficDisplay.java
 * Date Created: 12/6/2023
 * Date Modified: 12/13/2023
 * Author: Jade Pearl
 * Description:
 * The TrafficDisplay class manages the graphical representation of traffic signals for multiple intersections
 * within a traffic simulation. It displays the traffic signal lights and controls their color changes
 * at predefined intervals. This class interacts with the Car class by providing signal color information
 * for cars to determine their movement. */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TrafficDisplay extends JPanel implements Runnable {
    // Properties for signal colors and images for the traffic lights
    private Color signalColorA, signalColorB, signalColorC;
    private BufferedImage redLight, yellowLight, greenLight;

    // Constructor sets up the initial display size and default signal colors for intersections
    public TrafficDisplay() {
        setPreferredSize(new Dimension(300, 150)); // Set size for the traffic light display

        signalColorA = Color.RED; // Default signal color for Intersection A
        signalColorB = Color.RED; // Default signal color for Intersection B
        signalColorC = Color.RED; // Default signal color for Intersection C

        // Load the images for red, yellow, and green lights
        try {
            redLight = ImageIO.read(getClass().getResource("/red.png"));
            yellowLight = ImageIO.read(getClass().getResource("/yellow.png"));
            greenLight = ImageIO.read(getClass().getResource("/green.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start the threads for changing signal colors
        new Thread(new SignalChangeRunnable("Intersection A", 3000)).start(); // Change every 3 seconds for Intersection A
        new Thread(new SignalChangeRunnable("Intersection B", 5000)).start(); // Change every 5 seconds for Intersection B
        new Thread(new SignalChangeRunnable("Intersection C", 7000)).start(); // Change every 7 seconds for Intersection C
    }

    // Runnable to change signal colors at different intervals
    class SignalChangeRunnable implements Runnable {
        // Properties for intersection name and time interval for signal changes
        private String intersection;
        private int interval;

        // Constructor initializes the signal change runnable with intersection and time interval
        public SignalChangeRunnable(String intersection, int interval) {
            this.intersection = intersection;
            this.interval = interval;
        }

        // Method controls the thread for signal color changes at predefined intervals
        public void run() {
            while (true) {
                try {
                    Thread.sleep(interval); // Wait for the specified interval
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                changeSignalColor(intersection); // Change the signal color for the specified intersection
                repaint(); // Repaint the panel
            }
        }
    }

    // Method changes the signal color for a specified intersection
    public void changeSignalColor(String intersection) {
        switch (intersection) {
            case "Intersection A":
                signalColorA = getNextColor(signalColorA);
                break;
            case "Intersection B":
                signalColorB = getNextColor(signalColorB);
                break;
            case "Intersection C":
                signalColorC = getNextColor(signalColorC);
                break;
            default:
                break;
        }
    }

    // Method determines the next signal color in the sequence
    public Color getNextColor(Color currentColor) {
        if (currentColor == Color.RED) {
            return Color.GREEN;
        } else if (currentColor == Color.GREEN) {
            return Color.YELLOW;
        } else {
            return Color.RED;
        }
    }

    // Method paints the traffic lights for intersections A, B, and C on the panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw traffic lights for Intersection A, B, and C
        drawTrafficLight(g, signalColorA, 20, 20);
        drawTrafficLight(g, signalColorB, 120, 20);
        drawTrafficLight(g, signalColorC, 220, 20);
    }

    // Method draws a specific traffic light at given coordinates based on its color
    public void drawTrafficLight(Graphics g, Color signalColor, int x, int y) {
        int lightSize = 40; // Size of the traffic light

        BufferedImage currentLight = redLight; // Default to red light
        if (signalColor == Color.YELLOW) {
            currentLight = yellowLight;
        } else if (signalColor == Color.GREEN) {
            currentLight = greenLight;
        }

        g.drawImage(currentLight, x, y, lightSize, lightSize * 3, this); // Draw the current traffic light
    }

    // Method retrieves the current signal color for a specified intersection
    public Color getSignalColor(String intersection) {
        switch (intersection) {
            case "Intersection A":
                return signalColorA;
            case "Intersection B":
                return signalColorB;
            case "Intersection C":
                return signalColorC;
            default:
                return Color.RED; // Default to red if intersection not found
        }
    }

    //run() method must be included although may not be used in this class
    @Override
    public void run() {
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}