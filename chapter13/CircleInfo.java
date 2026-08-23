package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class CircleInfo extends JPanel {
    JTextField r = new JTextField("50", 5), x = new JTextField("250", 5), y = new JTextField("200", 5);
    double rad, cx, cy;
    JLabel info = new JLabel();
    CircleInfo() {
        JPanel p = new JPanel();
        p.add(new JLabel("Radius"));
        p.add(r);
        p.add(new JLabel("X"));
        p.add(x);
        p.add(new JLabel("Y"));
        p.add(y);
        JButton b = new JButton("Draw");
        p.add(b);
        b.addActionListener(e -> read());
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(info, BorderLayout.SOUTH);
    }
    void read() {
        try {
            rad = Double.parseDouble(r.getText());
            cx = Double.parseDouble(x.getText());
            cy = Double.parseDouble(y.getText());
            info.setText(String.format("Diameter: %.2f  Circumference: %.2f  Area: %.2f", 2 * rad, 2 * Math.PI * rad, Math.PI * rad * rad));
            repaint();
        } catch (Exception e) {
            info.setText("Enter valid numbers.");
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rad > 0)((Graphics2D) g).draw(new Ellipse2D.Double(cx - rad, cy - rad, 2 * rad, 2 * rad));
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.17", new CircleInfo(), 700, 500);
    }
}
