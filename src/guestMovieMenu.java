import javax.swing.*;
import java.awt.*;

public class guestMovieMenu {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;


    public guestMovieMenu() {
        JFrame frame = new JFrame("Guest Main Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



        // Load the image
        ImageIcon movieIcon1 = new ImageIcon(getClass().getResource("/images/titanic.jpg"));
        // Scale the image
        Image image1 = movieIcon1.getImage();
        Image scaledImage1 = image1.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        // Set the icon of button1 to the scaled image
        label1.setIcon(scaledIcon1);

        // Load the image
        ImageIcon movieIcon2 = new ImageIcon(getClass().getResource("/images/mario_movie.jpeg"));
        // Scale the image
        Image image2 = movieIcon2.getImage();
        Image scaledImage2 = image2.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        // Set the icon of button1 to the scaled image
        label2.setIcon(scaledIcon2);

        // Load the image
        ImageIcon movieIcon3 = new ImageIcon(getClass().getResource("/images/kung_fu_panda.jpeg"));
        // Scale the image
        Image image3 = movieIcon3.getImage();
        Image scaledImage3 = image3.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        // Set the icon of button1 to the scaled image
        label3.setIcon(scaledIcon3);

        // Load the image
        ImageIcon movieIcon4 = new ImageIcon(getClass().getResource("/images/cinderella.jpg"));
        // Scale the image
        Image image4 = movieIcon4.getImage();
        Image scaledImage4 = image4.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
        // Set the icon of button1 to the scaled image
        label4.setIcon(scaledIcon4);

        button1.addActionListener(e -> {
            new movie1_info(true);
        });

        button2.addActionListener(e -> {
            //new ticketPricing();
        });

        button3.addActionListener(e -> {
            //new ticketPricing();
        });

        button4.addActionListener(e -> {
            //new ticketPricing();
        });

    }

}
