package chapter12;

import javax.swing.*;
import java.awt.*;

public class PrinterGUI extends JFrame {

    public PrinterGUI() {
        super("Printer");

        setLayout(new BorderLayout(8, 5));

        JLabel printerLabel = new JLabel("Printer: MyPrinter");

        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JPanel checkPanel = new JPanel(new GridLayout(3, 1));
        checkPanel.add(new JCheckBox("Image"));
        checkPanel.add(new JCheckBox("Text"));
        checkPanel.add(new JCheckBox("Code"));

        JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        JRadioButton selection = new JRadioButton("Selection");
        JRadioButton all = new JRadioButton("All", true);
        JRadioButton applet = new JRadioButton("Applet");

        ButtonGroup group = new ButtonGroup();
        group.add(selection);
        group.add(all);
        group.add(applet);

        radioPanel.add(selection);
        radioPanel.add(all);
        radioPanel.add(applet);

        JPanel blankLeft = new JPanel();
        blankLeft.setPreferredSize(new Dimension(45, 60));

        JPanel blankRight = new JPanel();
        blankRight.setPreferredSize(new Dimension(45, 60));

        gbc.gridx = 0;
        gbc.gridy = 0;
        center.add(blankLeft, gbc);

        gbc.gridx = 1;
        center.add(checkPanel, gbc);

        gbc.gridx = 2;
        center.add(radioPanel, gbc);

        gbc.gridx = 3;
        center.add(blankRight, gbc);

        JPanel bottomLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomLeft.add(new JLabel("Print Quality:"));
        bottomLeft.add(new JComboBox<>(new String[]{"High", "Medium", "Low"}));
        bottomLeft.add(new JCheckBox("Print to File"));

        JPanel buttons = new JPanel(new GridLayout(4, 1, 3, 3));
        buttons.add(new JButton("OK"));
        buttons.add(new JButton("Cancel"));
        buttons.add(new JButton("Setup..."));
        buttons.add(new JButton("Help"));

        add(printerLabel, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottomLeft, BorderLayout.SOUTH);
        add(buttons, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 220);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrinterGUI().setVisible(true));
    }
}
