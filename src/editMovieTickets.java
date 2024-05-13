import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class editMovieTickets {
    private JComboBox comboBox1;
    private JTextArea txtText;
    private JPanel panel;
    private JLabel editAsk;
    private JButton saveChangesButton;
    private String filePath;

    public editMovieTickets() {
        JFrame frame = new JFrame("Edit Movie Tickets");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        filePath = "src/resources/movie1_600pm.txt";

        comboBox1.addItem("movie1_600pm");
        comboBox1.addItem("movie1_800pm");
        comboBox1.addItem("movie2_600pm");
        comboBox1.addItem("movie2_800pm");
        comboBox1.addItem("movie3_600pm");
        comboBox1.addItem("movie3_800pm");
        comboBox1.addItem("movie4_600pm");
        comboBox1.addItem("movie4_800pm");

        comboBox1.setSelectedIndex(0);

        loadFile();

        comboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) e.getItem();
                    filePath = "src/resources/" + selectedItem + ".txt";
                    loadFile();
                }
            }
        });

        saveChangesButton.addActionListener(e -> {
            try {
                Files.write(Paths.get(filePath), txtText.getText().getBytes());
                JOptionPane.showMessageDialog(frame, "Changes saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                System.out.println("Error saving file" + ex.getMessage());
                ex.printStackTrace();
            }
        });

        loadFile();

    }

    private void loadFile() {
        try {
            System.out.println("Loading file: " + filePath);
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            txtText.setText(content);
        } catch (IOException e) {
            System.out.println("Error loading file" + e.getMessage());
            e.printStackTrace();
        }
    }

}
