package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class RandomTriangles extends JPanel {
    Random r = new Random();
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        for (int i = 0; i < 20; i ++ ) {
            int px = r.nextInt(Math.max(1, getWidth() - 100)), py = 50 + r.nextInt(Math.max(1, getHeight() - 100)), s = 20 + r.nextInt(70);
            GeneralPath p = new GeneralPath();
            p.moveTo(px, py);
            p.lineTo(px + s, py);
            p.lineTo(px + s / 2, py - s);
            p.closePath();
            x.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            x.fill(p);
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.9", new RandomTriangles(), 600, 400);
    }
}
