import javax.swing.*;

public class registerAsk {
    private JPanel panel1;
    private JButton continueAsGuestButton;
    private JButton registerAccountButton;
    private JButton goBackButton;

    public registerAsk() {
        JFrame frame = new JFrame("Welcome to the movie ticket booking system!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        continueAsGuestButton.addActionListener(e -> {
            new guestMainMenu(true);
            frame.dispose();
        });

        registerAccountButton.addActionListener(e -> {
            new newUserRegister();
            frame.dispose();
        });

        goBackButton.addActionListener(e -> {
            new returningAsk();
            frame.dispose();
        });

    }

}
