import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedCalculator extends JFrame implements ActionListener {

    private JTextField distanceField, timeField;
    private JLabel resultLabel;

    public SpeedCalculator() {
        setTitle("Speed Calculator");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel distanceLabel = new JLabel("Distance (km):");
        distanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        distanceField = new JTextField();
        JLabel timeLabel = new JLabel("Time (hours):");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeField = new JTextField();
        JButton calculateButton = new JButton("Calculate Speed");
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 16));
        calculateButton.addActionListener(this);
        resultLabel = new JLabel("Speed:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));


        // Set font size for better visibility
        Font font = new Font("Arial", Font.PLAIN, 16);
        distanceLabel.setFont(font);
        distanceField.setFont(font);
        timeLabel.setFont(font);
        timeField.setFont(font);
        calculateButton.setFont(font);
        resultLabel.setFont(font);

        // Add components to the layout
        add(distanceLabel);
        add(distanceField);
        add(timeLabel);
        add(timeField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(new JLabel()); // Empty label for spacing
        add(resultLabel);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double time = Double.parseDouble(timeField.getText());

            // Calculate speed
            double speed = distance / time;

            // Display the result in km/h
            resultLabel.setText(String.format("Speed: %.2f km/h", speed));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpeedCalculator::new);
    }
}
