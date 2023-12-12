import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class BMI_CALCULATOR extends JFrame implements ActionListener {

    private JTextField weightField;
    private JTextField heightField;
    private JTextField resultField;

    public BMI_CALCULATOR() {
        // Set up the JFrame
        setTitle("BMI Calculator");
        setSize(350, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 8));
        setLocationRelativeTo(null); // Center the window

        // Create rounded border
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Create components
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 26)); // Increased text size

        weightField = new JTextField();
        weightField.setFont(new Font("Arial", Font.PLAIN, 22)); // Increased text size
        weightField.setBorder(BorderFactory.createCompoundBorder(roundedBorder, emptyBorder));
        enableNumericInput(weightField);

        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 26)); // Increased text size

        heightField = new JTextField();
        heightField.setFont(new Font("Arial", Font.PLAIN, 22)); // Increased text size
        heightField.setBorder(BorderFactory.createCompoundBorder(roundedBorder, emptyBorder));
        enableNumericInput(heightField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 26)); 

        JLabel resultLabel = new JLabel("BMI Result:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 26)); 
        resultField = new JTextField();
        resultField.setEditable(false); // Make the text field read-only
        resultField.setFont(new Font("Arial", Font.PLAIN, 26)); // Increased text size
        resultField.setBorder(BorderFactory.createCompoundBorder(roundedBorder, emptyBorder));

        // Add components to the panel
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(resultLabel);
        add(resultField);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculateBMI();
    }

    private void calculateBMI() {
        try {
            String weightText = weightField.getText().trim();
            String heightText = heightField.getText().trim();

            if (weightText.isEmpty() || heightText.isEmpty()) {
                // Show an error message or handle it appropriately
                return;
            }

            double weight = Double.parseDouble(weightText);
            double heightInCm = Double.parseDouble(heightText);

            // Convert height from cm to meters
            double heightInM = heightInCm / 100.0;

            double bmi = weight / (heightInM * heightInM);

            resultField.setText(String.format("%.2f", bmi));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for weight and height.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void enableNumericInput(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (!Character.isDigit(keyChar) && keyChar != '.' && keyChar != '\b') {
                    e.consume(); // Ignore non-numeric input
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMI_CALCULATOR());
    }
}
