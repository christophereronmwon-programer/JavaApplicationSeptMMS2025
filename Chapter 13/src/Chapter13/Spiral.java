package chapter13;
import javax.swing.*; import java.awt.*; import java.awt.geom.*; import java.awt.event.*; import java.util.*;
public class Spiral extends JPanel{protected void paintComponent(Graphics g){super.paintComponent(g);int n=700,cx=getWidth()/2,cy=getHeight()/2;int[] xs=new int[n],ys=new int[n];double a=0,r=2;for(int i=0;i<n;i++){xs[i]=(int)(cx+r*Math.cos(a));ys[i]=(int)(cy+r*Math.sin(a));a+=.18;r+=.45;}g.drawPolyline(xs,ys,n);}public static void main(String[]a){ConcentricCirclesArc.show("13.26",new Spiral(),650,650);}}
