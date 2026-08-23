package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class LowVisionGUI extends JFrame {
    JTextArea text = new JTextArea();
    JComboBox < String > fonts = new JComboBox < > (new String[] {
        "Serif", "Sans-serif", "Monospaced"
    });
    JCheckBox bold = new JCheckBox("Bold");
    int size = 18;
    LowVisionGUI() {
        super("13.32 Large-Type Display");
        JPanel p = new JPanel();
        JButton up = new JButton("Increase Font Size"), down = new JButton("Decrease Font Size");
        for (JComponent c: new JComponent[] {
            fonts, bold, up, down
        }) c.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        p.add(fonts);
        p.add(bold);
        p.add(up);
        p.add(down);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        fonts.addActionListener(e -> update());
        bold.addActionListener(e -> update());
        up.addActionListener(e -> {
            size ++ ; update();
        });
        down.addActionListener(e -> {
            if (size > 1) size -- ; update();
        });
        add(p, BorderLayout.NORTH);
        add(new JScrollPane(text));
        update();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
    }
    void update() {
        text.setFont(new Font((String) fonts.getSelectedItem(), bold.isSelected() ? Font.BOLD: Font.PLAIN, size));
    }
    public static void main(String[] a) {
        SwingUtilities.invokeLater(() -> new LowVisionGUI().setVisible(true));
    }
}
