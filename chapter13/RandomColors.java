package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class RandomColors extends JPanel {
    Random r = new Random();
    String shape = "Rectangle";
    Color[] colors = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    RandomColors() {
        JComboBox < String > b = new JComboBox < > (new String[] {
            "Rectangle", "Oval", "Line"
        });
        b.addActionListener(e -> {
            shape = (String) b.getSelectedItem(); repaint();
        });
        add(b);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 20; i ++ ) {
            int x = r.nextInt(Math.max(1, getWidth() - 80)), y = 40 + r.nextInt(Math.max(1, getHeight() - 100)), w = 20 + r.nextInt(70), h = 20 + r.nextInt(70);
            g.setColor(colors[r.nextInt(13)]);
            if (shape.equals("Rectangle")) g.drawRect(x, y, w, h);
            else if (shape.equals("Oval")) g.drawOval(x, y, w, h);
            else g.drawLine(x, y, x + w, y + h);
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.29", new RandomColors(), 650, 450);
    }
}
