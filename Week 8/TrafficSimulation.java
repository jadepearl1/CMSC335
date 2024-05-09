/* TrafficSimulation.java
 * Date Created: 12/6/2023
 * Date Modified: 12/13/2023
 * Author: Jade Pearl
 * Description:
 * The TrafficSimulation class creates a graphical user interface (GUI) to simulate a traffic scenario.
 * It contains functionality to display traffic elements, control buttons for the simulation,
 * and manages the interaction between cars and traffic signals.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSimulation extends JFrame {
    // Properties for traffic elements, control buttons, car objects, and panels
    private TrafficDisplay trafficDisplay;
    private Car[] cars; //car objects that will be used to draw the cars in the GUI
    private JButton startButton, pauseButton, stopButton, continueButton; //Buttons for controlling the simulation
    private JPanel carPanel; // Panel to hold car displays

    // Constructor sets up the GUI for the traffic simulation
    public TrafficSimulation() {
        setTitle("Traffic Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        trafficDisplay = new TrafficDisplay();
        carPanel = new JPanel(); // Create a panel to hold car displays
        carPanel.setLayout(new FlowLayout()); // Set layout for carPanel

        add(trafficDisplay, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
        add(carPanel, BorderLayout.WEST); // Add car panel to the left

        cars = new Car[3];
        cars[0] = new Car(trafficDisplay, "Intersection A", 2); // Car 1 with speed 2
        cars[1] = new Car(trafficDisplay, "Intersection B", 4); // Car 2 with speed 4
        cars[2] = new Car(trafficDisplay, "Intersection C", 3); // Car 3 with speed 3

        for (Car car : cars) {
            carPanel.add(car); // Add each car to the carPanel
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method creates a control panel with buttons for simulation control
    public JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        continueButton = new JButton("Continue");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        //need to add more action listeners for the other buttons

        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);
        controlPanel.add(continueButton);

        return controlPanel;
    }

    // Method starts the simulation by initiating threads for cars and traffic display
    public void startSimulation() {
        // Start threads for cars
        for (Car car : cars) {
            Thread carThread = new Thread(car);
            carThread.start();
        }

        // Start thread for traffic display (if needed)
        Thread trafficThread = new Thread((Runnable) trafficDisplay);
        trafficThread.start();
    }

    // Main method to initiate the traffic simulation within the event dispatch thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficSimulation();
            }
        });
    }
}