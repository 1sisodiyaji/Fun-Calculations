import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame implements ActionListener {

    private JTextField inputField, outputField;
    private JRadioButton celsiusToFahrenheit, fahrenheitToCelsius;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField = new JTextField();
        JLabel outputLabel = new JLabel("Converted Temperature:");
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        outputField = new JTextField();
        outputField.setEditable(false); // Make the output field read-only

        // Radio buttons for conversion direction
        celsiusToFahrenheit = new JRadioButton("Celsius to Fahrenheit");
        celsiusToFahrenheit.setFont(new Font("Arial", Font.PLAIN, 16));
        fahrenheitToCelsius = new JRadioButton("Fahrenheit to Celsius");
        fahrenheitToCelsius.setFont(new Font("Arial", Font.PLAIN, 16));

        // Button group to ensure only one radio button is selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(celsiusToFahrenheit);
        group.add(fahrenheitToCelsius);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        // Add components to the layout
        add(inputLabel);
        add(inputField);
        add(outputLabel);
        add(outputField);
        add(celsiusToFahrenheit);
        add(fahrenheitToCelsius);
        add(new JLabel()); // Empty label for spacing
        add(convertButton);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double temperature = Double.parseDouble(inputField.getText());

            if (celsiusToFahrenheit.isSelected()) {
                // Convert Celsius to Fahrenheit
                double result = (temperature * 9 / 5) + 32;
                outputField.setText(String.format("%.2f °F", result));
            } else if (fahrenheitToCelsius.isSelected()) {
                // Convert Fahrenheit to Celsius
                double result = (temperature - 32) * 5 / 9;
                outputField.setText(String.format("%.2f °C", result));
            } else {
                // No radio button selected
                outputField.setText("Select conversion direction");
            }
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverter::new);
    }
}
