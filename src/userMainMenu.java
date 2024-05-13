import javax.swing.*;

public class userMainMenu {
    private JLabel welcomeUserText;
    private JButton reserveMovieTicketsButton;
    private JButton buyConcessionsButton;
    private JButton editMovieTicketsButton;
    private JPanel panel1;

    public userMainMenu(String username) {

        JFrame frame = new JFrame("User Main Menu");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        welcomeUserText.setText("Welcome, " + username + "! What would you like to do?");

        reserveMovieTicketsButton.addActionListener(e -> {
            new MovieMenu(false, username);
        });

    }


}
