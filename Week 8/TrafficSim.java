import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Enum for TrafficLightColor
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean paused = false;

    TrafficLightSimulator() {
        tlc = TrafficLightColor.GREEN; // Start with green initially
    }

    public void run() {
        while (!stop) {
            while (paused) {
                try {
                    Thread.sleep(500); // Pause for 0.5 seconds while paused
                } catch (InterruptedException exc) {
                    System.out.println(exc);
                }
            }
            updateTrafficLightColor();
            try {
                switch (tlc) {
                    case GREEN:
                        Thread.sleep(10000); // green for 10 seconds
                        tlc = TrafficLightColor.YELLOW;
                        break;
                    case YELLOW:
                        Thread.sleep(2000); // yellow for 2 seconds
                        tlc = TrafficLightColor.RED;
                        break;
                    case RED:
                        Thread.sleep(12000); // red for 12 seconds
                        tlc = TrafficLightColor.GREEN;
                        break;
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }

    private void updateTrafficLightColor() {
        SwingUtilities.invokeLater(() -> {
            Color lightColor;

            switch (tlc) {
                case GREEN:
                    lightColor = Color.GREEN;
                    break;
                case YELLOW:
                    lightColor = Color.YELLOW;
                    break;
                case RED:
                    lightColor = Color.RED;
                    break;
                default:
                    lightColor = Color.BLACK;
                    break;
            }

            TrafficSim.setTrafficLightColor(lightColor);
        });
    }

    synchronized void cancel() {
        stop = true;
    }

    synchronized void pause() {
        paused = true;
    }

    synchronized void resume() {
        paused = false;
    }
}

public class TrafficSim extends JFrame implements ActionListener {
    private JButton startButton, stopButton, pauseButton, continueButton;
    private static JLabel trafficLightLabel;

    private TrafficLightSimulator trafficLightSimulator;
    private Thread trafficLightThread;

    private volatile boolean isRunning = false;

    public TrafficSim() {
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Traffic light label
        trafficLightLabel = new JLabel();
        trafficLightLabel.setPreferredSize(new Dimension(100, 300));
        trafficLightLabel.setOpaque(true);
        trafficLightLabel.setBackground(Color.BLACK); // Initially set to black (lights off)

        panel.add(trafficLightLabel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        pauseButton = new JButton("Pause");
        continueButton = new JButton("Continue");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        pauseButton.addActionListener(this);
        continueButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(continueButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void setTrafficLightColor(Color color) {
        trafficLightLabel.setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficSim::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!isRunning) {
                isRunning = true;
                trafficLightSimulator = new TrafficLightSimulator();
                trafficLightThread = new Thread(trafficLightSimulator);
                trafficLightThread.start();
            }
        } else if (e.getSource() == stopButton) {
            if (isRunning) {
                isRunning = false;
                trafficLightSimulator.cancel();
                setTrafficLightColor(Color.BLACK); // Turn off the lights when stopping
            }
        } else if (e.getSource() == pauseButton) {
            if (isRunning && trafficLightSimulator != null) {
                trafficLightSimulator.pause();
            }
        } else if (e.getSource() == continueButton) {
            if (isRunning && trafficLightSimulator != null) {
                trafficLightSimulator.resume();
            }
        }
    }
}