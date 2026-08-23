package chapter12;

import javax.swing.*;
import java.awt.*;

public class ColorSelectGUI extends JFrame {

    public ColorSelectGUI() {
        super("ColorSelect");

        setLayout(new BorderLayout(5, 5));

        JComboBox<String> colorCombo =
                new JComboBox<>(new String[]{"RED", "GREEN", "BLUE", "YELLOW", "BLACK"});

        JPanel top = new JPanel(new BorderLayout());
        top.add(colorCombo, BorderLayout.CENTER);

        JCheckBox background = new JCheckBox("Background");
        JCheckBox foreground = new JCheckBox("Foreground");

        JPanel options = new JPanel();
        options.add(background);
        options.add(foreground);

        JPanel bottom = new JPanel();
        bottom.add(new JButton("Ok"));
        bottom.add(new JButton("Cancel"));

        add(top, BorderLayout.NORTH);
        add(options, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 140);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorSelectGUI().setVisible(true));
    }
}
