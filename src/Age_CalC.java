import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Age_CalC extends JFrame implements ActionListener {

    private JTextField dobField;
    private JLabel yearsLabel, monthsLabel, daysLabel, weeksLabel, minutesLabel;

    public Age_CalC() {
        setTitle("Age Calculator");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(null);

        // Create components
        JLabel dobLabel = new JLabel("Enter Date of Birth (yyyy-MM-dd):");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dobField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");

        yearsLabel = new JLabel("Years: ");
        yearsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        monthsLabel = new JLabel("Months: ");
        monthsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        daysLabel = new JLabel("Days: ");
        daysLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        weeksLabel = new JLabel("Weeks: ");
        weeksLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        minutesLabel = new JLabel("Minutes: ");
        minutesLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Add components to the panel
        add(dobLabel);
        add(dobField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(yearsLabel);
        add(new JLabel());
        add(monthsLabel);
        add(new JLabel());
        add(daysLabel);
        add(new JLabel());
        add(weeksLabel);
        add(new JLabel());
        add(minutesLabel);

        // Add action listener to the button
        calculateButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculateAge();
    }

    private void calculateAge() {
        String dobText = dobField.getText();

        if (dobText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date of birth.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = dateFormat.parse(dobText);
            Date currentDate = new Date();

            // Calculate age components
            Calendar dobCalendar = Calendar.getInstance();
            dobCalendar.setTime(dob);

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);

            int years = currentCalendar.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);
            int months = currentCalendar.get(Calendar.MONTH) - dobCalendar.get(Calendar.MONTH);
            int days = currentCalendar.get(Calendar.DAY_OF_MONTH) - dobCalendar.get(Calendar.DAY_OF_MONTH);

            long ageInDays = (currentDate.getTime() - dob.getTime()) / (1000 * 60 * 60 * 24);
            long ageInWeeks = ageInDays / 7;
            long ageInMinutes = (currentDate.getTime() - dob.getTime()) / (1000 * 60);

            // Update labels
            yearsLabel.setText("Years: " + years);
            monthsLabel.setText("Months: " + months);
            daysLabel.setText("Days: " + days);
            weeksLabel.setText("Weeks: " + ageInWeeks);
            minutesLabel.setText("Minutes: " + ageInMinutes);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter the date in the format yyyy-MM-dd.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error calculating age.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Age_CalC());
    }
}
