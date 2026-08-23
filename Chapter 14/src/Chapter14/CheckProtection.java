package chapter14;
import javax.swing.*;
import java.awt.*;
import java.text.*;
public class CheckProtection extends JFrame {
    JTextField in = new JTextField("99.87", 12);
    JLabel out = new JLabel(" ");
    public CheckProtection() {
        super("14.20 Check Protection");
        setLayout(new FlowLayout());
        add(new JLabel("$"));
        add(in);
        JButton b = new JButton("Protect");
        add(b);
        add(out);
        b.addActionListener(e -> {
            try {
                double v = Double.parseDouble(in.getText()); String s = String.format("%.2f", v); out.setText(String.format("%9s", s).replace(' ', '*'));
            } catch (Exception x) {
                out.setText("Invalid amount.");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 130);
        setLocationRelativeTo(null);
    }
    public static void main(String[] z) {
        new CheckProtection().setVisible(true);
    }
}
