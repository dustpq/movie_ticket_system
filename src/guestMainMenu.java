import javax.swing.*;

public class guestMainMenu {
    private JPanel panel1;
    private JButton buyMovieTicketsButton;
    private JButton buyConcessionsButton;

    public guestMainMenu(boolean isGuest, String username) {

        JFrame frame = new JFrame("Guest Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        buyMovieTicketsButton.addActionListener(e -> {
            new MovieMenu(isGuest, username);
        });

        buyConcessionsButton.addActionListener(e -> {
            new concessions();
        });

    }

}
