package chapter13;
import javax.swing.*; import java.awt.*; import java.awt.geom.*; import java.awt.event.*; import java.util.*;
public class GridDrawRect extends JPanel{protected void paintComponent(Graphics g){super.paintComponent(g);int n=10,c=Math.min(getWidth(),getHeight())/n;for(int r=0;r<n;r++)for(int col=0;col<n;col++)g.drawRect(col*c,r*c,c,c);}public static void main(String[]a){ConcentricCirclesArc.show("13.13",new GridDrawRect(),450,450);}}
