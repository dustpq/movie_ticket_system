import javax.swing.*;

public class returningAsk {
    private JPanel panel1;
    private JButton yesButton;
    private JButton noButton;

    public returningAsk() {
        JFrame frame = new JFrame("Welcome to the movie ticket booking system!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        yesButton.addActionListener(e -> {
            System.out.println("Returning user selected");
            new returningUserLogin();
            frame.dispose();
        });

        noButton.addActionListener(e -> {
            System.out.println("New user selected");
            new registerAsk();
            frame.dispose();
        });

    }

}
