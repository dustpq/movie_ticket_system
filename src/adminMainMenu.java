import javax.swing.*;

public class adminMainMenu {

    private JPanel panel1;
    private JButton editMovieTicketsButton;
    private JButton editUserCredentialsButton;
    private JButton signOutButton;

    public adminMainMenu() {
        JFrame frame = new JFrame("Admin Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        editMovieTicketsButton.addActionListener(e -> {
            new editMovieTickets();
        });

        editUserCredentialsButton.addActionListener(e -> {
            new editUserCredentials();
        });

        signOutButton.addActionListener(e -> {
            new returningAsk();
            frame.dispose();
        });

    }

}
