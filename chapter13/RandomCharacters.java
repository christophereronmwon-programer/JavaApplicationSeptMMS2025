package chapter13;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
public class RandomCharacters extends JPanel {
    Random r = new Random();
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String[] fs = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < 80; i ++ ) {
            g.setFont(new Font(fs[r.nextInt(fs.length)], Font.PLAIN, 12 + r.nextInt(35)));
            g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            g.drawString("" + chars.charAt(r.nextInt(chars.length())), r.nextInt(Math.max(1, getWidth() - 20)), 20 + r.nextInt(Math.max(1, getHeight() - 20)));
        }
    }
    public static void main(String[] a) {
        ConcentricCirclesArc.show("13.10", new RandomCharacters(), 700, 450);
    }
}
