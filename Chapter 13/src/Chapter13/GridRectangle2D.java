package chapter13;
import javax.swing.*; import java.awt.*; import java.awt.geom.*; import java.awt.event.*; import java.util.*;
public class GridRectangle2D extends JPanel{protected void paintComponent(Graphics g){super.paintComponent(g);Graphics2D x=(Graphics2D)g;int n=10,c=Math.min(getWidth(),getHeight())/n;for(int r=0;r<n;r++)for(int col=0;col<n;col++)x.draw(new Rectangle2D.Double(col*c,r*c,c,c));}public static void main(String[]a){ConcentricCirclesArc.show("13.14",new GridRectangle2D(),450,450);}}
