import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DashBoard extends JFrame implements ActionListener {

    private JFrame currentModule;

    public DashBoard() {
        setTitle("Dashboard");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getRootPane().setBorder(new EmptyBorder(20, 0, 0, 0));
        getRootPane().setBackground(new Color(59,46,46));
        setLayout(new GridLayout(3, 3, 10, 10)); // 3 rows, 3 columns, spacing

        getContentPane().setBackground(new Color(59,46,46));
        // Create buttons for each functionality
        JButton calculatorButton = createOptionButton("Calculator");
        JButton unitConverterButton = createOptionButton("Data Converter");
        JButton ageCalculatorButton = createOptionButton("Age Calculator");
        JButton BMICalculatorButton = createOptionButton("BMI Calculator");
        JButton speedCalculatorButton = createOptionButton("Speed Calculator");
        JButton temperatureConverterButton = createOptionButton("Temperature Converter");

        // Add buttons to the dashboard
        add(calculatorButton);
        add(unitConverterButton);
        add(ageCalculatorButton);
        add(BMICalculatorButton);
        add(speedCalculatorButton);
        add(temperatureConverterButton);

        add(new JLabel());

        // Create a label for the welcome message
        JLabel welcomeLabel = new JLabel("Welcome GOLU  the Fun Calculation!",JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.WHITE);

        // Add the welcome message to the bottom row
        add(welcomeLabel);

        // Add action listeners to the buttons
        calculatorButton.addActionListener(this);
        unitConverterButton.addActionListener(this);
        ageCalculatorButton.addActionListener(this);
        BMICalculatorButton.addActionListener(this);
        speedCalculatorButton.addActionListener(this);
        temperatureConverterButton.addActionListener(this);

        setVisible(true);
    }

    private JButton createOptionButton(String option) {
        JButton button = new JButton(option);
        button.setFont(new Font("Arial", Font.PLAIN, 22));
        button.setPreferredSize(new Dimension(150, 100)); // Adjusted button size

        // Use LineBorder with a rounded rectangle shape
        button.setBorder(new LineBorder(Color.BLACK, 2, true));
        button.setBackground(new Color(145 ,188,188));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String option = ((JButton) e.getSource()).getText();

        // Handle button clicks and open the respective functionality
        switch (option) {
            case "Calculator":
                openModule(new Calculator());
                break;
            case "Data Converter":
                openModule(new DataConverter());
                break;
            case "Age Calculator":
                openModule(new Age_CalC());
                break;
            case "BMI Calculator":
                openModule(new BMI_CALCULATOR());
                break;
            case "Speed Calculator":
                openModule(new SpeedCalculator());
                break;
            case "Temperature Converter":
                openModule(new TemperatureConverter());
                break;
            default:
                break;
        }
    }

    private void openModule(JFrame module) {
        setVisible(false); // Hide the dashboard
        currentModule = module;
        currentModule.setVisible(true); // Show the selected module

        // Add a WindowListener to detect when the child module is closing
        currentModule.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(true); // Show the dashboard again when the child module is closing
            }
        });
    }

    public static void main(String[] args) {
        DashBoard dashboard = new DashBoard();
        dashboard.setLocationRelativeTo(null); // Center the window

        // Add a WindowListener to detect when the dashboard is closing
        dashboard.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dashboard.setVisible(true); // Show the dashboard again when it is closing
            }
        });
    }
}
