import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataConverter extends JFrame implements ActionListener {

    private JTextField inputValueField, resultTextField;
    private JComboBox<String> fromUnitComboBox, toUnitComboBox;

    public DataConverter() {
        setTitle("Unit Converter");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null);

        // Create components
        JLabel valueLabel = new JLabel("Enter Value:");
         valueLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        inputValueField = new JTextField();
        JLabel fromUnitLabel = new JLabel("From Unit:");
         fromUnitLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fromUnitComboBox = new JComboBox<>(new String[]{"Bytes", "KB", "MB", "GB", "TB"});
        JLabel toUnitLabel = new JLabel("To Unit:");
         toUnitLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        toUnitComboBox = new JComboBox<>(new String[]{"Bytes", "KB", "MB", "GB", "TB"});
        JLabel resultLabel = new JLabel("Result:");
         resultLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        resultTextField = new JTextField();
        resultTextField.setEditable(false); // Make the result field read-only
        JButton convertButton = new JButton("Convert");

        // Add components to the panel
        add(valueLabel);
        add(inputValueField);
        add(fromUnitLabel);
        add(fromUnitComboBox);
        add(toUnitLabel);
        add(toUnitComboBox);
        add(resultLabel);
        add(resultTextField);
        add(new JLabel()); // Empty label for spacing
        add(convertButton);

        // Add action listener to the button
        convertButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Convert")) {
            convertUnits();
        }
    }

    private void convertUnits() {
        try {
            double inputValue = Double.parseDouble(inputValueField.getText());
            String fromUnit = fromUnitComboBox.getSelectedItem().toString();
            String toUnit = toUnitComboBox.getSelectedItem().toString();

            double result = convert(inputValue, fromUnit, toUnit);
            resultTextField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Bytes":
                return convertBytes(value, toUnit);
            case "KB":
                return convertKB(value, toUnit);
            case "MB":
                return convertMB(value, toUnit);
            case "GB":
                return convertGB(value, toUnit);
            case "TB":
                return convertTB(value, toUnit);
            default:
                return 0;
        }
    }

    private double convertBytes(double value, String toUnit) {
        switch (toUnit) {
            case "Bytes":
                return value;
            case "KB":
                return value / 1024;
            case "MB":
                return value / (1024 * 1024);
            case "GB":
                return value / (1024 * 1024 * 1024);
            case "TB":
                return value / (1024 * 1024 * 1024 * 1024);
            default:
                return 0;
        }
    }

    private double convertKB(double value, String toUnit) {
        switch (toUnit) {
            case "Bytes":
                return value * 1024;
            case "KB":
                return value;
            case "MB":
                return value / 1024;
            case "GB":
                return value / (1024 * 1024);
            case "TB":
                return value / (1024 * 1024 * 1024);
            default:
                return 0;
        }
    }

    private double convertMB(double value, String toUnit) {
        switch (toUnit) {
            case "Bytes":
                return value * 1024 * 1024;
            case "KB":
                return value * 1024;
            case "MB":
                return value;
            case "GB":
                return value / 1024;
            case "TB":
                return value / (1024 * 1024);
            default:
                return 0;
        }
    }

    private double convertGB(double value, String toUnit) {
        switch (toUnit) {
            case "Bytes":
                return value * 1024 * 1024 * 1024;
            case "KB":
                return value * 1024 * 1024;
            case "MB":
                return value * 1024;
            case "GB":
                return value;
            case "TB":
                return value / 1024;
            default:
                return 0;
        }
    }

    private double convertTB(double value, String toUnit) {
        switch (toUnit) {
            case "Bytes":
                return value * 1024 * 1024 * 1024 * 1024;
            case "KB":
                return value * 1024 * 1024 * 1024;
            case "MB":
                return value * 1024 * 1024;
            case "GB":
                return value * 1024;
            case "TB":
                return value;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataConverter());
    }
}
