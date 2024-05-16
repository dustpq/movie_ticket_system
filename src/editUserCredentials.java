import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class editUserCredentials {
    private JPanel panel1;
    private JTextArea txtArea;
    private JButton saveChangesButton;

    public editUserCredentials() {
        JFrame frame = new JFrame("Edit User Credentials");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        String filePath = "src/resources/users.txt";
        txtArea.setText(loadFile(filePath));
        txtArea.setEditable(true);

        saveChangesButton.addActionListener(e -> {
            try {
                Files.write(Paths.get(filePath), txtArea.getText().getBytes());
                JOptionPane.showMessageDialog(frame, "Changes saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                System.out.println("Error saving file" + ex.getMessage());
                ex.printStackTrace();
            }
        });

    }

    private String loadFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Error loading file" + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

}
