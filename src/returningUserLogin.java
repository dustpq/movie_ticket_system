import javax.swing.*;

public class returningUserLogin {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JButton goBackButton;

    public returningUserLogin() {

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        loginButton.addActionListener(e -> {
            String enteredUsername = textField1.getText();
            String enteredPassword = new String(passwordField1.getPassword());

            if (IDs.getTestUsername().equals(enteredUsername) && IDs.getTestPassword().equals(enteredPassword)) {
                // Correct username and password for test user
                System.out.println("Test user logged in");

                new userMainMenu(enteredUsername);
                frame.dispose();

            }

            else if (IDs.getAdminUsername().equals(enteredUsername) && IDs.getAdminPassword().equals(enteredPassword)) {
                // Correct username and password for admin user
                System.out.println("Admin user logged in");

                new adminMainMenu();
                frame.dispose();

            }

            else if (IDs.getUserPassword(enteredUsername) != null && IDs.getUserPassword(enteredUsername).equals(enteredPassword)) {
                // Correct username and password for a registered user
                System.out.println("New user logged in");

                new userMainMenu(enteredUsername);
                frame.dispose();

            }

            else {
                // Incorrect username or password
                System.out.println("Incorrect credentials entered");
                JOptionPane.showMessageDialog(frame, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        goBackButton.addActionListener(e -> {
            new returningAsk();
            frame.dispose();
        });

    }

}