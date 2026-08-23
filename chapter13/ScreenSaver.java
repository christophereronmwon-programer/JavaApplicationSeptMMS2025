package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class ScreenSaver extends JPanel {
    Random r = new Random();
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 100; i ++ ) g.drawLine(r.nextInt(Math.max(1, getWidth())), r.nextInt(Math.max(1, getHeight())), r.nextInt(Math.max(1, getWidth())), r.nextInt(Math.max(1, getHeight())));
        repaint();
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.18", new ScreenSaver(), 700, 450);
    }
}
