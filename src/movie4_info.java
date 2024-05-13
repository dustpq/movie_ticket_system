import javax.swing.*;
import java.awt.*;
import java.io.*;

public class movie4_info {
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

    public movie4_info(boolean isGuest, String username) {

        JFrame frame = new JFrame("Cinderella");
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
            String showTime = a600pmRadioButton.isSelected() ? "600pm" : "800pm";
            for (Component component : panel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        String seat = checkBox.getText();
                        if (isSeatReserved(seat, showTime)) {
                            JOptionPane.showMessageDialog(null,
                                    "Seat " + seat + " is already reserved for the " + showTime + " show.",
                                    "Seat Already Reserved", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        reservedSeats.append(seat).append(" ");
                    }
                }
            }

            if (isGuest) {
                JOptionPane.showMessageDialog(null,
                        "Please show this to the front desk to confirm your seats." + "\n" +
                        "The reserved seats are: " + reservedSeats.toString(), "Reserved Seats", JOptionPane.INFORMATION_MESSAGE);
            }

            else {
                if (a600pmRadioButton.isSelected()) {

                    try {
                        FileWriter writer = new FileWriter("src/resources/movie4_600pm.txt", true);
                        writer.write("Seats reserved: ");
                        for (Component component : time1.getComponents()) {
                            if (component instanceof JCheckBox) {

                                    if (((JCheckBox) component).isSelected()) {
                                    writer.write(((JCheckBox) component).getText() + " ");
                                    writer.write("for " + username + "\n");
                                    }

                            }
                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else if (a800pmRadioButton.isSelected()) {
                    try {
                        FileWriter writer = new FileWriter("src/resources/movie4_800pm.txt", true);
                        writer.write("Seats reserved: ");
                        for (Component component : time2.getComponents()) {
                            if (component instanceof JCheckBox) {
                                if (((JCheckBox) component).isSelected()) {
                                    writer.write(((JCheckBox) component).getText() + " ");
                                    writer.write("for " + username + "\n");
                                }
                            }
                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                // Show a message dialog for registered users
                JOptionPane.showMessageDialog(null,
                        "Your reserved seats are: " + reservedSeats.toString());

            }

        });

    }

    public boolean isSeatReserved(String seat, String showTime) {
        String filename = "";
        if (showTime.equals("600pm")) {
            filename = "src/resources/movie4_600pm.txt";
        } else if (showTime.equals("800pm")) {
            filename = "src/resources/movie4_800pm.txt";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(seat)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}