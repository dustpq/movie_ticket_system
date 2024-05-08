import javax.swing.*;

public class newUserRegister {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton registerButton;
    private JPanel panel1;
    private JTextField textField2;

    public newUserRegister() {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        registerButton.addActionListener(e -> {
            String enteredEmail = textField1.getText();
            String enteredUsername = textField2.getText();
            String enteredPassword = new String(passwordField1.getPassword());
            String reEnteredPassword = new String(passwordField2.getPassword());

            if (enteredPassword.equals(reEnteredPassword)) {
                // Passwords match
                // Proceed with registration
                IDs.addUser(enteredEmail, enteredUsername, enteredPassword);
                System.out.println("New user registered");
                JOptionPane.showMessageDialog(frame, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                new returningUserLogin();
                frame.dispose();

            } else {
                // Passwords do not match
                System.out.println("Passwords do not match");
                JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

}
