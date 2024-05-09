/* TimeStamp.java
 * Date Created: 12/6/2023
 * Date Modified: 12/13/2023
 * Author: Jade Pearl
 * Description:
 * The TimeStamp class creates a panel displaying the current time in a specific format (yyyy-MM-dd HH:mm:ss).
 * It updates the time label at one-second intervals using a separate thread, providing real-time display
 * of the current time on the graphical user interface (GUI).*/

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp extends JPanel implements Runnable {
    private JLabel timeLabel;

    // Constructor initializes the panel to display the current time
    public TimeStamp() {
        setPreferredSize(new Dimension(400, 50)); // Set preferred size for the timestamp panel
        setBackground(Color.WHITE); // Set background color

        timeLabel = new JLabel(); // Create a label for displaying time
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        add(timeLabel); // Add the label to the panel

        // Start the time update in a separate thread
        new Thread(this).start();
    }

    // Method to update the time label
    public void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = dateFormat.format(now);
        timeLabel.setText("Current Time: " + formattedDate);
    }

    // Run method to update time at 1-second intervals
    @Override
    public void run() {
        while (true) {
            updateTime(); // Update the time label
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
