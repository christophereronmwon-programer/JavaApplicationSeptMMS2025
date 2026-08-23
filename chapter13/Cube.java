package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class Cube extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        int a = 130, b = 100, s = 180, d = 65;
        x.drawRect(a, b, s, s);
        x.drawRect(a + d, b - d, s, s);
        x.drawLine(a, b, a + d, b - d);
        x.drawLine(a + s, b, a + s + d, b - d);
        x.drawLine(a, b + s, a + d, b + s - d);
        x.drawLine(a + s, b + s, a + s + d, b + s - d);
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.16", new Cube(), 500, 450);
    }
}
