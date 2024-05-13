import javax.swing.*;

public class userMainMenu {
    private JLabel welcomeUserText;
    private JButton reserveMovieTicketsButton;
    private JButton purchaseSnacksButton;
    private JButton editMovieTicketsButton;
    private JButton editSnacksButton;
    private JPanel panel1;

    private String username;

    public userMainMenu(String username) {

        this.username = username;

        JFrame frame = new JFrame("User Main Menu");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        welcomeUserText.setText("Welcome, " + username + "! What would you like to do?");

        /*reserveMovieTicketsButton.addActionListener(e -> {
            //new reserveMovieTickets(username);
            frame.dispose();
        });*/

    }


}
