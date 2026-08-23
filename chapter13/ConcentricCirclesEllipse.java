package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class ConcentricCirclesEllipse extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        int cx = getWidth() / 2, cy = getHeight() / 2;
        for (int i = 0; i < 8; i ++ ) {
            double d = 40 + i * 20;
            x.draw(new Ellipse2D.Double(cx - d / 2, cy - d / 2, d, d));
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.7", new ConcentricCirclesEllipse(), 400, 400);
    }
}
