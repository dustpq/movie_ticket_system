import javax.swing.*;
import javax.swing.event.ChangeListener;

public class guestConcessions {
    private JPanel panel1;
    private JSpinner soda_spinner;
    private JSpinner popcorn_spinner;
    private JSpinner hotdog_spinner;
    private JSpinner candy_spinner;
    private JLabel popcorn_emoji;
    private JLabel soda_emoji;
    private JLabel candy_box_emoji;
    private JLabel hotdog_emoji;
    private JTextField totalAmount;
    private JButton printRecieptButton;
    private JLabel totalPrice;
    private JTextField taxAmount;
    private JLabel taxLabel;

    public guestConcessions() {

        JFrame frame = new JFrame("Concessions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        ChangeListener changeListener = e -> {

            double total = Integer.parseInt(popcorn_spinner.getValue().toString()) * 5 +
                    Integer.parseInt(soda_spinner.getValue().toString()) * 3 +
                    Integer.parseInt(candy_spinner.getValue().toString()) * 2 +
                    Integer.parseInt(hotdog_spinner.getValue().toString()) * 4;

            double tax = total * 0.06;

            taxAmount.setText((String.format("$%.2f", tax)));
            totalAmount.setText((String.format("$%.2f", (tax + total))));

        };

        popcorn_spinner.setValue(0);
        soda_spinner.setValue(0);
        candy_spinner.setValue(0);
        hotdog_spinner.setValue(0);
        taxAmount.setText("$0.00");
        totalAmount.setText("$0.00");

        SpinnerNumberModel plimiter = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel slimiter = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel climiter = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel hlimiter = new SpinnerNumberModel(0, 0, 100, 1);

        popcorn_spinner.setModel(plimiter);
        soda_spinner.setModel(slimiter);
        candy_spinner.setModel(climiter);
        hotdog_spinner.setModel(hlimiter);

        soda_spinner.addChangeListener(changeListener);
        popcorn_spinner.addChangeListener(changeListener);
        hotdog_spinner.addChangeListener(changeListener);
        candy_spinner.addChangeListener(changeListener);

        printRecieptButton.addActionListener(e -> {
            double total = Double.parseDouble(totalAmount.getText().substring(1));
            double tax = Double.parseDouble(taxAmount.getText().substring(1));

            JOptionPane.showMessageDialog(null, "Receipt:\n\n" +
                    soda_spinner.getValue() + " popcorn: $" + Integer.parseInt(popcorn_spinner.getValue().toString()) * 5 + "\n" +
                    popcorn_spinner.getValue() + " soda: $" + Integer.parseInt(soda_spinner.getValue().toString()) * 3 + "\n" +
                    hotdog_spinner.getValue() + " candy box: $" + Integer.parseInt(candy_spinner.getValue().toString()) * 2 + "\n" +
                    candy_spinner.getValue() + " hotdog: $" + Integer.parseInt(hotdog_spinner.getValue().toString()) * 4 + "\n\n" +
                    "Tax: " + taxAmount.getText() + "\n" +
                    "Total: " + totalAmount.getText() + "\n\n" +
                    "Please be sure to finalize your selection with a cashier and a picture of this receipt. " + "\n"+
                    "Thank you for your purchase!",
                    "Receipt", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();
        });
    }
}