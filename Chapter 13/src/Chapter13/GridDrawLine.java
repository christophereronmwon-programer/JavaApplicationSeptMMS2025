package chapter13;
import javax.swing.*; import java.awt.*; import java.awt.geom.*; import java.awt.event.*; import java.util.*;
public class GridDrawLine extends JPanel{protected void paintComponent(Graphics g){super.paintComponent(g);int n=8,c=Math.min(getWidth(),getHeight())/n;for(int i=0;i<=n;i++){g.drawLine(0,i*c,n*c,i*c);g.drawLine(i*c,0,i*c,n*c);}}public static void main(String[]a){ConcentricCirclesArc.show("13.11",new GridDrawLine(),450,450);}}
