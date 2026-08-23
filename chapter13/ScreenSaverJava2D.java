package chapter13;
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class ScreenSaverJava2D extends JPanel implements ActionListener {
    Random r = new Random();
    javax.swing.Timer timer = new javax.swing.Timer(300, this);
    int count;
    ScreenSaverJava2D() {
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D x = (Graphics2D) g;
        for (int i = 0; i < count; i ++ ) {
            int a = r.nextInt(Math.max(1, getWidth() - 100)), b = r.nextInt(Math.max(1, getHeight() - 100));
            int w = 30 + r.nextInt(70), h = 30 + r.nextInt(70);
            Color c1 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)), c2 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            x.setPaint(new GradientPaint(a, b, c1, a + w, b + h, c2, true));
            if (r.nextBoolean()) x.fill(new Rectangle2D.Double(a, b, w, h));
            else x.fill(new Ellipse2D.Double(a, b, w, h));
        }
    }
    public void actionPerformed(ActionEvent e) {
        if ( ++ count > 40) count = 1;
        repaint();
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.22", new ScreenSaverJava2D(), 700, 450);
    }
}
