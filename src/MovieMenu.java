import javax.swing.*;
import java.awt.*;

public class MovieMenu {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel tiptext;


    public MovieMenu(boolean isGuest, String username) {

        boolean isGuest1 = isGuest;
        String username1 = username;

        JFrame frame = new JFrame("Movie Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        ImageIcon movieIcon1 = new ImageIcon(getClass().getResource("/images/titanic.jpg"));
        Image image1 = movieIcon1.getImage();
        Image scaledImage1 = image1.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        label1.setIcon(scaledIcon1);

        ImageIcon movieIcon2 = new ImageIcon(getClass().getResource("/images/mario_movie.jpeg"));
        Image image2 = movieIcon2.getImage();
        Image scaledImage2 = image2.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        label2.setIcon(scaledIcon2);

        ImageIcon movieIcon3 = new ImageIcon(getClass().getResource("/images/kung_fu_panda.jpeg"));
        Image image3 = movieIcon3.getImage();
        Image scaledImage3 = image3.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        label3.setIcon(scaledIcon3);

        ImageIcon movieIcon4 = new ImageIcon(getClass().getResource("/images/cinderella.jpg"));
        Image image4 = movieIcon4.getImage();
        Image scaledImage4 = image4.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
        label4.setIcon(scaledIcon4);

        button1.addActionListener(e -> {
            new movie1_info(isGuest1, username1);
        });

        button2.addActionListener(e -> {
            new movie2_info(isGuest1, username1);
        });

        button3.addActionListener(e -> {
            new movie3_info(isGuest1, username1);
        });

        button4.addActionListener(e -> {
            new movie4_info(isGuest1, username1);
        });

    }

}
