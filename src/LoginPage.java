import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JLabel FirstRow;
    private JLabel FirstRow2;
    private JLabel LastRow;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(1100, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        getRootPane().setBackground(new Color(59,46,46));
        getContentPane().setBackground(new Color(59,46,46));
        JPanel panel = new JPanel(new GridLayout(1, 2));

        // Image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        ImageIcon imageIcon = new ImageIcon("img/image.png"); // Replace with the actual path
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);

        // Login panel
        JPanel loginPanel = new JPanel(new GridLayout(5, 2,0,10));

        FirstRow = new JLabel("..");
        FirstRow2 = new JLabel("..");

        JLabel usernameLabel = new JLabel("Username :");
        usernameField = new JTextField();
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel passwordLabel = new JLabel("Password :");
        passwordField = new JPasswordField();
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel centerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        centerButtonPanel.add(loginButton);

        LastRow = new JLabel("");

        loginPanel.add(FirstRow);
        loginPanel.add(FirstRow2);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(centerButtonPanel);
        loginPanel.add(LastRow);

        panel.add(imagePanel);
        panel.add(loginPanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Placeholder for login logic
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Replace this with your actual login validation logic
        if ("637golusingh@gmail.com".equals(username) && "Computer@2024".equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful");
            // Open the dashboard or any other functionality
            openDashboard();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openDashboard() {
        // Replace this with code to open the dashboard or any other functionality
        // For example, new Dashboard(); or dashboard.setVisible(true);
        new DashBoard();
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
