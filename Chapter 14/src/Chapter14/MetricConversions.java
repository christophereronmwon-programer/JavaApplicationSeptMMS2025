package chapter14;
import javax.swing.*;
import java.awt.*;
public class MetricConversions extends JFrame {
    JTextField value = new JTextField(8), from = new JTextField(12), to = new JTextField(12);
    JLabel out = new JLabel(" ");
    public MetricConversions() {
        super("14.23 Metric Conversions");
        setLayout(new FlowLayout());
        add(value);
        add(from);
        add(new JLabel("to"));
        add(to);
        JButton b = new JButton("Convert");
        add(b);
        add(out);
        b.addActionListener(e -> convert());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 140);
        setLocationRelativeTo(null);
    }
    void convert() {
        try {
            double v = Double.parseDouble(value.getText());
            String a = from.getText().toLowerCase(), b = to.getText().toLowerCase();
            double base;
            if (a.equals("meters")) base = v;
            else if (a.equals("centimeters")) base = v / 100;
            else if (a.equals("kilometers")) base = v * 1000;
            else if (a.equals("inches")) base = v * 0.0254;
            else if (a.equals("feet")) base = v * 0.3048;
            else if (a.equals("yards")) base = v * 0.9144;
            else if (a.equals("miles")) base = v * 1609.344;
            else {
                out.setText("Unknown source unit.");
                return;
            }
            double ans;
            if (b.equals("meters")) ans = base;
            else if (b.equals("centimeters")) ans = base * 100;
            else if (b.equals("kilometers")) ans = base / 1000;
            else if (b.equals("inches")) ans = base / 0.0254;
            else if (b.equals("feet")) ans = base / 0.3048;
            else if (b.equals("yards")) ans = base / 0.9144;
            else if (b.equals("miles")) ans = base / 1609.344;
            else {
                out.setText("Unknown target unit.");
                return;
            }
            out.setText(String.format("%.4f %s", ans, b));
        } catch (Exception x) {
            out.setText("Invalid conversion.");
        }
    }
    public static void main(String[] z) {
        new MetricConversions().setVisible(true);
    }
}
