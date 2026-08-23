package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class RandomLines extends JPanel {
    Random r = new Random();
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        for (int i = 0; i < 30; i ++ ) {
            x.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            x.setStroke(new BasicStroke(1 + r.nextInt(6)));
            x.draw(new Line2D.Double(r.nextInt(getWidth()), r.nextInt(getHeight()), r.nextInt(getWidth()), r.nextInt(getHeight())));
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.8", new RandomLines(), 600, 400);
    }
}
