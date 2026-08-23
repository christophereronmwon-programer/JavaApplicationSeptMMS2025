package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class Tetrahedron extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        int cx = getWidth() / 2;
        GeneralPath p = new GeneralPath();
        p.moveTo(cx, 60);
        p.lineTo(cx - 130, 320);
        p.lineTo(cx + 130, 320);
        p.closePath();
        x.draw(p);
        x.drawLine(cx, 60, cx, 210);
        x.drawLine(cx - 130, 320, cx, 210);
        x.drawLine(cx + 130, 320, cx, 210);
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.15", new Tetrahedron(), 500, 400);
    }
}
