import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField;
    private String operator;
    private double firstOperand;

    public Calculator() {
        // Set up the JFrame
        setTitle("Calculator");
        setSize(450, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the window

        // Create components
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 48));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false); // Make the text field read-only
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 8)); // Increased spacing between buttons

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
             add(new JLabel()); 
        // Add buttons to the panel with improved styling
        for (String label : buttonLabels) {
            JButton button = createButton(label);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Enable keyboard input
        enableKeyboardInput();

        setVisible(true);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger font
        button.addActionListener(this);
        return button;
    }

    private void enableKeyboardInput() {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '.') {
                    textField.setText(textField.getText() + keyChar);
                } else if ("+-*/".contains(String.valueOf(keyChar))) {
                    operator = String.valueOf(keyChar);
                    firstOperand = Double.parseDouble(textField.getText());
                    textField.setText("");
                } else if (keyChar == KeyEvent.VK_ENTER) {
                    calculateResult();
                } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
                    backspace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            textField.setText(textField.getText() + command);
        } else if ("+-*/".contains(command)) {
            operator = command;
            firstOperand = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if ("=".equals(command)) {
            calculateResult();
        } else if ("X".equals(command)) {
            backspace();
        }
    }

    private void calculateResult() {
        double secondOperand = Double.parseDouble(textField.getText());
        double result = performOperation(firstOperand, secondOperand, operator);
        textField.setText(String.valueOf(result));
    }

    private double performOperation(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    clear();
                    return 0;
                }
            default:
                return 0;
        }
    }

    private void clear() {
        textField.setText("");
        operator = null;
        firstOperand = 0;
    }

    private void backspace() {
        String currentText = textField.getText();
        if (!currentText.isEmpty()) {
            textField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
