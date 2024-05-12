import javax.swing.*;
import java.awt.*;
import java.io.*;

public class movie1_info {
    private JPanel panel1;
    private JRadioButton a600pmRadioButton;
    private JRadioButton a800pmRadioButton;
    private JPanel time1;
    private JPanel time2;
    private JCheckBox a1CheckBox;
    private JCheckBox a2CheckBox;
    private JCheckBox a3CheckBox;
    private JCheckBox b1CheckBox;
    private JCheckBox b2CheckBox;
    private JCheckBox b3CheckBox;
    private JCheckBox c1CheckBox;
    private JCheckBox c2CheckBox;
    private JCheckBox c3CheckBox;
    private JCheckBox d1CheckBox;
    private JCheckBox d2CheckBox;
    private JCheckBox d3CheckBox;
    private JCheckBox a1CheckBox1;
    private JCheckBox a2CheckBox1;
    private JCheckBox a3CheckBox1;
    private JCheckBox b1CheckBox1;
    private JCheckBox b2CheckBox1;
    private JCheckBox b3CheckBox1;
    private JCheckBox c1CheckBox1;
    private JCheckBox c2CheckBox1;
    private JCheckBox c3CheckBox1;
    private JCheckBox d1CheckBox1;
    private JCheckBox d2CheckBox1;
    private JCheckBox d3CheckBox1;
    private JButton reserveSeatsButton;

    private String username = "";

    public movie1_info(boolean isGuest, String username) {
        this.username = username;

        JFrame frame = new JFrame("Titanic");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel1);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        a600pmRadioButton.addActionListener(e -> {
            if (a600pmRadioButton.isSelected()) {
                time1.setVisible(true);
                time2.setVisible(false);

                for (Component component : time1.getComponents()) {
                    if (component instanceof JCheckBox) {
                        ((JCheckBox) component).setSelected(false);
                    }
                }

            }
        });

        a800pmRadioButton.addActionListener(e -> {
            if (a800pmRadioButton.isSelected()) {
                time1.setVisible(false);
                time2.setVisible(true);

                for (Component component : time2.getComponents()) {
                    if (component instanceof JCheckBox) {
                        ((JCheckBox) component).setSelected(false);
                    }
                }

            }
        });

        reserveSeatsButton.addActionListener(e -> {
            StringBuilder reservedSeats = new StringBuilder();
            JPanel panel = a600pmRadioButton.isSelected() ? time1 : time2;
            for (Component component : panel.getComponents()) {
                if (component instanceof JCheckBox) {
                    if (((JCheckBox) component).isSelected()) {
                        reservedSeats.append(((JCheckBox) component).getText()).append(" ");
                    }
                }
            }

            if (isGuest) {
                // Show a message dialog for guests
                JOptionPane.showMessageDialog(null,
                        "Please show this to the front desk to confirm your seats." + "\n" +
                        "The reserved seats are: " + reservedSeats.toString(), "Reserved Seats", JOptionPane.INFORMATION_MESSAGE);
            }

            else {
                if (a600pmRadioButton.isSelected()) {
                    try {
                        FileWriter writer = new FileWriter("src/resources/guest_movie1_600pm.txt");
                        writer.write("Seats reserved: ");
                        for (Component component : time1.getComponents()) {
                            if (component instanceof JCheckBox) {
                                if (((JCheckBox) component).isSelected()) {
                                    writer.write(((JCheckBox) component).getText() + " ");
                                }
                            }
                            writer.write(" for " + username + "\n");
                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else if (a800pmRadioButton.isSelected()) {
                    try {
                        FileWriter writer = new FileWriter("src/resources/guest_movie1_800pm.txt");
                        writer.write("Seats reserved: ");
                        for (Component component : time2.getComponents()) {
                            if (component instanceof JCheckBox) {
                                if (((JCheckBox) component).isSelected()) {
                                    writer.write(((JCheckBox) component).getText() + " ");
                                }
                            }
                            writer.write(" for " + username + "\n");
                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                // Show a message dialog for registered users
                JOptionPane.showMessageDialog(null,
                        "Your reserved seats are:" + reservedSeats.toString());

            }

        });

    }
}