package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class GridLine2D extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        int n = 8, c = Math.min(getWidth(), getHeight()) / n;
        for (int i = 0; i <= n; i ++ ) {
            x.draw(new Line2D.Double(0, i * c, n * c, i * c));
            x.draw(new Line2D.Double(i * c, 0, i * c, n * c));
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.12", new GridLine2D(), 450, 450);
    }
}
