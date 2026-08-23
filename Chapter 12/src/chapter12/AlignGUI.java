package chapter12;

import javax.swing.*;
import java.awt.*;

public class AlignGUI extends JFrame {

    public AlignGUI() {
        super("Align");

        setLayout(new BorderLayout(10, 5));

        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 5, 3, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JCheckBox snapToGrid = new JCheckBox("Snap to Grid");
        JCheckBox showGrid = new JCheckBox("Show Grid");

        JTextField xField = new JTextField("8", 4);
        JTextField yField = new JTextField("8", 4);

        gbc.gridx = 0; gbc.gridy = 0;
        center.add(snapToGrid, gbc);

        gbc.gridx = 1;
        center.add(new JLabel("X:"), gbc);

        gbc.gridx = 2;
        center.add(xField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        center.add(showGrid, gbc);

        gbc.gridx = 1;
        center.add(new JLabel("Y:"), gbc);

        gbc.gridx = 2;
        center.add(yField, gbc);

        JPanel buttons = new JPanel(new GridLayout(3, 1, 4, 4));
        buttons.add(new JButton("Ok"));
        buttons.add(new JButton("Cancel"));
        buttons.add(new JButton("Help"));

        add(center, BorderLayout.CENTER);
        add(buttons, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlignGUI().setVisible(true));
    }
}
