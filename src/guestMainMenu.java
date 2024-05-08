import javax.swing.*;

public class guestMainMenu {
    private JPanel panel1;
    private JButton buyMovieTicketsButton;
    private JButton buyConcessionsButton;

    public guestMainMenu(boolean b) {

        JFrame frame = new JFrame("Guest Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        buyMovieTicketsButton.addActionListener(e -> {
            new guestMovieMenu();
        });

        buyConcessionsButton.addActionListener(e -> {
            new guestConcessions();
        });

    }

}
