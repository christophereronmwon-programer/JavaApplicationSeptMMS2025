package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class PieChart extends JPanel {
    JTextField[] f = {
        new JTextField("25", 4), new JTextField("25", 4), new JTextField("25", 4), new JTextField("25", 4)
    };
    double[] v = {
        25, 25, 25, 25
    };
    Color[] c = {
        Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE
    };
    PieChart() {
        JPanel p = new JPanel();
        for (int i = 0; i < 4; i ++ ) {
            p.add(new JLabel("Value" + (i + 1)));
            p.add(f[i]);
        }
        JButton b = new JButton("Draw");
        p.add(b);
        b.addActionListener(e -> {
            try {
                for (int i = 0; i < 4; i ++ ) v[i] = Double.parseDouble(f[i].getText()); repaint();
            } catch (Exception z) {
            }
        });
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        double total = 0;
        for (double z: v) total += Math.max(0, z);
        double start = 0;
        for (int i = 0; i < 4; i ++ ) {
            double extent = total == 0 ? 0: 360 * v[i] / total;
            x.setColor(c[i]);
            x.fill(new Arc2D.Double(180, 100, 300, 300, start, extent, Arc2D.PIE));
            start += extent;
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.27", new PieChart(), 700, 500);
    }
}
