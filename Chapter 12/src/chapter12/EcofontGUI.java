package chapter12;

import javax.swing.*;
import java.awt.*;

public class EcofontGUI extends JFrame {
    private final JTextArea textArea = new JTextArea("Type your text here.", 8, 35);
    private int fontSize = 9;

    public EcofontGUI() {
        super("12.19 Ecofont");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        applyFont();

        JButton increase = new JButton("Increase Font Size");
        JButton decrease = new JButton("Decrease Font Size");

        increase.addActionListener(e -> {
            fontSize++;
            applyFont();
        });

        decrease.addActionListener(e -> {
            if (fontSize > 1) {
                fontSize--;
                applyFont();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(increase);
        buttons.add(decrease);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void applyFont() {
        // Install Spranq_eco_sans_regular.ttf on the computer first.
        Font font = new Font("Spranq eco sans", Font.PLAIN, fontSize);
        textArea.setFont(font);
        setTitle("12.19 Ecofont - " + fontSize + " points");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EcofontGUI().setVisible(true));
    }
}
